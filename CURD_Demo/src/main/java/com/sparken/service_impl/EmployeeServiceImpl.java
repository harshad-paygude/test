package com.sparken.service_impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sparken.DAO.EmployeeDao;
import com.sparken.entity.EmployeeEntity;
import com.sparken.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService
{
	
	private EmployeeDao employeeDao;

	public EmployeeDao getemployeeDao()
	{
		return employeeDao;
	}
	
	@Autowired
	public void setemployeeDao(EmployeeDao employeeDao)
	{
		this.employeeDao=employeeDao;
	}
	
	@Override
	@Transactional
	public List<EmployeeEntity> getemployeeService() 
	{
		return employeeDao.getgetemployeeService();
	}
	
	@Override
	@Transactional
	public void saveEmp(EmployeeEntity employee)
	{
	   employeeDao.saveEmp(employee); 
	}
	
	@Override
	@Transactional
	public EmployeeEntity getEmp(int empId) 
	{
		return employeeDao.getEmpUpdate(empId);
	}
	
	@Override
	@Transactional
	public void deleteCust(int empId)
	{
		employeeDao.getEmpdelete(empId);
	}
	
}
