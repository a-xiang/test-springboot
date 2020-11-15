package com.learn.luckymoney.dao;

import com.learn.luckymoney.model.Luckmoney;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * LuckMoneyDao
 *
 * @author yxx
 * @since 2020/11/14
 */
@Repository
public interface LuckMoneyDao extends JpaRepository<Luckmoney,Integer> {
}
