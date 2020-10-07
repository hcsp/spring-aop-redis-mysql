package com.github.hcsp.dao;

import com.github.hcsp.dao.mapper.RankMapper;
import com.github.hcsp.entity.RankItem;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

@Repository
public class RankDao {
    @Inject
    private RankMapper rankMapper;

    public List<RankItem> getRank() {
        return rankMapper.getRank();
    }
}
