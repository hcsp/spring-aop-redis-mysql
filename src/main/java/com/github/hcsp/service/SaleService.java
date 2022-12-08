package com.github.hcsp.service;

import com.github.hcsp.dao.SaleDao;
import com.github.hcsp.entity.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService {
    @Autowired
    private SaleDao saleDao;

    public List<Money> getSale() {
        return saleDao.getSale();
    }

    public static void main(String[] args) {
        new Counter().f(5);
    }
    static class Counter {
            int value;

            public int f(int n) {
                if (n == 0 || n == 1) {
                    return 1;
                } else {
                    return f(n - 1) + f(n - 2);
                }
            }
        }

}
