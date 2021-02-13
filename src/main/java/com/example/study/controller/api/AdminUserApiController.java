package com.example.study.controller.api;

import com.example.study.controller.CrudController;
import com.example.study.model.entity.AdminUser;
import com.example.study.model.network.Header;
import com.example.study.model.network.request.AdminUserApiRequest;
import com.example.study.model.network.response.AdminUserApiResponse;
import com.example.study.model.network.response.CategoryApiResponse;
import com.example.study.service.AdminUserApiLogicService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/api/adminUser")
@RequiredArgsConstructor
public class AdminUserApiController extends CrudController<AdminUserApiRequest, AdminUserApiResponse, AdminUser> {

    private final AdminUserApiLogicService adminUserApiLogicService;

    @GetMapping("")
    public Header<List<AdminUserApiResponse>> findAll(@PageableDefault(sort = {"id"}, direction = Sort.Direction.ASC) Pageable pageable) {
        log.info("{}", pageable);
        return adminUserApiLogicService.search(pageable);
    }

}
