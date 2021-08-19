package com.github.hcsp;

import com.github.hcsp.entity.GoodsSales;
import com.github.hcsp.service.GoodsSalesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApplicationController {
    private final GoodsSalesService goodsSalesService;

    public ApplicationController(GoodsSalesService goodsSalesService) {
        this.goodsSalesService = goodsSalesService;
    }

    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/getGoodsSalesList")
    public List<GoodsSales> getGoodsSalesList() {
        return this.goodsSalesService.getGoodsSalesList();
    }
}
