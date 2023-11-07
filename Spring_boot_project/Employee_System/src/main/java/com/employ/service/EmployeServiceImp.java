package com.employ.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.condition.RequestConditionHolder;
import com.employ.entity.Employee1;
import com.employ.repository.EmployeRepository;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpServletRequest;

@Service
public class EmployeServiceImp implements EmployeService {

	@Autowired
   private EmployeRepository empRepo;
	
	@Override
	public Employee1 saveEmp(Employee1 emp) {
			Employee1 newEmp = empRepo.save(emp);
			return newEmp;
		
	}

	@Override
	public List<Employee1> getAllEmp() {
		
		return empRepo.findAll();
	}

	@Override
	public Employee1 getEmpById(int id) {
		
		return empRepo.findById(id).get();
	}

	@Override
	public boolean deleteEmp(int id) {
		 Employee1 emp=empRepo.findById(id).get();
		 if (emp != null) {
				empRepo.delete(emp);
				return true;
			}
		return false;
	}
	public void removeSessionMessage() {
		HttpSession session = ((ServletRequestAttributes) (RequestContextHolder.getRequestAttributes())).getRequest()
				.getSession();

		session.removeAttribute("msg");
		}
}
