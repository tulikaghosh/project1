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
import pojo.ManagerPojo;

public class ManagerDaoImpl implements ManagerDao {

	private static final Logger logger = LogManager.getLogger(ManagerDaoImpl.class);

	@Override
	public List<EmployeePojo> employeeViewInfo() throws ApplicationException {
		logger.info("Entered employeeViewInfo() in dao.");
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
		logger.info("Exited employeeViewInfo() in dao.");
		return allEmpInfoPojos;

	}
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------

	public List<ManagerPojo> managerViewInfo() throws ApplicationException {
		logger.info("Entered managerViewInfo() in dao.");

		List<ManagerPojo> allManagerInfoPojos = new ArrayList<ManagerPojo>();

		Connection conn = DBUtil.makeConnection(); // Get database connection
		Statement stmt;
		try {
			stmt = conn.createStatement();
			String query = "select * from manager_details";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {

				ManagerPojo managerPojo = new ManagerPojo(rs.getInt(1), rs.getString(2), rs.getString(3));

				allManagerInfoPojos.add(managerPojo);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		logger.info("Exited ViewAllManagerInfo() in dao.");
		return allManagerInfoPojos;
	}

//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	@Override
	public void exitApplication() {
		logger.info("Entered exitApplication() in dao.");
		DBUtil.closeConnection();
		logger.info("Exited exitApplication() in dao.");
	}

}
