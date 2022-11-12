package com.example.casino;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Random;

@Service
@AllArgsConstructor
public class CasinoService {

    private final BalanceRepository repository;
    public BigDecimal getBalance(Long accountId) {
        if(!repository.isThereAccountId(accountId)){
            throw new IllegalArgumentException();
        }else{
            return repository.getBalanceForId(accountId);
        }
    }

    public BigDecimal addMoney(Long accountId, BigDecimal amount) {
        if(!repository.isThereAccountId(accountId)){
            throw new IllegalArgumentException();
        }else{
            return repository.addMoneyToAccountId(accountId, amount);
        }
    }

    public BigDecimal play(Long accountId, BigDecimal bet) {
        if(!repository.isThereAccountId(accountId)){
            throw new IllegalArgumentException();
        }else{
            Random random = new Random();
            addMoney(accountId,random.nextInt()>0?bet:bet.negate());
        }
        return repository.getBalanceForId(accountId);
    }
}
