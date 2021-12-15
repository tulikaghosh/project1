package service;

import exception.ApplicationException;
import pojo.UserPojo;

public interface UserService {
	
	public UserPojo userLogin(UserPojo userPojo) throws ApplicationException;
	void exitApplication();

}
