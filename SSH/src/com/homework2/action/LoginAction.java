package com.homework2.action;

import java.util.List;

import com.homework2.po.User;
import com.homework2.service.UserServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
    private String username;
    private String password;
    private static UserServiceImpl userService = new UserServiceImpl();

    public String getUsername() {
        return username;
    }

    @Override
    public void validate() {
        // TODO Auto-generated method stub
        // super.validate();
        if (this.password.length() < 2) {
            addFieldError("password", "too short");
        }
        System.out.println("**************Validation");
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String execute() throws Exception {
        System.out.println("**************Login");
        boolean flag = userService.login(this.username, this.password);
        if(!flag) {
            addFieldError("password","Password and username is not matched!");
            return "input";
        }
        List<User> users = userService.getAllUsers();
        ActionContext.getContext().put("allusers", users);
        return "SUCCESS";
    }
}
