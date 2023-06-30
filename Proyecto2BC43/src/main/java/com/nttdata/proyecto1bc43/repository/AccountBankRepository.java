package com.nttdata.proyecto1bc43.repository;

import com.nttdata.proyecto1bc43.model.AccountBank;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface AccountBankRepository extends MongoRepository<AccountBank, String> {
}