package com.github.hcsp;

import com.github.hcsp.entity.GoodsSalesRankItem;
import com.github.hcsp.service.GoodsSalesRankService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApplicationController {
    private final GoodsSalesRankService goodsSalesRankService;

    public ApplicationController(GoodsSalesRankService goodsSalesRankService) {
        this.goodsSalesRankService = goodsSalesRankService;
    }

    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/getGoodsSalesRank")
    public List<GoodsSalesRankItem> getGoodsSalesRank() {
        return this.goodsSalesRankService.getGoodsSalesRank();
    }
}
