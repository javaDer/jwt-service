package com.jswl.jwtservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jswl.jwtservice.entity.User;
import com.jswl.jwtservice.mapper.UserMapper;
import com.jswl.jwtservice.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author David ZHONG
 * @since 2018-04-02
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public User findUserById(String userId) {
        return this.baseMapper.selectById(userId);
    }

    @Override
    public User findByUsername(User user) {
        QueryWrapper<User> qr = new QueryWrapper<>();
        qr.eq("username", user.getUsername());
        this.baseMapper.selectOne(qr);
        return null;
    }

    @Override
    public User getOne(Wrapper<User> queryWrapper) {
        return null;
    }
}
