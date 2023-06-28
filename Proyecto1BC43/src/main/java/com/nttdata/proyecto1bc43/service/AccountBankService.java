package com.nttdata.proyecto1bc43.service;


import com.nttdata.proyecto1bc43.model.AccountBank;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;

public interface AccountBankService {
    Single<AccountBank> createAccountBank(AccountBank accountBank);
    Maybe<AccountBank> getAccountBank(String numero);
    Single<AccountBank> updateAccountBank(AccountBank accountBank);
    Completable deleteAccountBank(String numero);
    Flowable<AccountBank> getAllAccountBanks();
   // Flowable<AccountBank> getAccountBanksByClientId(String clientId);
}
