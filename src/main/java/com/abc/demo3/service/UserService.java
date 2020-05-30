package com.abc.demo3.service;

import com.abc.demo3.dao.RoleDao;
import com.abc.demo3.dao.UserDao;
import com.abc.demo3.dao.UserRoleDao;
import com.abc.demo3.entity.Role;
import com.abc.demo3.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UserService implements UserDetailsService {

    private final UserDao userDao;
    private final UserRoleDao userRoleDao;
    private final RoleDao roleDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.getByUsername(username).orElse(new User());
        UserDetails userDetails = org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password("{noop}" + user.getPassword())
                .roles(getRoles(user.getId()))
                .build();

        return userDetails;
    }

    private String[] getRoles(Long userId) {
        return userRoleDao.getByUserId(userId).stream()
                .map(e -> roleDao.getById(e.getRoleId())
                        .map(Role::getRoleName).orElse(null))
                .toArray(String[]::new);
    }

    public List<String> getAllUserNames() {
        return userDao.getAllUserNames();
    }

    public List<String> getAllRoleNames() {
        return roleDao.getAllRoleNames();
    }
}
