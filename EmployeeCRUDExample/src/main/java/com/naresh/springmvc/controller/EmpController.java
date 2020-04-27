package com.naresh.springmvc.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.naresh.springmvc.model.Employee;

@Controller
public class EmpController {
	
	@RequestMapping(value={"/","/list"}, method=RequestMethod.GET)
	public String listOfEmployees(){
		return "allemployees";
	}
	
	@RequestMapping(value="/new", method=RequestMethod.GET)
	public String newEmployee(ModelMap model){
		model.addAttribute("employee", new Employee());
		return "registration";
	}
	
	@RequestMapping(value="/new", method=RequestMethod.POST)
	public String saveEmployee(@Valid Employee employee, BindingResult result, ModelMap model){
		
	if(result.hasErrors()){
		return "registration";
	}
	
	model.addAttribute("success", "Employee " + employee.getName() + " registered successfully");
	return "success";
	}

}
