package com.github.hcsp.dao;

import com.github.hcsp.entity.RankItem;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: RankDao
 * @Description:
 * @date 2020-08-30
 */
@Repository
public class RankDao {

    @Autowired
    private SqlSession sqlSession;

    public List<RankItem> getRank() {
        return sqlSession.selectList("Mapper.selectRank");
    }

}
