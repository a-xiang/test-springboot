package com.learn.luckymoney.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * LimitMoney
 *
 * @author yxx
 * @since 2020/11/3
 */
@Component
@ConfigurationProperties(prefix = "limit")
@Setter
@Getter
public class LimitMoney {
    private BigDecimal minMoney;

    private BigDecimal maxMoney;

    private String description;
}
