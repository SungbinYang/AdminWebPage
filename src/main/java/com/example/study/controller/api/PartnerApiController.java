package com.example.study.controller.api;

import com.example.study.controller.CrudController;
import com.example.study.model.entity.Partner;
import com.example.study.model.network.Header;
import com.example.study.model.network.request.PartnerApiRequest;
import com.example.study.model.network.response.PartnerApiResponse;
import com.example.study.service.PartnerApiLogicService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/partner")
@RequiredArgsConstructor
public class PartnerApiController extends CrudController<PartnerApiRequest, PartnerApiResponse, Partner> {

    private final PartnerApiLogicService partnerApiLogicService;

    @GetMapping("")
    public Header<List<PartnerApiResponse>> findAll(@PageableDefault(sort = {"id"}, direction = Sort.Direction.ASC) Pageable pageable) {
        log.info("{}", pageable);
        return partnerApiLogicService.search(pageable);
    }

}
