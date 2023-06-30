package com.nttdata.proyecto1bc43.controller;

import com.nttdata.proyecto1bc43.model.CreditCard;
import com.nttdata.proyecto1bc43.service.CreditCardService;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/credit-cards")
public class CreditCardController {

    private final CreditCardService creditCardService;

    public CreditCardController(CreditCardService creditCardService) {
        this.creditCardService = creditCardService;
    }

    @PostMapping
    public Single<CreditCard> createCreditCard(@RequestBody CreditCard creditCard) {
        return creditCardService.createCreditCard(creditCard);
    }

    @GetMapping("/{creditCardNumber}")
    public Maybe<CreditCard> getCreditCard(@PathVariable String creditCardNumber) {
        return creditCardService.getCreditCard(creditCardNumber);
    }

    @PutMapping("/{creditCardNumber}")
    public Single<CreditCard> updateCreditCard(@PathVariable String creditCardNumber, @RequestBody CreditCard creditCard) {
        creditCard.setCreditCardNumber(creditCardNumber);
        return creditCardService.updateCreditCard(creditCard);
    }

    @DeleteMapping("/{creditCardNumber}")
    public Completable deleteCreditCard(@PathVariable String creditCardNumber) {
        return creditCardService.deleteCreditCard(creditCardNumber);
    }

    @GetMapping
    public Flowable<CreditCard> getAllCreditCards() {
        return creditCardService.getAllCreditCards();
    }

    @GetMapping("/client/{clientId}")
    public Iterable<CreditCard> getCreditCardsByClientId(@PathVariable String clientId) {
        return creditCardService.getCreditCardsByClientId(clientId);
    }
}
