import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';
import { User } from '../user.model';
import { UserService } from '../user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  
  newUser: User = new User();

 // userName = "";
 // password = "";
  //userType = "";

  constructor(private userService: UserService,
    private authService: AuthService,
    private router: Router) { }

  ngOnInit(): void {
  }
  
  validateLogin(){
    
    this.userService.validateUser(this.newUser).subscribe(
      (response) => {
        this.newUser= response;
        if(this.newUser.userType != "" ){ // means it is a successful login
          this.authService.storeUser(this.newUser);
          this.authService.isLoggedIn = true;
    
        }
        if(this.newUser.userType == "employee" ){
          this.router.navigate(['employee-info-http']);
          //this.router.navigate(['reimbursment']);
        }else if(this.newUser.userType == "admin" ){
          this.router.navigate(['manager-info-http']);
          //this.router.navigate(['reimbursment']);
        }
      }
    );
    
  }

  }

