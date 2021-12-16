import { Component, OnInit } from '@angular/core';
import { Manager } from 'src/app/manager/manager.model';
import { ManagerHttpService } from '../manager-http.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-manager-list-http',
  templateUrl: './manager-list-http.component.html',
  styleUrls: ['./manager-list-http.component.css']
})
export class ManagerListHttpComponent implements OnInit {

  allManager: Manager[] = [];

  constructor(private managerHttpService: ManagerHttpService,
              private router: Router) { }

  ngOnInit(): void {
    this.loadManager(); 
    console.log("after calling getAllManagerService()");
  }
  loadManager(){
    this.managerHttpService.getAllManagerService().subscribe(
      (response)=> {
        console.log(response);
        this.allManager = response;
      },
      (error)=>{
        console.log(error);
      }
    );
  }

}
