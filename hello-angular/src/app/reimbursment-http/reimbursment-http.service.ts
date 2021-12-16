import { Injectable } from '@angular/core';
import { typeWithParameters } from '@angular/compiler/src/render3/util';
import { Reimbursment } from '../reimbursment/reimbursment.model';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class ReimbursmentHttpService {

  baseUrl = "http://localhost:5050/api/reimbursment";

  constructor(private http: HttpClient) { }

  getAllReimbursmentService():Observable <Reimbursment[]>{
    return this.http.get<Reimbursment[]>(this.baseUrl);
  }
  addReimbursmentService(newReimbursment: Reimbursment):Observable <Reimbursment> {
    return this.http.post<Reimbursment>(this.baseUrl, newReimbursment);
  }  


  getAReimbursmentService(empId: number):Observable <Reimbursment> {
    return this.http.get<Reimbursment>(this.baseUrl+"/" + empId);
         
    }
    getPendingReimbursmentService(rbStatus: string):Observable <Reimbursment> {
      return this.http.get<Reimbursment>(this.baseUrl+"/" + rbStatus);
           
      }

  updateReimburementService(updateReimburement: Reimbursment):Observable <Reimbursment> {
    return this.http.put<Reimbursment>(this.baseUrl+"/" +updateReimburement.rbId, updateReimburement );
}
}
