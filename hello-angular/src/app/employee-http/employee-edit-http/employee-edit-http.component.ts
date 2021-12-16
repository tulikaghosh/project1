import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Employee } from '../employee.model';
import { EmployeeHttpService } from '../employee-http.service';



@Component({
  selector: 'app-employee-edit-http',
  templateUrl: './employee-edit-http.component.html',
  styleUrls: ['./employee-edit-http.component.css']
})
export class EmployeeEditHttpComponent implements OnInit {

  updateEmployee: Employee = {
    empId: 0, 
    empName: "", 
    empAddress: "",
  }


  constructor(private employeeService: EmployeeHttpService,
    private activatedRoute: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    var receivedEmployeeId: any = this.activatedRoute.snapshot.paramMap.get("sentEmployeeId");
    console.log(receivedEmployeeId);
  
    this.employeeService.getAEmployeeService(receivedEmployeeId).subscribe(
    (response) => {
      this.updateEmployee = response;
    },
    (error)=> {
      console.log(error);
    }
  );
  }

  editEmployee(){
    this.employeeService.updateEmployeeService(this.updateEmployee).subscribe(
      (response) => {
        console.log(response);
        this.router.navigate(['employee-info-http']);
      },
      (error)=> {
        console.log(error);
      }
    );
   

  }

}
