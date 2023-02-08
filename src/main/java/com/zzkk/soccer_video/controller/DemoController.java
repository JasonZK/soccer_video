package com.zzkk.soccer_video.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName DemoController
 * @Description
 * @date 2022/12/8 11:40
 * @Version 1.0
 */
@Controller
@RequestMapping("/demo")
public class DemoController {


    @RequestMapping("/hello")
    public String hello(Model model)
    {
        model.addAttribute("name", "zzkk");
        return "hello";
    }
}
