package com.nttdata.proyecto1bc43.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Credit {
    private String creditNumber;
    private String client;
    private BigDecimal amount;
    private String creditType;
    private int term;
    private double interestRate;
    private String status;
    private Date creationDate;
}
