package com.example.study.controller.api;

import com.example.study.controller.CrudController;
import com.example.study.model.entity.Category;
import com.example.study.model.network.Header;
import com.example.study.model.network.request.CategoryApiRequest;
import com.example.study.model.network.response.CategoryApiResponse;
import com.example.study.service.CategoryApiLogicService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/category")
@RequiredArgsConstructor
public class CategoryApiController extends CrudController<CategoryApiRequest, CategoryApiResponse, Category> {

    private final CategoryApiLogicService categoryApiLogicService;

    @GetMapping("")
    public Header<List<CategoryApiResponse>> findAll(@PageableDefault(sort = {"id"}, direction = Sort.Direction.ASC) Pageable pageable) {
        log.info("{}", pageable);
        return categoryApiLogicService.search(pageable);
    }

}
