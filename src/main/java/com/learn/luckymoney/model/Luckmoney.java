package com.learn.luckymoney.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * Luckmoney
 *
 * @author yxx
 * @since 2020/11/14
 */
@Entity
@Getter
@Setter
public class Luckmoney {
    @Id
    @GeneratedValue // 自增注解
    private Integer id;

    private String producer;

    private BigDecimal money;

    private String consumer;
}
