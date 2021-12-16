import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';



import { LoginComponent } from './user/login/login.component';
import { FormsModule } from '@angular/forms';
import { HeaderComponent } from './header/header.component';


import { ManagerListComponent } from './manager/manager-list/manager-list.component';
import { ReimbursmentListComponent } from './reimbursment/reimbursment-list/reimbursment-list.component';
import { ReimbursmentEditComponent } from './reimbursment/reimbursment-edit/reimbursment-edit.component';

import { EmployeeListHttpComponent } from './employee-http/employee-list-http/employee-list-http.component';
import { EmployeeEditHttpComponent } from './employee-http/employee-edit-http/employee-edit-http.component';

import { ManagerListHttpComponent } from './manager-http/manager-list-http/manager-list-http.component';
import { ReimbursmentListHttpComponent } from './reimbursment-http/reimbursment-list-http/reimbursment-list-http.component';
import { ReimbursmentEditHttpComponent } from './reimbursment-http/reimbursment-edit-http/reimbursment-edit-http.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HeaderComponent,
    ManagerListComponent,
    ReimbursmentListComponent,
    ReimbursmentEditComponent,
   
    EmployeeListHttpComponent,
    EmployeeEditHttpComponent,
    
    ManagerListHttpComponent,
    ReimbursmentListHttpComponent,
    ReimbursmentEditHttpComponent,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
