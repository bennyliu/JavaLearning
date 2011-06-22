package com.homework2.service;

import java.util.List;

import com.homework2.dao.UserDao;
import com.homework2.po.User;

public class UserServiceImpl implements IUserService {
    private static UserDao userdao = new UserDao();

    @Override
    public boolean login(String username, String password) {
        // TODO Auto-generated method stub
        return userdao.loginUser(username, password);
    }

    @Override
    public void register(User user) {
        // TODO Auto-generated method stub
        userdao.createUser(user);
    }

    @Override
    public List<User> getAllUsers() {
        // TODO Auto-generated method stub
        return userdao.getAllUsers();
    }

}
