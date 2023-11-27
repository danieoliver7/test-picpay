package com.picpay.picpaytest.dtos;

import java.math.BigDecimal;

public record TransactionDto(BigDecimal value, Long senderId, Long receiverId){

}
