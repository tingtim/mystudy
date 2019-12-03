package com.example.test.studydemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Description
 * User :LT
 * Date : 2019-2019.12.2-02  18:36
 */

@Controller
public class indexController {
    @GetMapping("/")
    public String index(){
        return "index";
    }
}
