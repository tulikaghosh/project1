import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Reimbursment } from 'src/app/reimbursment/reimbursment.model';
import { ReimbursmentHttpService } from '../reimbursment-http.service';



@Component({
  selector: 'app-reimbursment-list-http',
  templateUrl: './reimbursment-list-http.component.html',
  styleUrls: ['./reimbursment-list-http.component.css']
})
export class ReimbursmentListHttpComponent implements OnInit {

  flag: boolean = false;

  allReimbursment:Reimbursment[] = [];

  errorMsg: string = '';

  newReimbursment:Reimbursment = {
    empId: 0,
    rbId:0,
    rbAmount: 0,
    rbStatus: "",
  }


  constructor(private reimbursmentHttpService: ReimbursmentHttpService,
    private router: Router) { }

  ngOnInit(): void {
    this.loadReimbursment();
    console.log("after calling getAllReimbursmentService()");
  }

  loadReimbursment(){
    this.reimbursmentHttpService.getAllReimbursmentService().subscribe(
      (response)=> {
        console.log(response);
        this.allReimbursment = response;
      },
      (error)=>{
        console.log(error);
        this.errorMsg = 'There was some internal error! Please try again later!';
        console.log(this.errorMsg);
      }
    );
  }


  toggleAdd(){
    if(this.flag){
      this.flag = false;
    }else{
      this.flag = true;
    }
  }
 
  addReimbursment(){
    this.reimbursmentHttpService.addReimbursmentService(this.newReimbursment).subscribe(
      (response) => {
        console.log(response);
        this.loadReimbursment();
      },
      (error) => {
        console.log(error);
      }
    )
    
}

  loadARequest(empId: any){
    this.reimbursmentHttpService.getAReimbursmentService(empId).subscribe(
     (response)=> {
        console.log(response);
        this.loadReimbursment();
      },
      (error)=>{
        console.log(error);
      }
    );
  }

  loadRequestType(rbStatus: any){
    this.reimbursmentHttpService. getPendingReimbursmentService(rbStatus).subscribe(
     (response)=> {
        console.log(response);
        this.loadReimbursment;
      },
     (error)=>{
        console.log(error);
      }
    );
  }
goToEditComponent(rbId: any){
  console.log("logged: " + rbId);
  this.router.navigate(['reimbursment-update-http', rbId])
}


}
