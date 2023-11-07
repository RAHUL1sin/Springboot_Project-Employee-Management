package com.employ.service;

import java.util.List;

import com.employ.entity.Employee1;

public interface EmployeService {

	public Employee1 saveEmp(Employee1 emp);

	public List<Employee1> getAllEmp();

	public Employee1 getEmpById(int id);

	public boolean deleteEmp(int id);

}
