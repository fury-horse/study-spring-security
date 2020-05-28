package com.liangjun.studyspringsecurity;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @author Liang Jun
 * @version 1.0
 * @desc
 * @date 2020年05月18日 13:10:51
 **/
public class MyUserDetails implements UserDetails {
    private String username;
    private String password;


    public MyUserDetails(String dbUsername, String dbPassword) {
        this.username = dbUsername;
        this.password = dbPassword;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}