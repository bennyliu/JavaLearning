package com.homework2.service;
import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.test.annotation.Rollback;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.homework2.action.LoginAction;
import com.opensymphony.xwork2.ActionContext;


@ContextConfiguration(locations = { "file:src/applicationContext.xml",
"file:src/hibernate.cfg.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceImplTests {

        private static UserServiceImpl userservice = new UserServiceImpl();

        @Test
        @Rollback(true)
        public void testLoginSuccess() throws Exception {
            System.out.println(userservice.login("benny", "ab"));
                assertTrue(userservice.login("benny", "ab"));
        }
        
        @Test
        @Rollback(true)
        public void testLoginFail() throws Exception {
            System.out.println(userservice.login("bennyliu", "abxxqwefcq"));
                assertTrue(!(userservice.login("bennyliu", "abxx")));
                assertTrue(!(userservice.login("bennyliu", "")));
                assertTrue(!(userservice.login("", "abxx")));
                assertTrue(!(userservice.login(null, "abxx")));
                assertTrue(!(userservice.login("bennyliu", null)));
        }

    

}
