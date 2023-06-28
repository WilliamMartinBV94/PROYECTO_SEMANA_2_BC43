package com.nttdata.proyecto1bc43.service;
import com.nttdata.proyecto1bc43.model.Client;
import io.reactivex.rxjava3.core.*;

import java.util.List;

public interface ClientService {
    Single<Client> createClient(Client client);
    Maybe<Client> getClient(String id);
    Single<Client> updateClient(Client client);
    Completable deleteClient(String id);
    Flowable<Client> getAllClients();
    Observable<String> obtenerCuentasBancarias(String clientId);
    Observable<String> obtenerProductosCredito(String clientId);
    Observable<String> obtenerTarjetasCredito(String clientId);
}
