package com.example.iq_test.repositories;

import com.example.iq_test.models.ChildGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<ChildGroup, Long> {
}
