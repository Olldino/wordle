/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.wordle;

import java.util.Set;

/**
 *
 * @author HP
 */
public class User {
    
    private String username;
    private String password;
    private Set<User> userdatenSet;

    public User(){}

    public User(String username, String password, Set<Character> characterSet) {
        this.username = username;
        this.password = password;
        this.userdatenSet = userdatenSet;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Set<User> getuserdatenSet() {
        return userdatenSet;
    }

    public void setCharacterSet(Set<User> userdatenSet) {
        this.userdatenSet = userdatenSet;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
}
