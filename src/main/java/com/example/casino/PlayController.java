package com.example.casino;

import com.example.casino.model.Play;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@Slf4j
@RequestMapping("/play")
@AllArgsConstructor
public class PlayController {

    private final CasinoService casinoService;

    @PostMapping()
    public BigDecimal play(
            @RequestBody Play play){
        return casinoService.play(play.getAccountId(), play.getBet());
    }
}
