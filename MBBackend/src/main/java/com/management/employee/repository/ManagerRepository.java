package com.management.employee.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.management.employee.entity.ManagerEntiry;

@Repository
public interface ManagerRepository extends JpaRepository<ManagerEntiry, Integer> {

	Optional<ManagerEntiry> findByEmail(String username);

}
