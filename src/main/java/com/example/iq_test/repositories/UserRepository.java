package com.example.iq_test.repositories;

import com.example.iq_test.models.Role;
import com.example.iq_test.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByName(String userName);
    List<User> findByRoles(Role role);
    List<User> findByRolesIn(List<Role> roles);
}
