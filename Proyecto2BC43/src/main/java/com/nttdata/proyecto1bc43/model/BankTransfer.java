package com.nttdata.proyecto1bc43.model;


import lombok.*;

import java.math.BigDecimal;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class BankTransfer {
    private String id;
    private String sourceAccountId;
    private String targetAccountId;
    private BigDecimal amount;

    public BankTransfer(String sourceAccountId, String targetAccountId, BigDecimal amount) {
        this.sourceAccountId = sourceAccountId;
        this.targetAccountId = targetAccountId;
        this.amount = amount;
    }
}
