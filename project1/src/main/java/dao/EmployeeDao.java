package dao;

import java.util.List;

import exception.ApplicationException;
import pojo.EmployeePojo;
import pojo.ReimbursmentPojo;


public interface EmployeeDao {
	
	 public List<ReimbursmentPojo> empPending() throws ApplicationException;
	 
	 public List<ReimbursmentPojo> empResolve() throws ApplicationException;
	 
     public List<EmployeePojo> employeeViewInfo() throws ApplicationException;
 
     public EmployeePojo updateInfo(EmployeePojo employeePojo) throws ApplicationException; 
     
     void exitApplication();

}
