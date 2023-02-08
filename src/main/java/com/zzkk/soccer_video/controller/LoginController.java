package com.zzkk.soccer_video.controller;

import com.zzkk.soccer_video.service.impl.UserServiceImpl;
import com.zzkk.soccer_video.vo.LoginVo;
import com.zzkk.soccer_video.vo.RespBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

/**
 * @ClassName LoginController
 * @Description
 * @date 2022/12/8 19:42
 * @Version 1.0
 */
@Controller
@RequestMapping("/login")
@Slf4j
public class LoginController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("/toLogin")
    public String toLogin()
    {
        return "login";
    }

    @RequestMapping("/doLogin")
    @ResponseBody
    public RespBean doLogin(LoginVo loginVo)
    {
        log.info("{}", loginVo);

        return userService.doLogin(loginVo);
    }

}
