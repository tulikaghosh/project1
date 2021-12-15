package dao;

import exception.ApplicationException;
import pojo.UserPojo;

public interface UserDao {
	
	 UserPojo userLogin(UserPojo userPojo) throws ApplicationException;
		
	 void exitApplication();

}
