package com.nttdata.proyecto1bc43.service;


import com.nttdata.proyecto1bc43.model.Credit;
import com.nttdata.proyecto1bc43.repository.CreditRepository;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;
import org.springframework.stereotype.Service;

@Service
public class CreditServiceImpl implements CreditService {

    private final CreditRepository creditRepository;

    public CreditServiceImpl(CreditRepository creditRepository) {
        this.creditRepository = creditRepository;
    }

    @Override
    public Single<Credit> createCredit(Credit credit) {
        return Single.fromCallable(() -> creditRepository.save(credit));
    }

    @Override
    public Maybe<Credit> getCredit(String creditNumber) {
        return Maybe.fromCallable(() -> creditRepository.findById(creditNumber).orElse(null));
    }

    @Override
    public Single<Credit> updateCredit(Credit credit) {
        return Single.fromCallable(() -> creditRepository.save(credit));
    }

    @Override
    public Completable deleteCredit(String creditNumber) {
        return Completable.fromAction(() -> creditRepository.deleteById(creditNumber));
    }

    @Override
    public Flowable<Credit> getAllCredits() {
        return Flowable.fromIterable(creditRepository.findAll());
    }
}
