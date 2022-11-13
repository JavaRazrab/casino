package com.example.casino.controllers;

import com.example.casino.services.CasinoService;
import com.example.casino.model.TransferBalance;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@Slf4j
@RestController
@RequestMapping("api/balance")
@AllArgsConstructor
public class BalanceController {

    private final CasinoService casinoService;

    @GetMapping("{accountId}")
    public BigDecimal getBalance(@PathVariable Long accountId){
        return casinoService.getBalance(accountId);
    }

    @PostMapping("add-money")
    public BigDecimal addMoney(
            @RequestBody TransferBalance transfer){
        //System.out.println(transfer.getTo()+" "+ transfer.getAmount());
        return casinoService.addMoney(transfer.getTo(), transfer.getAmount());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String handle(IllegalArgumentException e){
        log.error(e.getMessage());
        return "There is no such accountId";
    }

    @ExceptionHandler()
    public String handle(Exception e){
        log.error(e.getMessage());
        return "Internal Server Error";
    }

}
