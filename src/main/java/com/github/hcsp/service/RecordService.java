package com.github.hcsp.service;

import com.github.hcsp.dao.RecordDao;
import com.github.hcsp.entity.RecordItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordService {
    @Autowired
    private RecordDao recordDao;

    public List<RecordItem> getRecords() {
        return recordDao.RecordDao();
    }

}
