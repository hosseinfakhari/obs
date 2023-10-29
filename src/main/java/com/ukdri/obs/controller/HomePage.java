package com.ukdri.obs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePage {
    @GetMapping
    String getHomePage() {
        return "home";
    }
}
