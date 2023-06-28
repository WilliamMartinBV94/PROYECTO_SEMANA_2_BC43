package com.nttdata.proyecto1bc43.model;

import lombok.Data;

@Data
public class AccountBank {
    private String numero;
    private String tipo;
    private double saldo;
    private String clienteId;

    // Constructor, getters y setters
}
