import { Component, OnInit } from '@angular/core';
import { ReimbursmentService } from '../reimbursment.service';
import { Reimbursment } from '../reimbursment.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-reimbursment-list',
  templateUrl: './reimbursment-list.component.html',
  styleUrls: ['./reimbursment-list.component.css']
})
export class ReimbursmentListComponent implements OnInit {
  flag: boolean = false;

  allReimbursment:Reimbursment[] = [];
  errorMsg: string = '';
  newReimbursment:Reimbursment = {
    empId: 0,
    rbId:0,
    rbAmount: 0,
    rbStatus: "",
  }

  
  constructor(private reimbursmentService: ReimbursmentService,
              private router: Router) { }

  ngOnInit(): void {
    this.allReimbursment = this.reimbursmentService.getAllReimbursmentService();
  }
   // ngOnInit(): void {
  //  this.loadPending();
  //  console.log("after calling getAllPendingService()");
  //}
 
   // loadReimbursment(){
  //  this.reimbursmentService.getAllreimmbursmentService().subscribe(
   //   (response)=> {
   //     console.log(response);
   //     this.allReimbursment = response;
    //  },
    //  (error)=>{
    //    console.log(error);
     //   this.errorMsg = 'There was some internal error! Please try again later!';
     //   console.log(this.errorMsg);
     // }
   // );
  //}

  toggleAdd(){
    if(this.flag){
      this.flag = false;
    }else{
      this.flag = true;
    }
  }
 
  addReimbursment(){
    var myReimbursment: Reimbursment = {
      rbId: this.allReimbursment[this.allReimbursment.length-1].rbId +1,
      empId:this.newReimbursment.empId,
      rbAmount:this.newReimbursment.rbAmount,
      rbStatus:this.newReimbursment.rbStatus,
    }
      this.allReimbursment.push(myReimbursment);
}
goToEditComponent(rbId: any){
  console.log("logged: " + rbId);
  this.router.navigate(['reimbursment-update', rbId])
}

}
