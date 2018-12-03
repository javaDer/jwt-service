package com.jswl.jwtservice.service;

import com.jswl.jwtservice.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author David ZHONG
 * @since 2018-04-02 
 */
public interface IUserService extends IService<User> {

    User findUserById(String userId);

    User findByUsername(User user);
}
