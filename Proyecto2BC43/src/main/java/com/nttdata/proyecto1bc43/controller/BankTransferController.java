package com.nttdata.proyecto1bc43.controller;


import com.nttdata.proyecto1bc43.model.BankTransfer;
import com.nttdata.proyecto1bc43.service.BankTransferService;
import io.reactivex.rxjava3.core.Single;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/bank-transfers")
public class BankTransferController {
    private final BankTransferService bankTransferService;

    public BankTransferController(BankTransferService bankTransferService) {
        this.bankTransferService = bankTransferService;
    }

    @PostMapping("/transfer-between-accounts")
    public Single<BankTransfer> transferBetweenAccounts(@RequestParam("sourceAccountId") String sourceAccountId,
                                                        @RequestParam("targetAccountId") String targetAccountId,
                                                        @RequestParam("amount") BigDecimal amount) {
        return bankTransferService.transferBetweenAccounts(sourceAccountId, targetAccountId, amount);
    }

    @PostMapping("/transfer-to-external-account")
    public Single<BankTransfer> transferToExternalAccount(@RequestParam("sourceAccountId") String sourceAccountId,
                                                          @RequestParam("targetAccountNumber") String targetAccountNumber,
                                                          @RequestParam("amount") BigDecimal amount) {
        return bankTransferService.transferToExternalAccount(sourceAccountId, targetAccountNumber, amount);
    }
}
