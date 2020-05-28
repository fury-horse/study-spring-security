package com.liangjun.studyspringsecurity;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
* @desc    
* @version 1.0
* @author  Liang Jun
* @date    2020年05月18日 13:04:18
**/
public class MyUserDetailsService implements UserDetailsService {
    private static Map<String, String> users = new ConcurrentHashMap();

    static {
        users.put("AAA", new BCryptPasswordEncoder().encode("BBB"));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String password = users.get(username);

        if (null == password) {
            //模拟当前用户不存在
            throw new UsernameNotFoundException("用户:" + username + "不存在");
        }

        UserDetails userDetails = new MyUserDetails(username, password);
        return userDetails;
    }
}