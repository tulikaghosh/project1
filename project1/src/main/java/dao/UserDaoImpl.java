package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import exception.ApplicationException;
import pojo.UserPojo;

public class UserDaoImpl implements UserDao {
	private static final Logger logger = LogManager.getLogger(UserDaoImpl.class);

	public UserPojo userLogin(UserPojo userPojo) throws ApplicationException {
		logger.info("Entered  userLogin() in dao.");

		Connection conn = DBUtil.makeConnection();
		try {
			Statement stmt = conn.createStatement();
			String query = "select * from user_detail where user_id=" + userPojo.getUserId() + " and user_password='"
					+ userPojo.getUserPassword() + "'";

			ResultSet rs = stmt.executeQuery(query);
			if (rs.next()) {
				userPojo.setUserType(rs.getString(3));

			}
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}

		logger.info("Exited userLogin() in dao.");
		return userPojo;
	}
	/*---------------------------------------------------------------------------------------------------------------------------------*/

	public void exitApplication() {
		logger.info("Entered exitApplication() in dao.");
		DBUtil.closeConnection();
		logger.info("Exited exitApplication() in dao.");
	}

}
