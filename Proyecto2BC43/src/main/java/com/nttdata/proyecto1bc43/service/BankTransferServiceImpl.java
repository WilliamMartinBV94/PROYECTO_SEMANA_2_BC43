package com.nttdata.proyecto1bc43.service;

import com.nttdata.proyecto1bc43.exception.InsufficientBalanceException;
import com.nttdata.proyecto1bc43.model.AccountBank;
import com.nttdata.proyecto1bc43.model.BankTransfer;
import com.nttdata.proyecto1bc43.repository.AccountBankRepository;
import com.nttdata.proyecto1bc43.repository.BankTransferRepository;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;
import java.math.BigDecimal;


@Service
public class BankTransferServiceImpl implements BankTransferService {

    private final BankTransferRepository bankTransferRepository;
    private final AccountBankService accountBankService;

    public BankTransferServiceImpl(AccountBankService accountBankService, BankTransferRepository bankTransferRepository) {
        this.accountBankService = accountBankService;
        this.bankTransferRepository = bankTransferRepository;
    }

    @Override
    public Single<BankTransfer> transferBetweenAccounts(String sourceAccountId, String targetAccountId, BigDecimal amount) {
        // Validar si las cuentas existen y tienen saldo suficiente
        Maybe<AccountBank> sourceAccountMaybe = accountBankService.getAccountBank(sourceAccountId)
                .switchIfEmpty(Maybe.error(new AccountNotFoundException("Cuenta de origen no encontrada")));

        Maybe<AccountBank> targetAccountMaybe = accountBankService.getAccountBank(targetAccountId)
                .switchIfEmpty(Maybe.error(new AccountNotFoundException("Cuenta de destino no encontrada")));
        // Combinar los Maybe de las cuentas y realizar la transferencia
        return Maybe.zip(sourceAccountMaybe, targetAccountMaybe, (sourceAccount, targetAccount) -> {
                    // Lógica para realizar la transferencia
                    if (sourceAccount.getBalance().compareTo(amount) < 0) {
                        throw new InsufficientBalanceException("Saldo insuficiente en la cuenta de origen");
                    }

                    sourceAccount.debit(amount);
                    targetAccount.credit(amount);

                    accountBankService.updateAccountBank(sourceAccount);
                    accountBankService.updateAccountBank(targetAccount);

                    return new BankTransfer(sourceAccountId, targetAccountId, amount);

                })
                .toSingle()
                .onErrorResumeNext(error -> {
                    if (error instanceof AccountNotFoundException || error instanceof InsufficientBalanceException) {
                        return Single.error(error); // Propagar las excepciones específicas
                    } else {
                        return Single.error(new RuntimeException("Error al realizar la transferencia")); // Otros errores
                    }
                });
    }

    @Override
    public Single<BankTransfer> transferToExternalAccount(String sourceAccountId, String targetAccountNumber, BigDecimal amount) {
        // Obtener la cuenta de origen
        Single<AccountBank> sourceAccountSingle = accountBankService.getAccountBank(sourceAccountId)
                .switchIfEmpty(Single.error(new AccountNotFoundException("Cuenta de origen no encontrada")));

        // Validar si la cuenta de origen existe y tiene saldo suficiente
        Single<AccountBank> validSourceAccountSingle = sourceAccountSingle
                .flatMap(account -> {
                    if (account.getBalance().compareTo(amount) < 0) {
                        return Single.error(new InsufficientBalanceException("Saldo insuficiente en la cuenta de origen"));
                    }
                    return Single.just(account);
                });

        // Realizar la transferencia
        return validSourceAccountSingle.flatMap(sourceAccount -> {
            // Lógica para realizar la transferencia a una cuenta externa
            // ...

            // Crear y retornar la transferencia bancaria
            BankTransfer bankTransfer = new BankTransfer(sourceAccountId, targetAccountNumber, amount);
            return Single.just(bankTransfer);
        });
    }

}

