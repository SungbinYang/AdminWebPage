package com.example.study.service;

import com.example.study.model.entity.Item;
import com.example.study.model.network.Header;
import com.example.study.model.network.Pagination;
import com.example.study.model.network.request.ItemApiRequest;
import com.example.study.model.network.response.ItemApiResponse;
import com.example.study.repository.PartnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemApiLogicService extends BaseService<ItemApiRequest, ItemApiResponse, Item> {

    private final PartnerRepository partnerRepository;

    @Override
    public Header<ItemApiResponse> create(Header<ItemApiRequest> request) {

        return Optional.ofNullable(request.getData())
                .map(body ->{
                    Item item = Item.builder()
                            .status(body.getStatus())
                            .name(body.getName())
                            .title(body.getTitle())
                            .content(body.getContent())
                            .price(body.getPrice())
                            .brandName(body.getBrandName())
                            .registeredAt(LocalDateTime.now())
                            .partner(partnerRepository.getOne(body.getPartnerId()))
                            .build();

                    return item;
                })
                .map(newItem -> baseRepository.save(newItem))
                .map(this::response)
                .map(Header::OK)
                .orElseGet(()->Header.Error("데이터 없음"));
    }

    @Override
    public Header<ItemApiResponse> read(Long id) {

        return baseRepository.findById(id)
                .map(this::response)
                .map(Header::OK)
                .orElseGet(() -> Header.Error("데이터 없음"));
    }

    @Override
    public Header<ItemApiResponse> update(Header<ItemApiRequest> request) {

        return Optional.ofNullable(request.getData())
                .map(body ->{
                    return baseRepository.findById(body.getId());
                })
                .filter(Optional::isPresent)
                .map(Optional::get)
                .map(item -> {

                    ItemApiRequest body = request.getData();
                    item.setStatus(body.getStatus())
                            .setTitle(body.getTitle())
                            .setContent(body.getContent())
                            .setName(body.getName())
                            .setPrice(body.getPrice())
                            .setBrandName(body.getBrandName())
                            .setPartner(partnerRepository.getOne(body.getPartnerId()))
                            .setStatus(body.getStatus())
                            .setRegisteredAt(body.getRegisteredAt())
                            .setUnregisteredAt(body.getUnregisteredAt())
                    ;
                    return item;

                })
                .map(changeItem -> baseRepository.save(changeItem))
                .map(this::response)
                .map(Header::OK)
                .orElseGet(()->Header.Error("데이터 없음"));

    }

    @Override
    public Header delete(Long id) {

        return baseRepository.findById(id)
                .map(item -> {
                    baseRepository.delete(item);
                    return Header.OK();
                })
                .orElseGet(() -> Header.Error("데이터 없음"));
    }

    public ItemApiResponse response(Item item) {

        return ItemApiResponse.builder()
                .id(item.getId())
                .status(item.getStatus())
                .name(item.getName())
                .title(item.getTitle())
                .content(item.getContent())
                .price(item.getPrice())
                .brandName(item.getBrandName())
                .registeredAt(item.getRegisteredAt())
                .unregisteredAt(item.getUnregisteredAt())
                .partnerId(item.getPartner().getId())
                .build();
    }

    public Header<List<ItemApiResponse>> search(Pageable pageable) {

        Page<Item> items = baseRepository.findAll(pageable);

        List<ItemApiResponse> itemApiResponseList = items.stream()
                .map(this::response)
                .collect(Collectors.toList());

        Pagination pagination = Pagination.builder()
                .totalPages(items.getTotalPages())
                .totalElements(items.getTotalElements())
                .currentPage(items.getNumber())
                .currentElements(items.getNumberOfElements())
                .build();

        return Header.OK(itemApiResponseList, pagination);
    }
}
