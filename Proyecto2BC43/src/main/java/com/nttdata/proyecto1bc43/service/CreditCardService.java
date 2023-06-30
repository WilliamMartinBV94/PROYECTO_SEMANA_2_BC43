package com.nttdata.proyecto1bc43.service;

import com.nttdata.proyecto1bc43.model.CreditCard;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;

public interface CreditCardService {
    Single<CreditCard> createCreditCard(CreditCard creditCard);
    Maybe<CreditCard> getCreditCard(String creditCardNumber);
    Single<CreditCard> updateCreditCard(CreditCard creditCard);
    Completable deleteCreditCard(String creditCardNumber);
    Flowable<CreditCard> getAllCreditCards();
    Iterable<CreditCard> getCreditCardsByClientId(String clientId);
}
