import { typeWithParameters } from '@angular/compiler/src/render3/util';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import{ Reimbursment } from './reimbursment.model';
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class ReimbursmentService {
   // baseUrl = "http://localhost:5050/api/reimbursment/resolve";
 allReimbursment: Reimbursment[] = [
    {
       empId: 1,
      rbId:1,
      rbAmount: 100,
      rbStatus: "resolve",
    },
    {
      empId: 2,
      rbId:2,
      rbAmount: 200,
      rbStatus: "resolve",
    }
  ];

  constructor() { }
   // constructor(private http: HttpClient) { } 
   
    // getAllpendingService():Observable <Reimbursment[]>{
 //   return this.http.get<Reimbursment[]>(this.baseUrl);
  //}

  getAllReimbursmentService(): Reimbursment[]{
    return this.allReimbursment;
  }
  addReimbursmentService(newReimbursment: Reimbursment): void{
   this.allReimbursment.push(newReimbursment);
  }  

  
  getAReimbursmentService(rbId: number): Reimbursment{
    var sendReimbursment: Reimbursment = {
          rbId: 0, 
          empId: 0, 
          rbAmount: 0,
          rbStatus: "",
         
    };
    this.allReimbursment.forEach((value, index) => {
     if(this.allReimbursment[index].rbId == rbId){
        sendReimbursment = this.allReimbursment[index];
      }
    });
    return sendReimbursment;
  }

  updateReimburementService(updateReimburement: Reimbursment): void{
    this.allReimbursment.forEach((value, index) => {
      if(this.allReimbursment[index].rbId == updateReimburement.rbId){
         this.allReimbursment[index] = updateReimburement;
      }
   });
}
}