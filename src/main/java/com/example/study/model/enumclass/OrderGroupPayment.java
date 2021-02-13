package com.example.study.model.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum OrderGroupPayment {

    BANK_TRANSFER(0, "계좌이체", "계좌이체 결제"),
    CARD(1, "카드", "카드 결제"),
    CHECK_CARD(2, "카드", "체크카드 결제");

    private Integer id;
    private String title;
    private String description;
}
