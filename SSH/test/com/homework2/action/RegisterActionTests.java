package com.homework2.action;

import java.util.HashMap;

import org.apache.struts2.ServletActionContext;
import org.junit.Test;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;
import org.springframework.test.annotation.Rollback;
import com.homework2.po.User;
import com.opensymphony.xwork2.ActionContext;

public class RegisterActionTests extends
        AbstractDependencyInjectionSpringContextTests {
    public RegisterActionTests(String name) {
        super(name);
        // TODO Auto-generated constructor stub
    }

    private RegisterAction register;

    public void setRegister(RegisterAction register) {
        this.register = register;
    }

     protected String[] getConfigLocations() {
     return new String[] { "applicationcontext.xml" };
     }

    @Test
    @Rollback(true)
    public void testRegisterSuccess() throws Exception {
        
        ActionContext context = new ActionContext(new HashMap<String, Object>());
        context.setSession(new HashMap<String, Object>());

        ServletActionContext.setContext(context);
        User user = new User();
        user.setUsername("benny10");
        user.setPassword("test");
        user.setAge(15);
        user.setEmail("this@test.com");
        user.setSex("female");

        register.setUser(user);
        register.setConfirmPassword("test");
        System.out.println(register.execute());

    }

}
