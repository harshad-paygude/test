package com.sparken.controller;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sparken.entity.EmployeeEntity;
import com.sparken.service.EmployeeService;

@Controller
public class EmployeeController 
{
	private EmployeeService employeeService;
	
	@Autowired
	public void setemployeeService(EmployeeService employeeService)
	{
		this.employeeService=employeeService;
	}
	
	@RequestMapping(value="/viewEmp", method=RequestMethod.GET )
	public String EmployeeList(HttpServletRequest req , HttpServletResponse res , Model model)
	{
		//System.out.println("in controller");
		try 
		{
		    List <EmployeeEntity> empList = employeeService.getemployeeService();
			/*
			 * for (EmployeeEntity employeeEntity : empList) { System.out.println(
			 * employeeEntity.getFirstname());
			 * System.out.println(employeeEntity.getLastname()); }
			 */
		    model.addAttribute("emplist" , empList);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return "viewEmp";
	}
	
	@RequestMapping(value="/addEmp" , method =RequestMethod.GET)
	public String addEmp(Model model)
	{
		//System.out.println("in controller");
		
		EmployeeEntity employeeEntity = new EmployeeEntity();
	
        model.addAttribute("employee" , employeeEntity);
		
		return "addEmp";
	}
	
	@RequestMapping(value="/addEMPDATA")
	public String addEmp1(HttpServletRequest req , @ModelAttribute("employee")EmployeeEntity entity1 )
	{
		//EmployeeEntity entity =new EmployeeEntity();
		//System.out.println(req.getParameter("idd"));
		//entity.setId(Integer.parseInt(req.getParameter("id")));
		//entity.setFirstname(req.getParameter("firstname"));
		//entity.setLastname(req.getParameter("lastname"));
		//entity.setMobileno(req.getParameter("mobileno"));
		
		employeeService.saveEmp(entity1);
	
		return "redirect:viewEmp";
	}
	
	@RequestMapping(value="/updateEmp", method = RequestMethod.GET)
	public String updateEmp(@RequestParam("empId") int empId, Model model)
	{
		EmployeeEntity theEmployee = employeeService.getEmp(empId);
		
		model.addAttribute("employee",theEmployee);
		
		return "/addEmp";
	}
	
	@RequestMapping(value="/deleteEmp" , method = RequestMethod.GET)
	public String deleteEmp(@RequestParam("empId") int empId )
	{
		employeeService.deleteCust(empId);
		
		return"redirect:/viewEmp";
	}	
	
	
}