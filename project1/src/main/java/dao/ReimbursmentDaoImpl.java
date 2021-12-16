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


public class ReimbursmentDaoImpl implements ReimbursmentDao {
	private static final Logger logger = LogManager.getLogger(ReimbursmentDaoImpl.class);
	


	
	@Override	
	 
	public ReimbursmentPojo approveRb(ReimbursmentPojo reimbursmentPojo) throws ApplicationException {
		logger.info("Entered aproveRb() in dao.");
		
		// jdbc step 3 and 4
		Connection conn = DBUtil.makeConnection();
		try {
			Statement stmt = conn.createStatement();
			String query = "update reimbursment_details set rb_status='"+reimbursmentPojo.getRbStatus()
							+"' where rb_id="+reimbursmentPojo.getRbId();

		 stmt.executeUpdate(query);
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());		
		}
		
		logger.info("Exited approveRb() in dao.");
		return reimbursmentPojo;

	
}
//-------------------------------------------------------------------------------------------------------------------------------------------------------
@Override
public ReimbursmentPojo addreimbursment(ReimbursmentPojo reimbursmentPojo) throws ApplicationException {

	logger.info("Entered addReimbursment() in dao.");

	// reimbursmentPojo.setReimbursmentRemoved(false);

	try {

		Connection conn = DBUtil.makeConnection();
		Statement stmt = conn.createStatement();

		String query = "insert into reimbursment_details(rb_id, rb_amount, rb_status)" + "values('"
				+ reimbursmentPojo.getRbId() + "','" + reimbursmentPojo.getRbAmount() + "','"
				+ reimbursmentPojo.getRbStatus() + "') returning rb_id";
		ResultSet rs = stmt.executeQuery(query);
		rs.next();
		reimbursmentPojo.setRbId(rs.getInt(1));
	} catch (SQLException e) {
		throw new ApplicationException(e.getMessage());
	}

	logger.info("Exited addBook() in dao.");
	return reimbursmentPojo;

}

//--------------------------------------------------------------------------------------------------------------------------------------------------------

@Override

public List<ReimbursmentPojo> getARb(int empId) throws ApplicationException{
	logger.info("Entered getARb() in dao.");
	
	List<ReimbursmentPojo> allUserRb = new ArrayList<ReimbursmentPojo>();
	
	Connection conn = DBUtil.makeConnection();
	Statement stmt;
	ReimbursmentPojo reimbursmentPojo = null;
	try {
		stmt = conn.createStatement();
		String query = "select * from reimbursment_details where emp_id=" + empId;
		ResultSet rs = stmt.executeQuery(query);

		while (rs.next()) {
			reimbursmentPojo = new ReimbursmentPojo(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4),
					rs.getString(5));
			
			allUserRb.add(reimbursmentPojo);
		}
	} catch (SQLException e) {
		throw new ApplicationException(e.getMessage());
	}
	logger.info("Exited getgetARb() in dao.");
	
    return allUserRb;
}
//--------------------------------------------------------------------------------------------------------------------------------------------------------

@Override
public List<ReimbursmentPojo> viewAllPendingRb() throws ApplicationException {
	logger.info("Entered viewAllPending() in dao.");

	List<ReimbursmentPojo> allPendingRb = new ArrayList<ReimbursmentPojo>();
    Connection conn = DBUtil.makeConnection();
	Statement stmt;
	try {
		stmt = conn.createStatement();
		String query = "select * from reimbursment_details where rb_status = 'pending' ";
		ResultSet rs = stmt.executeQuery(query);

		while (rs.next()) {
			ReimbursmentPojo reimbursmentPojo = new ReimbursmentPojo(rs.getInt(1), rs.getInt(2), rs.getInt(3),
					rs.getInt(4), rs.getString(5));

			allPendingRb.add(reimbursmentPojo);

		}
	} catch (SQLException e) {
		throw new ApplicationException(e.getMessage());
	}
	logger.info("Exited viewAllPendingRb() in dao.");
	return allPendingRb;
}

// -----------------------------------------------------------------------------------------------------------------------------------------------------
@Override
public List<ReimbursmentPojo> viewAllResolveRb() throws ApplicationException {

	logger.info("Entered viewAllResolvedRb() in dao.");

	// create a empty collection which is going to hold all the reords from the DB
	// as pojo Object
	List<ReimbursmentPojo> allResolvedRb = new ArrayList<ReimbursmentPojo>();

	Connection conn = DBUtil.makeConnection();
	Statement stmt;
	try {
		stmt = conn.createStatement();
		String query = "select * from reimbursment_details where rb_status = 'resolve' ";
		ResultSet rs = stmt.executeQuery(query);

		while (rs.next()) {
			// here as we iterate through the rs we should
			// each record in a pojo object and
			// add it to the collection
			// and at the end we return the collection

		
			ReimbursmentPojo reimbursmentPojo = new ReimbursmentPojo(rs.getInt(1), rs.getInt(2), rs.getInt(3),
					rs.getInt(4), rs.getString(5));

			// add the bookPojo obj to a collection
			allResolvedRb.add(reimbursmentPojo);

		}
	} catch (SQLException e) {
		throw new ApplicationException(e.getMessage());
	}
	logger.info("Exited viewResolvedRb() in dao.");
	return allResolvedRb;
}

// --------------------------------------------------------------------------------------------------------------------------------------------------------
@Override
public List<ReimbursmentPojo> viewAllReimbursment() throws ApplicationException {

	logger.info("Entered viewAllReimbursment() in dao.");

	// create a empty collection which is going to hold all the reords from the DB
	// as pojo Object
	List<ReimbursmentPojo> allReimbursment = new ArrayList<ReimbursmentPojo>();

	Connection conn = DBUtil.makeConnection();
	Statement stmt;
	try {
		stmt = conn.createStatement();
		String query = "select * from reimbursment_details";
		ResultSet rs = stmt.executeQuery(query);

		while (rs.next()) {
			ReimbursmentPojo reimbursmentPojo = new ReimbursmentPojo(rs.getInt(1), rs.getInt(2), rs.getInt(3),
					rs.getInt(4), rs.getString(5));

			// add the bookPojo obj to a collection
			allReimbursment.add(reimbursmentPojo);

		}
	} catch (SQLException e) {
		throw new ApplicationException(e.getMessage());
	}
	logger.info("Exited viewResolvedRb() in dao.");
	return allReimbursment;
}

//------------------------------------------------------------------------------------------------------------------------------------------------------ @Override 
@Override
public void exitApplication() {
	logger.info("Entered exitApplication() in dao.");
	DBUtil.closeConnection();
	logger.info("Exited exitApplication() in dao.");
}
}
