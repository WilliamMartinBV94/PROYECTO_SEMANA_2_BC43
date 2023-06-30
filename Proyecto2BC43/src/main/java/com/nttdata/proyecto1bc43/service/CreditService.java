package com.nttdata.proyecto1bc43.service;

import com.nttdata.proyecto1bc43.model.Credit;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;

public interface CreditService {
    Single<Credit> createCredit(Credit credit);
    Maybe<Credit> getCredit(String creditNumber);
    Single<Credit> updateCredit(Credit credit);
    Completable deleteCredit(String creditNumber);
    Flowable<Credit> getAllCredits();
}

