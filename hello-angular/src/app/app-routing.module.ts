import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { EmployeeEditHttpComponent } from './employee-http/employee-edit-http/employee-edit-http.component';
import { EmployeeListHttpComponent } from './employee-http/employee-list-http/employee-list-http.component';




import { LoginComponent } from './user/login/login.component';
import { ManagerListHttpComponent } from './manager-http/manager-list-http/manager-list-http.component';
import { ManagerListComponent } from './manager/manager-list/manager-list.component';
import { ReimbursmentEditHttpComponent } from './reimbursment-http/reimbursment-edit-http/reimbursment-edit-http.component';
import { ReimbursmentListHttpComponent } from './reimbursment-http/reimbursment-list-http/reimbursment-list-http.component';
import { ReimbursmentEditComponent } from './reimbursment/reimbursment-edit/reimbursment-edit.component';
import { ReimbursmentListComponent } from './reimbursment/reimbursment-list/reimbursment-list.component';

const routes: Routes = [
 
 
 
  { path:'login', component: LoginComponent },


  { path:'employee-info-http', component:  EmployeeListHttpComponent},
  { path:'employee-update-http/:sentEmployeeId', component:  EmployeeEditHttpComponent},
  { path:'manager-info', component:  ManagerListComponent},
  { path:'manager-info-http', component:  ManagerListHttpComponent},
  { path:'reimbursment-info', component:  ReimbursmentListComponent},
  { path:'reimbursment-update/:sentReimbursmentId', component:  ReimbursmentEditComponent},
  { path:'reimbursment-info-http', component:  ReimbursmentListHttpComponent},
  { path:'reimbursment-update-http/:sentReimbursmentId', component:  ReimbursmentEditHttpComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
