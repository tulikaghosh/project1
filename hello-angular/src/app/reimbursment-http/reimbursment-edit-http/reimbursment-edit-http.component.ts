import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Reimbursment } from 'src/app/reimbursment/reimbursment.model';

import { ReimbursmentHttpService } from '../reimbursment-http.service';
//import { Reimbursment } from '../reimbursment.model';

@Component({
  selector: 'app-reimbursment-edit-http',
  templateUrl: './reimbursment-edit-http.component.html',
  styleUrls: ['./reimbursment-edit-http.component.css']
})
export class ReimbursmentEditHttpComponent implements OnInit {

  updateReimbursment: Reimbursment = {
    rbId: 0, 
    empId: 0,
    rbAmount: 0, 
    rbStatus: "",
  }

  constructor(private reimbursmentService: ReimbursmentHttpService,
    private activatedRoute: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    var receivedReimbursmentId: any = this.activatedRoute.snapshot.paramMap.get("sentRbId");
    console.log(receivedReimbursmentId);
    this.reimbursmentService.getAReimbursmentService(receivedReimbursmentId).subscribe(
      (response) => {
        this.updateReimbursment = response;
      },
      (error)=> {
        console.log(error);
      }
    );
  }
  editReimbursment(){
    this.reimbursmentService.updateReimburementService(this.updateReimbursment).subscribe(
      (response) => {
        console.log(response);
    this.router.navigate(['reimbursment-info']);
  },
  (error)=> {
    console.log(error);
  }
);
  }
}
