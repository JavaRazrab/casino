package com.example.casino;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Repository
public class BalanceRepository {

    private final Map<Long, BigDecimal> storage = new HashMap<>(Map.of(1L, BigDecimal.valueOf(1000)));


    public BigDecimal getBalanceForId(Long accountId) {
        return storage.get(accountId);
    }

    public BigDecimal addMoneyToAccountId(Long accountId, BigDecimal amount) {
        BigDecimal currentAmount = storage.get(accountId),
                updatedAmount = currentAmount.add(amount);
        storage.put(accountId, updatedAmount);
        return updatedAmount;
    }

    public boolean isThereAccountId(Long accountId){
        System.out.println(accountId);
        return storage.containsKey(accountId);
    }
}
