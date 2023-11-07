package com.employ.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.employ.entity.Employee1;
import com.employ.service.EmployeService;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

	@Autowired
	private EmployeService empService;

	
	@GetMapping("/")
  public String index(Model m)
  {
	List<Employee1>list=empService.getAllEmp();
		m.addAttribute("empList", list);	
	  return "index";
  }

	@GetMapping("/loadEmpSave")
  public String loadEmpSave()
  {
	  return "emp_save";
  }
	@GetMapping("/EditEmp/{id}")
	  public String EditEmp(@PathVariable int id,Model m)
	  {
		// System.out.println(id);
		 Employee1 emp= empService.getEmpById(id);
		 m.addAttribute("emp",emp);
		  return "edit_emp";
	  }
	@PostMapping("/saveEmp")
	public String saveEmp(@ModelAttribute Employee1 emp, HttpSession session) {
		 //System.out.println(emp);
      
	Employee1 newEmp=empService.saveEmp(emp);

	
	if(newEmp!=null)
	{
		 //System.out.println("save success");
					session.setAttribute("msg", "Register sucessfully");	
	}else {
		
		 //System.out.println("something wrong on server");
					session.setAttribute("msg", "something went wrong");
	}

				return "redirect:/loadEmpSave";	 	
	}
	
	@PostMapping("/UpdateEmpDetails")
	public String UpdateEmp(@ModelAttribute Employee1 emp, HttpSession session) {
		// System.out.println(emp);

		Employee1 updateEmp = empService.saveEmp(emp);

		if (updateEmp != null) {
			// System.out.println("save success");
			session.setAttribute("msg", "Update sucessfully");
		} else {
			// System.out.println("something wrong on server");
			session.setAttribute("msg", "something went wrong");
		}

		return "redirect:/";
	}
	@GetMapping("/deleteEmp/{id}")
	public String loadEmpSave(@PathVariable int id, HttpSession session) {
		boolean f = empService.deleteEmp(id);
		if (f) {
			session.setAttribute("msg", "Delete sucessfully");
		} else {
			session.setAttribute("msg", "something went wrong ");
		}
		return "redirect:/";
	}


}
