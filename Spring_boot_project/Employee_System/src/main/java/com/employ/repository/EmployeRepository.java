package com.employ.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.employ.entity.Employee1;

public interface EmployeRepository extends JpaRepository<Employee1, Integer> {

}
