package com.sparken.DAO;

import java.util.List;

import com.sparken.entity.EmployeeEntity;

public interface EmployeeDao 
{

	List<EmployeeEntity> getgetemployeeService();

	void saveEmp(EmployeeEntity employee);

	EmployeeEntity getEmpUpdate(int empId);

	void getEmpdelete(int empId);

	
	
}
