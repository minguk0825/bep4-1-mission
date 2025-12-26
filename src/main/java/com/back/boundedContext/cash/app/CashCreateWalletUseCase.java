package com.back.boundedContext.cash.app;

import com.back.boundedContext.cash.domain.CashMember;
import com.back.boundedContext.cash.domain.Wallet;
import com.back.boundedContext.cash.out.CashMemberRepository;
import com.back.boundedContext.cash.out.WalletRepository;
import com.back.shared.cash.dto.CashMemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CashCreateWalletUseCase {
    private final CashMemberRepository cashMemberRepository;
    private final WalletRepository walletRepository;

    public Wallet createWallet(CashMemberDto member) {

        // getReferenceById 를 사용하는 이유는 실제로 DB에서 엔티티를 조회하지 않고, 프록시 객체를 반환하여 성능을 최적화하기 위함입니다.
        CashMember _member = cashMemberRepository.getReferenceById(member.getId());
        Wallet wallet = new Wallet(_member);

        return walletRepository.save(wallet);
    }
}