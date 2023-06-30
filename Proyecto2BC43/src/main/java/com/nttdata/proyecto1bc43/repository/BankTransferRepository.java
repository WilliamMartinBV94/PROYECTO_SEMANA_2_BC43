package com.nttdata.proyecto1bc43.repository;

import com.nttdata.proyecto1bc43.model.BankTransfer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BankTransferRepository extends MongoRepository<BankTransfer, String> {
}
