package com.zzkk.soccer_video.service;

import com.zzkk.soccer_video.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zzkk.soccer_video.vo.LoginVo;
import com.zzkk.soccer_video.vo.RespBean;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ZengKang
 * @since 2022-08-23
 */
public interface IUserService extends IService<User> {

    RespBean doLogin(LoginVo loginVo);
}
