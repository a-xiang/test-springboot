package com.learn.luckymoney.service;

import com.learn.luckymoney.dao.LuckMoneyDao;
import com.learn.luckymoney.model.Luckmoney;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * LuckMoneyService
 *
 * @author yxx
 * @since 2020/11/15
 */
@Service
public class LuckMoneyService {
    @Autowired
    private LuckMoneyDao dao;

    /**
     * 事务一致性
     *
     * @return
     */
    @Transactional
    public String createTwoMoney() {
        Luckmoney luckmoney1 = new Luckmoney();
        luckmoney1.setProducer("袁大");
        luckmoney1.setMoney(new BigDecimal("520"));
        dao.save(luckmoney1);

        Luckmoney luckmoney2 = new Luckmoney();
        luckmoney2.setProducer("袁大");
        luckmoney2.setMoney(new BigDecimal("1314111"));
        dao.save(luckmoney2);

        return "OK";
    }
}
