package com.nttdata.proyecto1bc43.model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class CreditCard {
    private String creditCardNumber;
    private String clientId;
    private BigDecimal creditLimit;
    private BigDecimal availableBalance;
    private LocalDate expirationDate;
    private String status;
    private LocalDateTime creationDate;

}
