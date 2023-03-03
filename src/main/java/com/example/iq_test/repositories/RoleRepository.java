package com.example.iq_test.repositories;

import com.example.iq_test.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
    List<Role> findByNameOrName(String name1, String name2);
}
