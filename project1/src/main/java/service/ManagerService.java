package service;

import java.util.List;

import exception.ApplicationException;
import pojo.EmployeePojo;
import pojo.ManagerPojo;

public interface ManagerService {
	
	 public List<EmployeePojo> employeeViewInfo() throws ApplicationException;
	 public List<ManagerPojo> managerViewInfo() throws ApplicationException;
	 void exitApplication();

}
