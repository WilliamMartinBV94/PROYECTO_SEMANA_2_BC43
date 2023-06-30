package com.nttdata.proyecto1bc43.model;

import lombok.Data;

import java.util.List;

@Data
public class Client {
    private String id;
    private String nombre;
    private String tipo;
    private List<String> cuentasBancarias;
    private List<String> productosCredito;
    private List<String> tarjetasCredito;

}
