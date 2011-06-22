package com.homework2.action;

import java.util.List;

import com.homework2.po.User;
import com.homework2.service.UserServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport{
private User user;
private String confirmPassword;
private static UserServiceImpl userService = new UserServiceImpl();
public String getConfirmPassword() {
    return confirmPassword;
}

public void setConfirmPassword(String confirmPassword) {
    this.confirmPassword = confirmPassword;
}



@Override
public String execute() throws Exception {
    // TODO Auto-generated method stub
//    System.out.println("**********************Execution");
//    System.out.println("**********************"+user.getUsername());
    System.out.println(user.getUsername());
    userService.register(user);
    List<User> users = userService.getAllUsers();
    ActionContext.getContext().getSession().put("login", user.getUsername());
    ActionContext.getContext().put("allusers", users);
    return "SUCCESS";
}

    public User getUser() {
    return user;
}

public void setUser(User user) {
    this.user = user;
}

@Override
public void validate() {
    // TODO Auto-generated method stub
    super.validate();
//    if(this.user.getPassword() != this.confirmPassword) {
//        addFieldError("confirmPassword","Confirm Password Should Be The Same As Password.");
//    }
}

}
