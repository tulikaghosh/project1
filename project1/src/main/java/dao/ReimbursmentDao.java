package dao;

import java.util.List;

import exception.ApplicationException;
import pojo.EmployeePojo;
import pojo.ReimbursmentPojo;

public interface ReimbursmentDao {

 public ReimbursmentPojo approveRb(ReimbursmentPojo reimbursmentPojo) throws ApplicationException;
 
 public ReimbursmentPojo addreimbursment(ReimbursmentPojo reimbursmentPojo) throws ApplicationException;
 
 public List<ReimbursmentPojo> getARb(int empId) throws ApplicationException;
 
 public List<ReimbursmentPojo> viewAllPendingRb() throws ApplicationException;
 
 public List<ReimbursmentPojo> viewAllResolveRb() throws ApplicationException;
 
 public List<ReimbursmentPojo> viewAllReimbursment() throws ApplicationException;

 
 void exitApplication();

}