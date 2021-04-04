package com.management.employee.repository;

import org.springframework.data.repository.CrudRepository;

import com.management.employee.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {


}
