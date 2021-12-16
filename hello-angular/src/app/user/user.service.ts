import { Injectable } from '@angular/core';
import { User } from './user.model';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {
    baseUrl = "http://localhost:5050/api/user";
 // constructor() { }
  constructor(private http: HttpClient) { }
  getAllUserService():Observable<User[]>{
    return this.http.get<User[]>(this.baseUrl);
  
  }
  validateUser(newUser: User):Observable <User> {
    return this.http.post<User>(this.baseUrl, newUser);
   }  
  //validateUser(user: User){
  //consume end point to validate the user
   // if(user.userId == 1 && user.userPassword == "empOne"){
    //  user.userType = "employee";
   // } else if(user.userId == 2 && user.userPassword == "empTwo"){
   //   user.userType = "employee";
   // }else if(user.userId == 3 && user.userPassword == "admin"){
  //    user.userType = "manager";
  //  }
  // return user;
 // }
}
