package com.homework2.dao;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

import com.homework2.action.LoginAction;
import com.homework2.service.UserServiceImpl;

public class UserDaoTests extends AbstractDependencyInjectionSpringContextTests  {
    

    private LoginAction login;
    
    public void setLogin(LoginAction login) {
        this.login = login;
    }
    
    @Test
    public void testLogin() throws Exception {
        login.setUsername("benny");
        login.setPassword("ab");
//        boolean login = login.login("benny", "ab");
        System.out.println(login.execute());
        
    }
    
    protected String [] getConfigLocations() {
        return new String[] {"applicationcontext.xml"};
    }
}
