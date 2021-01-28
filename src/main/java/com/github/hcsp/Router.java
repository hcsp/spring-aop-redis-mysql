package com.github.hcsp;

import com.github.hcsp.dao.UserMapper;
import com.github.hcsp.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Router {
    @Autowired
    private RecordService recordService;

    @Autowired
    private UserMapper userMapper;

    @RequestMapping(path = { "/router/{id}"}, method = RequestMethod.GET)
    @ResponseBody
    public Object responsUser(@PathVariable("id") Integer id) {
        System.out.println(id + "--参数");
        return userMapper.getUserByid(id);
    }

    @RequestMapping("/getTableData")
    @ResponseBody
    public Object responsList() {
        return recordService.getRecords();
    }
}
