package com.zzkk.soccer_video.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzkk.soccer_video.mapper.UserMapper;
import com.zzkk.soccer_video.pojo.User;
import com.zzkk.soccer_video.service.IUserService;
import com.zzkk.soccer_video.vo.LoginVo;
import com.zzkk.soccer_video.vo.RespBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author ZengKang
 * @since 2022-12-08
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public RespBean doLogin(LoginVo loginVo)
    {
        log.info("到达这里");
        return null;
    }

}
