package com.nttdata.proyecto1bc43.controller;

import com.nttdata.proyecto1bc43.model.Client;
import com.nttdata.proyecto1bc43.service.ClientService;
import io.reactivex.rxjava3.core.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/clients")
public class ClientController {
    private ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public Single<Client> createClient(@RequestBody Client client) {
        return clientService.createClient(client);
    }

    @GetMapping("/{id}")
    public Maybe<Client> getClient(@PathVariable("id") String id) {
        return clientService.getClient(id);
    }

    @PutMapping("/{id}")
    public Single<Client> updateClient(@PathVariable("id") String id, @RequestBody Client client) {
        client.setId(id);
        return clientService.updateClient(client);
    }

    @DeleteMapping("/{id}")
    public Completable deleteClient(@PathVariable("id") String id) {
        return clientService.deleteClient(id);
    }

    @GetMapping
    public Flowable<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/{clientId}/cuentas")
    public Flowable<String> obtenerCuentasBancarias(@PathVariable String clientId) {
        return clientService.obtenerCuentasBancarias(clientId).toFlowable(BackpressureStrategy.BUFFER);
    }

    @GetMapping("/{clientId}/creditos")
    public Flowable<String> obtenerProductosCredito(@PathVariable String clientId) {
        return clientService.obtenerProductosCredito(clientId).toFlowable(BackpressureStrategy.BUFFER);
    }

    @GetMapping("/{clientId}/tarjetas")
    public Flowable<String> obtenerTarjetasCredito(@PathVariable String clientId) {
        return clientService.obtenerTarjetasCredito(clientId).toFlowable(BackpressureStrategy.BUFFER);
    }




}