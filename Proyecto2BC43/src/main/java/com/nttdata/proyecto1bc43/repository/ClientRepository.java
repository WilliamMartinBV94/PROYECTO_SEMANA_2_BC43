package com.nttdata.proyecto1bc43.repository;

import com.nttdata.proyecto1bc43.model.Client;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ClientRepository extends MongoRepository<Client, String> {

}