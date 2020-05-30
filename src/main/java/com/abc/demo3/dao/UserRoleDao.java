package com.abc.demo3.dao;

import com.abc.demo3.entity.Role;
import com.abc.demo3.entity.User;
import com.abc.demo3.entity.UserRole;
import com.abc.demo3.repo.RoleRepo;
import com.abc.demo3.repo.UserRepo;
import com.abc.demo3.repo.UserRoleRepo;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
@DependsOn({"userDao", "roleDao"})
public class UserRoleDao {

    private final UserRoleRepo userRoleRepo;
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;

    @PostConstruct
    void init() {
        List<User> userList = userRepo.findAll();
        List<Role> roleList = roleRepo.findAll();

        List<UserRole> userRoleList = new ArrayList<>();
        for (User user : userList) {
            for (Role role : roleList) {

                String username = user.getUsername();
                String roleName = role.getRoleName();

                if (username.equals("david")
                        && (roleName.equals("PRODUCT_MANAGER") || roleName.equals("HR_MANAGER"))) {
                    setUserRoleList(userRoleList, user.getId(), role.getId());
                } else if (username.equals("andy")
                        && roleName.equals("PRODUCT_MANAGER")) {
                    setUserRoleList(userRoleList, user.getId(), role.getId());
                } else if (username.equals("amber")
                        && roleName.equals("PRODUCT_STAFF")) {
                    setUserRoleList(userRoleList, user.getId(), role.getId());
                } else if (username.equals("bob")
                        && roleName.equals("HR_MANAGER")) {
                    setUserRoleList(userRoleList, user.getId(), role.getId());
                } else if (username.equals("bill")
                        && roleName.equals("HR_STAFF")) {
                    setUserRoleList(userRoleList, user.getId(), role.getId());
                } else if (username.equals("clare")
                        && (roleName.equals("PRODUCT_STAFF") || roleName.equals("HR_STAFF"))) {
                    setUserRoleList(userRoleList, user.getId(), role.getId());
                }
            }
        }
        userRoleRepo.saveAll(userRoleList);
    }

    private void setUserRoleList(List<UserRole> userRoleList, Long userId, Long roleId) {
        UserRole userRole = UserRole.builder().userId(userId).roleId(roleId).build();
        userRoleList.add(userRole);
    }

    public List<UserRole> getByUserId(Long userId) {
        return userRoleRepo.findByUserId(userId);
    }

}
