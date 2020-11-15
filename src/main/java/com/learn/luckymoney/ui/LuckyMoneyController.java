package com.learn.luckymoney.ui;

import com.learn.luckymoney.dao.LuckMoneyDao;
import com.learn.luckymoney.model.Luckmoney;
import com.learn.luckymoney.service.LuckMoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * LuckyMoneyController
 *
 * @author yxx
 * @since 2020/11/14
 */
@RestController
@RequestMapping("/luckymoneys")
public class LuckyMoneyController {

    @Autowired
    private LuckMoneyDao moneyDao;

    @Autowired
    private LuckMoneyService service;

    @GetMapping
    public List<Luckmoney> getLuckMoneyList() {
        return moneyDao.findAll();
    }

    @PostMapping
    public Luckmoney createLuckMoney(@RequestParam("producer") String producer, @RequestParam("money") BigDecimal money) {
        Luckmoney luckmoney = new Luckmoney();
        luckmoney.setProducer(producer);
        luckmoney.setMoney(money);
        return moneyDao.save(luckmoney);
    }

    @GetMapping("/{id}")
    public Luckmoney getLuckMoneyById(@PathVariable("id") Integer id) {
        return moneyDao.findById(id).get();
    }

    @PutMapping("/{id}")
    public Luckmoney updateLuckMoneyById(@PathVariable("id") Integer id, @RequestParam("consumer") String consumer) {
        Luckmoney luckmoney = moneyDao.findById(id).orElse(null);
        if (luckmoney == null) {
            return null;
        }
        luckmoney.setConsumer(consumer);
        return moneyDao.save(luckmoney);
    }

    @DeleteMapping("/{id}")
    public long deleteLuckMoneyById(@PathVariable("id") Integer id) {
        Luckmoney luckmoney = moneyDao.findById(id).orElse(null);
        if (luckmoney != null) {
            moneyDao.deleteById(id);
        }
        return moneyDao.count();
    }

    @PostMapping("/createtwo")
    public String createTwo() {
        try {
            service.createTwoMoney();
        } catch (Exception e) {
            return "fail";
        }
        return "success";
    }
}
