package com.sparken.service;
import java.util.*;
import com.sparken.entity.EmployeeEntity;

public interface EmployeeService
{
	
  public List<EmployeeEntity> getemployeeService();
	
  public void saveEmp(EmployeeEntity employee);

  public EmployeeEntity getEmp(int empId);

  public void deleteCust(int empId);
  
}
