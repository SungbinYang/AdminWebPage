package com.example.study.model.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderDetailStatus {

    ORDERING(0, "등록", "주문 등록 상태"),
    COMPLETE(1, "해지", "주문 해지 상태"),
    CONFIRM(2, "검수(대기)", "주문 검수 상태");

    private Integer id;
    private String title;
    private String description;
}
