package com.homework2.service;

import java.util.List;

import com.homework2.po.User;

public interface IUserService {
boolean login(String username,String password);
void register(User user);
List<User> getAllUsers();
}
