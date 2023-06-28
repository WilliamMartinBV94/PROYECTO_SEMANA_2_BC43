package com.nttdata.proyecto1bc43.controller;

import com.nttdata.proyecto1bc43.model.Credit;
import com.nttdata.proyecto1bc43.service.CreditService;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/credits")
public class CreditController {

    private final CreditService creditService;

    public CreditController(CreditService creditService) {
        this.creditService = creditService;
    }

    @PostMapping
    public Single<Credit> createCredit(@RequestBody Credit credit) {
        return creditService.createCredit(credit);
    }

    @GetMapping("/{creditNumber}")
    public Maybe<Credit> getCredit(@PathVariable String creditNumber) {
        return creditService.getCredit(creditNumber);
    }

    @PutMapping("/{creditNumber}")
    public Single<Credit> updateCredit(@PathVariable String creditNumber, @RequestBody Credit credit) {
        credit.setCreditNumber(creditNumber);
        return creditService.updateCredit(credit);
    }

    @DeleteMapping("/{creditNumber}")
    public Completable deleteCredit(@PathVariable String creditNumber) {
        return creditService.deleteCredit(creditNumber);
    }

    @GetMapping
    public Flowable<Credit> getAllCredits() {
        return creditService.getAllCredits();
    }
}

