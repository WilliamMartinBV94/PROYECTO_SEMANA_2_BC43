package com.nttdata.proyecto1bc43.service;



import com.nttdata.proyecto1bc43.model.AccountBank;
import com.nttdata.proyecto1bc43.model.Client;
import com.nttdata.proyecto1bc43.repository.AccountBankRepository;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AccountBankServiceImpl implements AccountBankService {

    private final AccountBankRepository accountBankRepository;

    public AccountBankServiceImpl(AccountBankRepository accountBankRepository) {
        this.accountBankRepository = accountBankRepository;
    }

    @Override
    public Single<AccountBank> createAccountBank(AccountBank accountBank) {
        return Single.fromCallable(() -> accountBankRepository.save(accountBank));
    }

    @Override
    public Maybe<AccountBank> getAccountBank(String numero) {
        Optional<AccountBank> optionalAccountBank = accountBankRepository.findById(numero);
        return Maybe.fromOptional(optionalAccountBank);
    }
    @Override
    public Single<AccountBank> updateAccountBank(AccountBank accountBank) {
        return Single.fromCallable(() -> accountBankRepository.save(accountBank));
    }

    @Override
    public Completable deleteAccountBank(String numero) {
        return Completable.fromAction(() -> accountBankRepository.deleteById(numero));
    }

    @Override
    public Flowable<AccountBank> getAllAccountBanks() {
        List<AccountBank> accountBanks = accountBankRepository.findAll();
        return Flowable.fromIterable(accountBanks);
    }

    /*@Override
    public Flowable<AccountBank> getAccountBanksByClientId(String clientId) {
        return accountBankRepository.getAccountBanksByClientId(clientId);
    }*/
}

