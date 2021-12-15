import java.time.LocalDate;

import org.postgresql.util.PSQLException;

import exception.ApplicationException;
import io.javalin.Javalin;
import pojo.EmployeePojo;
import pojo.ErrorPojo;
import pojo.ManagerPojo;
import pojo.ReimbursmentPojo;
import pojo.UserPojo;
import service.EmployeeService;
import service.ManagerService;
import service.ReimbursmentService;
import service.EmployeeServiceImpl;
import service.ManagerServiceImpl;
import service.ReimbursmentServiceImpl;
import service.UserService;
import service.UserServiceImpl;

public class ReimbursmentCrudMain {

	public static void main(String[] args) {

		ManagerService managerService = new ManagerServiceImpl();
		EmployeeService employeeService = new EmployeeServiceImpl();
		ReimbursmentService reimbursmentService = new ReimbursmentServiceImpl();
		UserService userService = new UserServiceImpl();

		Javalin server = Javalin.create((config) -> config.enableCorsForAllOrigins()).start(5050);

		// http://localhost:5050/api/employee
		server.get("api/employee", (ctx) -> {
			ctx.json(employeeService.employeeViewInfo());
			System.out.println("get all employee!");

		});

		server.get("api/employee/pending", (ctx) -> {
			ctx.json(employeeService.empPending());
			System.out.println("get pending info!");

		});

		server.get("api/employee/resolve", (ctx) -> {
			ctx.json(employeeService.empResolve());
			System.out.println("get resolve info!");

		});

		// http://localhost:5050/api/employee
		server.put("api/employee/{bid}", (ctx) -> {
			EmployeePojo returnEmployeePojo = employeeService.updateInfo(ctx.bodyAsClass(EmployeePojo.class));
			ctx.json(returnEmployeePojo);
		});
//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------

		// http://localhost:5050/api/manager/all
		server.get("api/manager/all", (ctx) -> {
			ctx.json(managerService.managerViewInfo());
			System.out.println("get all manager!");

		});

//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------				
		
		// http://localhost:5050/api/reimbursment/all
		server.get("api/reimbursment", (ctx) -> {
			ctx.json(reimbursmentService.viewAllReimbursment());
			System.out.println("get reimbursment info!");

		});
		server.get("api/reimbursment/resolve", (ctx) -> {
			ctx.json(reimbursmentService.viewAllResolveRb());
			System.out.println("get reimbursment info!");

		});
		server.get("api/reimbursment/pending", (ctx) -> {
			ctx.json(reimbursmentService.viewAllPendingRb());
			System.out.println("get reimbursment info!");

		});

		// http://localhost:5050/api/reimbursment/1
		
		server.get("api/reimbursment/{bid}", (ctx) -> {
			ctx.json(reimbursmentService.getARb(Integer.parseInt(ctx.pathParam("bid"))));
		});

		// http://localhost:5050/api/reimbursment
		server.post("api/reimbursment", (ctx) -> {
			ReimbursmentPojo returnReimbursmentPojo = reimbursmentService
					.addreimbursment(ctx.bodyAsClass(ReimbursmentPojo.class));
			ctx.json(returnReimbursmentPojo);
		});

		server.put("api/reimbursment/{bid}", (ctx) -> {
			ReimbursmentPojo returnReimbursmentPojo = reimbursmentService
					.approveRb(ctx.bodyAsClass(ReimbursmentPojo.class));
			ctx.json(returnReimbursmentPojo);
		});
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		// http://localhost:5050/api/user
		server.post("api/user", (ctx) -> {
			ctx.json(userService.userLogin(ctx.bodyAsClass(UserPojo.class)));
			System.out.println("get reimbursment info!");
		});
//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
		server.exception(ApplicationException.class, (ae, ctx) -> {
			ErrorPojo error = new ErrorPojo();
			error.setErrorMessage(ae.getMessage());
			ctx.json(error).status(500);
		});

	}

}
