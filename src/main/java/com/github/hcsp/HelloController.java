package com.github.hcsp;

import com.github.hcsp.entity.RankItem;
import com.github.hcsp.service.CacheService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@RestController
public class HelloController {
    @Resource
    private SqlSession sqlSession;
    @Resource
    private CacheService cacheService;


    @RequestMapping("/rank.htm")
    @ResponseBody
    public ModelAndView search() {
        List<RankItem> items = cacheService.searchRank();
        HashMap<String, Object> model = new HashMap<>();
        model.put("itmes", items);
        return new ModelAndView("index", model);
    }
    @RequestMapping("/")
    @Cache
    public List<RankItem> getRank() {
        return sqlSession.selectList("mapper.selectRank");
    }

}
