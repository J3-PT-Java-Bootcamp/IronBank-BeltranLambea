package com.ironhack.ironbank.Request;

import java.math.BigDecimal;

public record TransactionRequest(
        Long senderAccountId,
        Long receiverAccountId,
        BigDecimal amount,
        String transactionSecretKey,
        String receiverName
) {
}
