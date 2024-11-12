package com.nhoclahola.aloute_thymeleaf.controllers.web.market;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("market")
public class MarketController {
    @GetMapping("")
    public String Home_market() {
        return "market/Home";
    }
}
