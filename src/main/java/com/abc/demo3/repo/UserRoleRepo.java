package com.abc.demo3.repo;

import com.abc.demo3.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleRepo extends JpaRepository<UserRole, Long> {

    List<UserRole> findByUserId(Long userId);

}
