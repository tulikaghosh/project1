import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { EmployeeHttpService } from '../employee-http.service';
import { Employee } from '../employee.model';




@Component({
  selector: 'app-employee-list-http',
  templateUrl: './employee-list-http.component.html', 
  styleUrls: ['./employee-list-http.component.css']
})
export class EmployeeListHttpComponent implements OnInit {

  flag: boolean = false;

  allEmployee: Employee[] = [];

  newEmployee: Employee = {
    empId: 0, 
    empName: "", 
    empAddress: "",
    
  }

  constructor( private employeeHttpService: EmployeeHttpService,
    private router: Router) { }

  ngOnInit(): void {
    this.loadEmployee();

    console.log("after calling getAllEmployeeService()");
  }
  
  loadEmployee(){
    this.employeeHttpService.getAllEmployeeService().subscribe(
      (response)=> {
        console.log(response);
        this.allEmployee = response;
      },
      (error)=>{
        console.log(error);
      }
    );
  }
 // loadAEmployee(){
  //  this.employeeHttpService.getAEmployeeService(empId: any).subscribe(
   //   (response)=> {
    //    console.log(response);
    //    this.newEmployee = response;
    //  },
    //  (error)=>{
    //    console.log(error);
    //  }
  //  );
 // }

  goToEditComponent(empId: any){
    console.log("logged: " + empId);
    this.router.navigate(['employee-update-http', empId])
  }

}
