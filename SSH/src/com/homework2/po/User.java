package com.homework2.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="user")
public class User implements java.io.Serializable{
    
    @Id
    @Column(name="id")
    @GeneratedValue(generator = "database")  
    @GenericGenerator(name = "database", strategy = "identity")
    private Long id;
    
    @Column(name="username")
    private String username;
    
    @Column(name="password")
    private String password;
    
    @Column(name="email")
    private String email;
    
    @Column(name="sex")
    private String sex;
    
    @Column(name="age")
    private int age;
    

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
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
    

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    

    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    

}
