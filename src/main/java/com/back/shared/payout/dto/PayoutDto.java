package com.back.shared.payout.dto;

import com.back.standard.modelType.CanGetModelTypeCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class PayoutDto implements CanGetModelTypeCode {
    private final int id;
    private final LocalDateTime createDate;
    private final LocalDateTime modifyDate;
    private int payeeId;
    private String payeeName;
    private LocalDateTime payoutDate;
    private long amount;
    private boolean isPayeeSystem;

    @Override
    public String getModelTypeCode() {
        return "Payout";
    }
}