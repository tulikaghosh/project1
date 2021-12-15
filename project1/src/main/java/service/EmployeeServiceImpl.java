package service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.DBUtil;
import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
import exception.ApplicationException;
import pojo.EmployeePojo;
import pojo.ReimbursmentPojo;

public class EmployeeServiceImpl implements EmployeeService {

	private static final Logger logger = LogManager.getLogger(EmployeeDaoImpl.class);

	EmployeeDao employeeDao;

	public EmployeeServiceImpl() {

		this.employeeDao = new EmployeeDaoImpl();
	}

	@Override
	public List<ReimbursmentPojo> empPending() throws ApplicationException {
		logger.info("Entered empPending() in service.");
		List<ReimbursmentPojo> allEmpPendingPojo = new ArrayList<ReimbursmentPojo>();

		Connection conn = DBUtil.makeConnection();
		Statement stmt;

		try {
			stmt = conn.createStatement();
			String query = "select * from reimbursment_details where rb_status='pending'";
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				ReimbursmentPojo reimbursmentPojo = new ReimbursmentPojo(rs.getInt(1), rs.getInt(2), rs.getInt(3),
						rs.getInt(4), rs.getString(3));
				allEmpPendingPojo.add(reimbursmentPojo);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		logger.info("Exited empPending() in service.");
		return allEmpPendingPojo;
	}

	// ------------------------------------------------------------------------------------------------------------------------------------------------
	@Override
	public List<ReimbursmentPojo> empResolve() throws ApplicationException {

		logger.info("Entered empResolve() in service.");

		List<ReimbursmentPojo> allEmpResolvePojo = new ArrayList<ReimbursmentPojo>();
		Connection conn = DBUtil.makeConnection();
		Statement stmt;

		try {
			stmt = conn.createStatement();
			String query = "select * from reimbursment_details where emp_id rb_status='resolve'";
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				ReimbursmentPojo reimbursmentPojo = new ReimbursmentPojo(rs.getInt(1), rs.getInt(2), rs.getInt(3),
						rs.getInt(4), rs.getString(3));
				allEmpResolvePojo.add(reimbursmentPojo);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		logger.info("Exited empRsolve() in service.");
		return allEmpResolvePojo;

	}

	// -----------------------------------------------------------------------------------------------------------------------------------------------
	@Override
	public List<EmployeePojo> employeeViewInfo() throws ApplicationException {
		logger.info("Entered employeeViewInfo() in service.");

		List<EmployeePojo> allEmpInfoPojos = this.employeeDao.employeeViewInfo();

		logger.info("Exited ViewAllEmpInfo() in service.");
		return allEmpInfoPojos;

	}

	// ---------------------------------------------------------------------------------------------------------------------------------
	@Override
	public EmployeePojo updateInfo(EmployeePojo employeePojo) throws ApplicationException {

		logger.info("Entered updateInfo() in service.");

		EmployeePojo returnEmployeePojo = this.employeeDao.updateInfo(employeePojo);

		logger.info("Exited update() in service.");
		return employeePojo;

	}

	/*----------------------------------------------------------------------------------------------------------------------*/
	@Override
	public void exitApplication() {
		logger.info("Entered exitApplication() in service.");
		DBUtil.closeConnection();
		logger.info("Exited exitApplication() in service.");
	}

}
