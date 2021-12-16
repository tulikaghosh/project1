package service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.DBUtil;
import dao.UserDao;
import dao.UserDaoImpl;
import exception.ApplicationException;
import pojo.ReimbursmentPojo;
import pojo.UserPojo;

public class UserServiceImpl implements UserService {
	private static final Logger logger = LogManager.getLogger(UserServiceImpl.class);

	UserDao userDao = new UserDaoImpl();

	public UserPojo userLogin(UserPojo userPojo) throws ApplicationException {
		logger.info("Entered  userLogin() in dao.");

		UserPojo returnUserPojo = this.userDao.userLogin(userPojo);

		logger.info("Exited  userLogin()  in dao.");
		return userPojo;
	}

	/*----------------------------------------------------------------------------------------------------------------------*/

	public void exitApplication() {
		logger.info("Entered exitApplication() in dao.");
		DBUtil.closeConnection();
		logger.info("Exited exitApplication() in dao.");
	}

}
