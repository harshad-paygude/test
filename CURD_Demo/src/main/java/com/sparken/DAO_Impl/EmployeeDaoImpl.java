package com.sparken.DAO_Impl;
import java.util.List;
import javax.transaction.SystemException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.sparken.DAO.EmployeeDao;
import com.sparken.entity.EmployeeEntity;

@Repository
public class EmployeeDaoImpl implements EmployeeDao
{
    @Autowired
    private SessionFactory sessionFactory;
    
    public SessionFactory getSessionFactory() 
	{
		return sessionFactory;
	}
    
	public void setSessionFactory(SessionFactory sessionFactory) 
	{
		this.sessionFactory = sessionFactory;
	}
	Session session=null;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeEntity> getgetemployeeService()
	{
		List<EmployeeEntity> empList = null;
		
		try 
		{
			session =  getSessionFactory().openSession();
			
			empList = session.createQuery("from EmployeeEntity").list();
			
			session.flush();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		finally
		{
			session.close();
		}
		return empList;
	}
	
	@Override
	public void saveEmp(EmployeeEntity employee)
	{
		Session session = null;
		Transaction t=null;
		
		try 
		{
		  session = getSessionFactory().openSession();
		
		  t=session.beginTransaction();
		
		  session.saveOrUpdate(employee);
		  t.commit();
		}
		catch(Exception e) 
		{
		  e.printStackTrace();
		  t.rollback();
		}
		finally 
		{
			session.close();
		}
	}
	
	@Override
	public EmployeeEntity getEmpUpdate(int empId)
	{
		 EmployeeEntity employee= null;
		
		try 
		{
			session = getSessionFactory().openSession();
			
	        employee = (EmployeeEntity) session.get(EmployeeEntity.class , empId);
	        
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
        finally
        {
          session.close();	
        }
		return employee;
	}
	
	@Override
	public void getEmpdelete(int empId) 
	{
		EmployeeEntity employee = null;
		try {
			  session=getSessionFactory().openSession();
			 
			  Transaction t=session.beginTransaction();
			  
			  employee = new EmployeeEntity();
			  
			  employee.setId(empId);
			  
			  session.delete(employee);
			 
			  t.commit(); 
		    }
	    catch (Exception e)
		{ 
	    	e.printStackTrace();
	    } 
		finally 
		{ 
			session.close();
		}
	}
}
