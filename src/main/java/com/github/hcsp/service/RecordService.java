package com.github.hcsp.service;

import com.github.hcsp.anno.Catch;
import com.github.hcsp.dao.RecordMepper;
import com.github.hcsp.entity.GoodsItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordService {
    @Autowired
    private RecordMepper recordMepper;

    @Catch
    public List<GoodsItem> getRecords() {
        return recordMepper.queryRecordAll();
    };

}
