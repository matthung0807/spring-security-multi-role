package com.abc.demo3.dao;

import com.abc.demo3.entity.User;
import com.abc.demo3.repo.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class UserDao {

    private final UserRepo userRepo;

    @PostConstruct
    void init(){
        List<User> userList = List.of(
                User.builder()
                        .username("admin")
                        .password("123")
                        .role("ADMIN").build(),
                User.builder()
                        .username("officer")
                        .password("123")
                        .role("OFFICER").build(),
                User.builder()
                        .username("staff")
                        .password("123")
                        .role("STAFF").build());

        userRepo.saveAll(userList);
    }

    public List<String> getAllUserNames() {
        return userRepo.findAll().stream()
                .map(User::getUsername)
                .collect(Collectors.toList());
    }

    public Optional<User> getByUsername(String username) {
        return userRepo.findByUsername(username);
    }
}
