package com.nttdata.proyecto1bc43.model;

import com.nttdata.proyecto1bc43.exception.InsufficientBalanceException;
import io.reactivex.rxjava3.core.Completable;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class AccountBank {
    private String numero;
    private String tipo;
    private double saldo;
    private String clienteId;
    private BigDecimal balance;
    private BigDecimal minimumOpeningAmount;

    public void debit(BigDecimal amount) {
        BigDecimal newBalance = balance.subtract(amount);
        if (newBalance.compareTo(BigDecimal.ZERO) < 0) {
            throw new InsufficientBalanceException("Saldo insuficiente en la cuenta");
        }
        balance = newBalance;
    }
    public void credit(BigDecimal amount) {
        balance = balance.add(amount);
    }



}
