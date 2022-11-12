package com.example.casino.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Play {
    private BigDecimal bet;
    private Long accountId;
}
