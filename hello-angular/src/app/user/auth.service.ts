import { Injectable } from '@angular/core';
import { User } from './user.model';


@Injectable({
  providedIn: 'root'
})
export class AuthService {

  isLoggedIn: boolean = false;

  storeUser(user: User){
    sessionStorage.setItem("userData", JSON.stringify(user));
  }

  retrieveUser(): User{
    var data: any = sessionStorage.getItem("userData");
    return JSON.parse(data == null?'':data);
  }

  removeUser(){
    sessionStorage.removeItem("userData");
  }

  retrieveUserType(){
    var data: any = sessionStorage.getItem("userData");
    var user: User = JSON.parse(data == null?'':data);
    return user.userType;
  }
  constructor() { }
}
