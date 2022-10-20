package com.github.hcsp.service;

import com.github.hcsp.entity.RankItem;
import com.github.hcsp.entity.User;
import java.util.List;

public interface RankService {
    User getUserById(int id);

    List<RankItem> getRank();
}
