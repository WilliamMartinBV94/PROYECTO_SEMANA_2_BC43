package com.nttdata.proyecto1bc43.service;


import com.nttdata.proyecto1bc43.model.BankTransfer;
import io.reactivex.rxjava3.core.Single;

import java.math.BigDecimal;

public interface BankTransferService {
    Single<BankTransfer> transferBetweenAccounts(String sourceAccountId, String targetAccountId, BigDecimal amount);
    Single<BankTransfer> transferToExternalAccount(String sourceAccountId, String targetAccountNumber, BigDecimal amount);
}
