package com.github.hcsp.Controller;

import com.github.hcsp.Service.rankService;
import com.github.hcsp.entity.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyController {

    @Autowired
    private rankService service;

    @RequestMapping(path = "/rank.htm")
    @ResponseBody
    public List<Goods> getRank() {
        return service.getRank();
    }
}
