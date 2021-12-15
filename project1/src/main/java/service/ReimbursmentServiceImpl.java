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
import dao.ReimbursmentDao;
import dao.ReimbursmentDaoImpl;
import exception.ApplicationException;
import pojo.ReimbursmentPojo;

public class ReimbursmentServiceImpl implements ReimbursmentService {

	private static final Logger logger = LogManager.getLogger(ReimbursmentDaoImpl.class);

	ReimbursmentDao reimbursmentDao;

	public ReimbursmentServiceImpl() {
		;
		this.reimbursmentDao = new ReimbursmentDaoImpl();
	}

	@Override

	public ReimbursmentPojo approveRb(ReimbursmentPojo reimbursmentPojo) throws ApplicationException {
		logger.info("Entered aproveRb() in service.");

		ReimbursmentPojo returnReimbursmentPojo = this.reimbursmentDao.approveRb(reimbursmentPojo);

		logger.info("Exited approveRb() in service.");
		return reimbursmentPojo;
	}
	// -------------------------------------------------------------------------------------------------------------------------------------------------------

	@Override
	public ReimbursmentPojo addreimbursment(ReimbursmentPojo reimbursmentPojo) throws ApplicationException {

		logger.info("Entered addReimbursment() in service.");

		ReimbursmentPojo returnReimbursmentPojo = this.reimbursmentDao.addreimbursment(reimbursmentPojo);
		logger.info("Exited addBook() in service.");
		return reimbursmentPojo;

	}

	// --------------------------------------------------------------------------------------------------------------------------------------------------------

	@Override
	
	 public List<ReimbursmentPojo> getARb(int empId) throws ApplicationException{
		logger.info("Entered getARb() in service.");
		List<ReimbursmentPojo> allUserRb = new ArrayList<ReimbursmentPojo>();
	
        logger.info("Exited getgetARb() in service.");
		
		return allUserRb;

	}
	// --------------------------------------------------------------------------------------------------------------------------------------------------------

	@Override
	public List<ReimbursmentPojo> viewAllPendingRb() throws ApplicationException {
		logger.info("Entered viewAllPending() in service.");

		List<ReimbursmentPojo> allPendingRb = this.reimbursmentDao.viewAllPendingRb();

		logger.info("Exited viewAllPendingRb() in service.");
		return allPendingRb;
	}

	// -----------------------------------------------------------------------------------------------------------------------------------------------------
	@Override
	public List<ReimbursmentPojo> viewAllResolveRb() throws ApplicationException {

		logger.info("Entered viewAllResolvedRb() in service.");

		List<ReimbursmentPojo> allResolvedRb = this.reimbursmentDao.viewAllResolveRb();

		logger.info("Exited viewResolvedRb() in service.");
		return allResolvedRb;
	}

	// ---------------------------------------------------------------------------------------------------------------------------------------------------------
	@Override
	public List<ReimbursmentPojo> viewAllReimbursment() throws ApplicationException {

		logger.info("Entered viewAllReimbursment() in service.");

		List<ReimbursmentPojo> allReimbursment = this.reimbursmentDao.viewAllReimbursment();

		logger.info("Exited viewResolvedRb() in service.");
		return allReimbursment;
	}

	// ------------------------------------------------------------------------------------------------------------------------------------------------------

	@Override
	public void exitApplication() {
		logger.info("Entered exitApplication() in dao.");
		DBUtil.closeConnection();
		logger.info("Exited exitApplication() in dao.");
	}

}
