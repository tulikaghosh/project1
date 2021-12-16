import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ReimbursmentService } from '../reimbursment.service';
import { Reimbursment } from '../reimbursment.model';
 
@Component({
  selector: 'app-reimbursment-edit',
  templateUrl: './reimbursment-edit.component.html',
  styleUrls: ['./reimbursment-edit.component.css']
})
export class ReimbursmentEditComponent implements OnInit {
  
  updateReimbursment: Reimbursment = {
    rbId: 0, 
    empId: 0,
    rbAmount: 0, 
    rbStatus: "",
  }
  constructor(private reimbursmentService: ReimbursmentService,
             private activatedRoute: ActivatedRoute,
             private router: Router) { }

  ngOnInit(): void {
    var receivedReimbursmentId: any = this.activatedRoute.snapshot.paramMap.get("sentRbId");
    console.log(receivedReimbursmentId);
    this.updateReimbursment = this.reimbursmentService.getAReimbursmentService(receivedReimbursmentId);
  }
  editReimbursment(){
    this.reimbursmentService.updateReimburementService(this.updateReimbursment);
    this.router.navigate(['reimbursment-info']);
  }

}
