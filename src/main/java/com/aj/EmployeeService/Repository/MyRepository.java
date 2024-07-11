package com.aj.EmployeeService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aj.EmployeeService.Entity.Employee;

@Repository
public interface MyRepository extends JpaRepository<Employee, Integer> {

}
