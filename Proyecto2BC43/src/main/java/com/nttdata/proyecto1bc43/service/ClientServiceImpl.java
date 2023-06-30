package com.nttdata.proyecto1bc43.service;
import com.nttdata.proyecto1bc43.model.Client;
import com.nttdata.proyecto1bc43.repository.ClientRepository;
import io.reactivex.rxjava3.core.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    private ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Single<Client> createClient(Client client) {
        return Single.fromCallable(() -> clientRepository.save(client));
    }

    @Override
    public Maybe<Client> getClient(String id) {
        return Maybe.fromCallable(() -> clientRepository.findById(id).orElse(null));
    }

    @Override
    public Single<Client> updateClient(Client client) {
        return Single.fromCallable(() -> clientRepository.save(client));
    }

    @Override
    public Completable deleteClient(String id) {
        return Completable.fromAction(() -> clientRepository.deleteById(id));
    }

    @Override
    public Flowable<Client> getAllClients() {
        return Flowable.fromIterable(clientRepository.findAll());
    }

    @Override
    public Observable<String> obtenerCuentasBancarias(String clientId) {
        return Single.fromCallable(() -> clientRepository.findById(clientId))
                .flatMapMaybe(optionalClient -> optionalClient.map(Maybe::just).orElse(Maybe.empty()))
                .map(Client::getCuentasBancarias)
                .flatMapObservable(Observable::fromIterable);
    }


    @Override
    public Observable<String> obtenerProductosCredito(String clientId) {
        return Single.fromCallable(() -> clientRepository.findById(clientId))
                .flatMapMaybe(optionalClient -> optionalClient.map(Maybe::just).orElse(Maybe.empty()))
                .map(Client::getProductosCredito)
                .flatMapObservable(Observable::fromIterable);
    }

    @Override
    public Observable<String> obtenerTarjetasCredito(String clientId) {
        return Single.fromCallable(() -> clientRepository.findById(clientId))
                .flatMapMaybe(optionalClient -> optionalClient.map(Maybe::just).orElse(Maybe.empty()))
                .map(Client::getTarjetasCredito)
                .flatMapObservable(Observable::fromIterable);
    }
}

