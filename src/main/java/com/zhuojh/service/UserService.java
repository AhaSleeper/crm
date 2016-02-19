package com.zhuojh.service;

import com.zhuojh.model.User;

import java.util.List;

/**
 * Created by snow on 2016/2/17.
 */
public interface UserService {
    public boolean save(User user);
    public User getUserById(String id);
    public boolean deleteById(String id);
    public boolean update(User user);
    public List<User> getUserByPage(User user,Integer pageNo, Integer pageSize);

}
