package com.learn.luckymoney.ui;

import com.learn.luckymoney.model.LimitMoney;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * HelloSpringBoot
 *
 * @author yxx
 * @since 2020/11/2
 */
@RestController
@RequestMapping("/hello")
public class HelloSpringBoot {
    @Autowired
    private LimitMoney limitMoney;

    @GetMapping("/hi")
    public String hello() {
        return limitMoney.getDescription();
    }

    @GetMapping("/say/{id}")
    public String say(@PathVariable("id") Integer id) {
        return "id = " + id;
    }

    @GetMapping("/play")
    public String play(@RequestParam(value = "id", required = false, defaultValue = "22") Integer id) {
        return "play id = " + id;
    }
}
