package com.github.hcsp.web;

import com.github.hcsp.entity.Money;
import com.github.hcsp.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.HashMap;

@RestController
public class SaleController {
    @Autowired
    private SaleService saleService;

    @RequestMapping("/rank.htm")
    @ResponseBody
    public Object sale(HttpServletRequest request, HttpServletResponse response) {
        List<Money> sale = saleService.getSale();
        HashMap<String, Object> model = new HashMap<>();
        model.put("sale", sale);
        return new ModelAndView("index", model);
    }
}
