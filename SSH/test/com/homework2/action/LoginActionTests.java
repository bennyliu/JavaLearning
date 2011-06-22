package com.homework2.action;

import com.opensymphony.xwork2.ActionContext;
import java.util.HashMap;
import java.util.List;
import org.apache.struts2.ServletActionContext;
import org.junit.Test;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;
import com.homework2.action.LoginAction;
import com.homework2.po.User;

public class LoginActionTests extends
        AbstractDependencyInjectionSpringContextTests {

    private LoginAction login;

    public void setLogin(LoginAction login) {
        this.login = login;
    }

    @Test
    public void testLoginSuccess() throws Exception {
        ActionContext context = new ActionContext(new HashMap<String, Object>());
        ServletActionContext.setContext(context);
        login.setUsername("benny");
        login.setPassword("ab");
        // Assert Login Succeed, and returns "SUCCESS".
        assertEquals("Test Failed", "SUCCESS", login.execute());

        List<User> users = (List<User>) ActionContext.getContext().get(
                "allusers");
        //parameter exist in ActionContext
        assertNotNull("Test Failed",users);
        //there are users in system
        assertFalse("Test Failed",users.isEmpty());
        /*TODO
         * add code to test the user list
         */
        // for(User user:users) {
        // System.out.println(user.getUsername());
        // }
    }
    
    @Test
    public void testLoginFail() throws Exception {
        login.setUsername("bennyliuxyz");
        login.setPassword("bennyliuxyz");
        assertEquals("Test Failed", "input", login.execute());
        
        login.setUsername("");
        login.setPassword("bennyliuxyz");
        assertEquals("Test Failed", "input", login.execute());
        
        login.setUsername("bennyliuxyz");
        login.setPassword("");
        assertEquals("Test Failed", "input", login.execute());
        
        login.setUsername("");
        login.setPassword("");
        assertEquals("Test Failed", "input", login.execute());
        
        login.setUsername(null);
        login.setPassword("ab");
        assertEquals("Test Failed", "input", login.execute());
        
        login.setUsername("");
        login.setPassword(null);
        assertEquals("Test Failed", "input", login.execute());
    }

    
    protected String[] getConfigLocations() {
        return new String[] { "applicationcontext.xml" };
    }
}
