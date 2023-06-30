package com.nttdata.proyecto1bc43.controller;


import com.nttdata.proyecto1bc43.model.AccountBank;
import com.nttdata.proyecto1bc43.service.AccountBankService;
import io.reactivex.rxjava3.core.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account-banks")
public class AccountBankController {
    private AccountBankService accountBankService;

    public AccountBankController(AccountBankService accountBankService) {
        this.accountBankService = accountBankService;
    }

    @PostMapping
    public Single<AccountBank> createAccountBank(@RequestBody AccountBank accountBank) {
        return accountBankService.createAccountBank(accountBank);
    }

    @GetMapping("/{numero}")
    public Maybe<AccountBank> getAccountBank(@PathVariable String numero) {
        return accountBankService.getAccountBank(numero);
    }

    @PutMapping("/{numero}")
    public Single<AccountBank> updateAccountBank(@PathVariable String numero, @RequestBody AccountBank accountBank) {
        accountBank.setNumero(numero);
        return accountBankService.updateAccountBank(accountBank);
    }

    @DeleteMapping("/{numero}")
    public Completable deleteAccountBank(@PathVariable String numero) {
        return accountBankService.deleteAccountBank(numero);
    }

    @GetMapping
    public Flowable<AccountBank> getAllAccountBanks() {
        return accountBankService.getAllAccountBanks();
    }

   /* @GetMapping("/client/{clientId}")
    public Flowable<AccountBank> getAccountBanksByClientId(@PathVariable String clientId) {
        return accountBankService.getAccountBanksByClientId(clientId);
    }*/
}