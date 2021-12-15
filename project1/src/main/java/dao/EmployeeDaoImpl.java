package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import exception.ApplicationException;
import pojo.EmployeePojo;
import pojo.ReimbursmentPojo;

public class EmployeeDaoImpl implements EmployeeDao {
	private static final Logger logger = LogManager.getLogger(EmployeeDaoImpl.class);

	@Override
	public List<ReimbursmentPojo> empPending() throws ApplicationException {
		logger.info("Entered empPending() in dao.");
		List<ReimbursmentPojo> allEmpPendingPojo = new ArrayList<ReimbursmentPojo>();

		Connection conn = DBUtil.makeConnection();
		Statement stmt;

		try {
			stmt = conn.createStatement();
			String query = "select * from reimbursment_details where rb_status='pending'";
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				ReimbursmentPojo reimbursmentPojo = new ReimbursmentPojo(rs.getInt(1), rs.getInt(2), rs.getInt(3),
						rs.getInt(4), rs.getString(5));
				allEmpPendingPojo.add(reimbursmentPojo);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		logger.info("Exited empPending() in dao.");
		return allEmpPendingPojo;
	}

	// ------------------------------------------------------------------------------------------------------------------------------------------------

	@Override
	public List<ReimbursmentPojo> empResolve() throws ApplicationException {

		logger.info("Entered empResolve() in dao.");

		List<ReimbursmentPojo> allEmpResolvePojo = new ArrayList<ReimbursmentPojo>();
		Connection conn = DBUtil.makeConnection();
		Statement stmt;

		try {
			stmt = conn.createStatement();
			String query = "select * from reimbursment_details where emp_id rb_status='resolve'";
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				ReimbursmentPojo reimbursmentPojo = new ReimbursmentPojo(rs.getInt(1), rs.getInt(2), rs.getInt(3),
						rs.getInt(4), rs.getString(5));
				allEmpResolvePojo.add(reimbursmentPojo);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		logger.info("Exited empRsolve() in dao.");
		return allEmpResolvePojo;

	}

	// -----------------------------------------------------------------------------------------------------------------------------------------------
	@Override
	public List<EmployeePojo> employeeViewInfo() throws ApplicationException {

		List<EmployeePojo> allEmpInfoPojos = new ArrayList<EmployeePojo>();

		Connection conn = DBUtil.makeConnection(); // Get database connection
		Statement stmt;
		try {
			stmt = conn.createStatement();
			String query = "select * from employee_details";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {

				EmployeePojo employeePojo = new EmployeePojo(rs.getInt(1), rs.getString(2), rs.getString(3));

				allEmpInfoPojos.add(employeePojo);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		logger.info("Exited ViewAllEmpInfo() in dao.");
		return allEmpInfoPojos;

	}

	// ---------------------------------------------------------------------------------------------------------------------------------
	@Override
	public EmployeePojo updateInfo(EmployeePojo employeePojo) throws ApplicationException {

		logger.info("Entered updateInfo() in dao.");

		// jdbc step 3 and 4

		try {
			Connection conn = DBUtil.makeConnection();
			Statement stmt = conn.createStatement();
			String query = "update employee_details set emp_name='" + employeePojo.getEmpName() + "',  emp_address='"
					+ employeePojo.getEmpAddress() + "' where emp_id=" + employeePojo.getEmpId();

			int rowsAffected = stmt.executeUpdate(query);
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}

		logger.info("Exited update() in dao.");
		return employeePojo;

	}

	/*----------------------------------------------------------------------------------------------------------------------*/
	@Override
	public void exitApplication() {
		logger.info("Entered exitApplication() in dao.");
		DBUtil.closeConnection();
		logger.info("Exited exitApplication() in dao.");
	}

}
