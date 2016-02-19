package com.zhuojh.service;

import com.zhuojh.mapper.UserMapper;
import com.zhuojh.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by snow on 2016/2/17.
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean save(User user) {
        return userMapper.insert(user) > 0 ? true : false;
    }

    @Override
    public User getUserById(String id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean deleteById(String id) {
        return false;
    }

    @Override
    public boolean update(User user) {
        return userMapper.updateByPrimaryKeySelective(user) > 0 ? true : false;
    }

    @Override
    public List<com.zhuojh.model.User> getUserByPage(User user, Integer pageNo, Integer pageSize) {
        return null;
    }
}
