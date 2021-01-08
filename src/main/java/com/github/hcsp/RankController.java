package com.github.hcsp;

import com.github.hcsp.dao.GoodsMapper;
import com.github.hcsp.entity.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class RankController {
  @Autowired
  GoodsMapper goodsMapper;

  @GetMapping("/rank")
  public ModelAndView rankFreemarker(){
    Goods g1 = new Goods();
    Goods g2 = new Goods();
    g1.setName("xiaomi");
    g1.setTotalPrice(100);
    g2.setName("apple");
    g2.setTotalPrice(150);
    List<Goods> list = new ArrayList<>();

    list.add(g1);
    list.add(g2);
    HashMap<String,Object> model = new HashMap<>();
    model.put("goods",list);
    List goods =  goodsMapper.getAll();
    System.out.println(goods);
    return new ModelAndView("rank",model);
  }
}
