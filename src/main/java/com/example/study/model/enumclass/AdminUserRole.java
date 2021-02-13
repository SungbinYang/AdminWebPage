package com.example.study.model.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum AdminUserRole {

    ADMIN(0, "관리자", "관리자 모드"),
    PARTNER(1, "파트너", "파트너 모드"),
    CUSTOMER(2, "손님", "손님 모드");

    private Integer id;
    private String title;
    private String description;
}
