package com.abc.demo3.dao;

import com.abc.demo3.entity.Role;
import com.abc.demo3.repo.RoleRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class RoleDao {

    private final RoleRepo roleRepo;

    @PostConstruct
    void init() {
        List<Role> roleList = List.of(
                Role.builder().roleName("PRODUCT_MANAGER").build(),
                Role.builder().roleName("HR_MANAGER").build(),
                Role.builder().roleName("PRODUCT_STAFF").build(),
                Role.builder().roleName("HR_STAFF").build());

        roleRepo.saveAll(roleList);
    }

    public Optional<Role> getById(Long id) {
        return roleRepo.findById(id);
    }

    public List<String> getAllRoleNames() {
        return roleRepo.findAll().stream()
                .map(Role::getRoleName)
                .collect(Collectors.toList());
    }

}
