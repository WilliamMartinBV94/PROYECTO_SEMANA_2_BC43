package com.nttdata.proyecto1bc43.repository;

import com.nttdata.proyecto1bc43.model.CreditCard;
import io.reactivex.rxjava3.core.Flowable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CreditCardRepository extends MongoRepository<CreditCard, String> {
    Flowable<CreditCard> findByClientId(String clientId);
}
