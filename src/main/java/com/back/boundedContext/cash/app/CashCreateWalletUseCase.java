package com.back.boundedContext.cash.app;

import com.back.boundedContext.cash.domain.CashMember;
import com.back.boundedContext.cash.domain.Wallet;
import com.back.boundedContext.cash.out.WalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CashCreateWalletUseCase {
    private final WalletRepository walletRepository;

    public Wallet createWallet(CashMember member) {
        Wallet wallet = new Wallet(member);

        return walletRepository.save(wallet);
    }
}