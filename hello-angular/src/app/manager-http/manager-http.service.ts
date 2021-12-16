import { Injectable } from '@angular/core';
import { Manager } from '../manager/manager.model';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ManagerHttpService {
  baseUrl = "http://localhost:5050/api/manager/all";

  
  constructor(private http: HttpClient) { }

  getAllManagerService():Observable<Manager[]>{
    return this.http.get<Manager[]>(this.baseUrl);
  
  }
}
