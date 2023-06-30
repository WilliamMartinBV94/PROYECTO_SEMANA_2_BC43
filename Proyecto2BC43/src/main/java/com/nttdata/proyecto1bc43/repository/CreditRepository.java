package com.nttdata.proyecto1bc43.repository;

import com.nttdata.proyecto1bc43.model.Credit;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CreditRepository extends MongoRepository<Credit, String> {

}
