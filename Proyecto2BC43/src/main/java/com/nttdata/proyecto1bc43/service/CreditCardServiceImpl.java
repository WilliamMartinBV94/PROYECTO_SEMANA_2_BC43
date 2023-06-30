package com.nttdata.proyecto1bc43.service;


import com.nttdata.proyecto1bc43.model.CreditCard;
import com.nttdata.proyecto1bc43.repository.CreditCardRepository;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;
import org.springframework.stereotype.Service;

@Service
public class CreditCardServiceImpl implements CreditCardService {

    private final CreditCardRepository creditCardRepository;

    public CreditCardServiceImpl(CreditCardRepository creditCardRepository) {
        this.creditCardRepository = creditCardRepository;
    }

    @Override
    public Single<CreditCard> createCreditCard(CreditCard creditCard) {
        return Single.fromCallable(() -> creditCardRepository.save(creditCard));
    }

    @Override
    public Maybe<CreditCard> getCreditCard(String creditCardNumber) {
        return Maybe.fromCallable(() -> creditCardRepository.findById(creditCardNumber).orElse(null));
    }

    @Override
    public Single<CreditCard> updateCreditCard(CreditCard creditCard) {
        return Single.fromCallable(() -> creditCardRepository.save(creditCard));
    }

    @Override
    public Completable deleteCreditCard(String creditCardNumber) {
        return Completable.fromAction(() -> creditCardRepository.deleteById(creditCardNumber));
    }

    @Override
    public Flowable<CreditCard> getAllCreditCards() {
        return Flowable.fromIterable(creditCardRepository.findAll());
    }

    @Override
    public Iterable<CreditCard> getCreditCardsByClientId(String clientId) {
        return creditCardRepository.findByClientId(clientId).toList().blockingGet();
    }

}
