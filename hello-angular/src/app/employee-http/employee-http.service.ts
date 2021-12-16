import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from './employee.model';


@Injectable({
  providedIn: 'root'
})
export class EmployeeHttpService {

  baseUrl = "http://localhost:5050/api/employee";

  constructor(private http: HttpClient) { }

  getAllEmployeeService():Observable <Employee[]>{
    return this.http.get<Employee[]>(this.baseUrl);
  }
  
  getAEmployeeService(empId: number):Observable <Employee>{
    return this.http.get<Employee>(this.baseUrl+"/"+empId);
    
  }
  updateEmployeeService(updateEmployee: Employee):Observable <Employee> {
    return this.http.put<Employee>(this.baseUrl+"/"+updateEmployee.empId, updateEmployee);
  }
}
