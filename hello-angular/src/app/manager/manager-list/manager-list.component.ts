import { Component, OnInit } from '@angular/core';
import { Manager } from '../manager.model';
import { ManagerService } from '../manager.service';

@Component({
  selector: 'app-manager-list',
  templateUrl: './manager-list.component.html',
  styleUrls: ['./manager-list.component.css']
})
export class ManagerListComponent implements OnInit {

  allManager: Manager[] = [];

  constructor(private managerService: ManagerService) { }

  ngOnInit(): void {
    this.allManager = this.managerService.getAllManagerService();
  }

}
