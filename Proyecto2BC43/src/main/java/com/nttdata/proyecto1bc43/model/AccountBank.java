package com.nttdata.proyecto1bc43.model;

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

    public Completable validateMinimumOpeningAmount() {
        return Completable.fromAction(() -> {
            if (balance.compareTo(minimumOpeningAmount) < 0) {
                throw new RuntimeException("El monto mínimo de apertura no se ha alcanzado.");
            }
        });
    }
}
