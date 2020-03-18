package com.github.hcsp.DAO.impl;

import com.github.hcsp.DAO.DealRankDAO;
import com.github.hcsp.entity.GoodsDealInfo;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description:
 * User: Lzj
 * Date: 2020-03-18
 * Time: 12:54
 */
@Component
public class DealRankDAOImpl implements DealRankDAO {
    @Autowired
    SqlSessionFactory sqlSessionFactory;

    @Override
    public List<GoodsDealInfo> getDealRank() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            DealRankDAO mapper = session.getMapper(DealRankDAO.class);
            return mapper.getDealRank();
        }
    }
}
