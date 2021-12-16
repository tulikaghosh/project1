import { Injectable } from '@angular/core';
import { Manager } from './manager.model';

@Injectable({
  providedIn: 'root'
})
export class ManagerService {

  allManager: Manager[] = [
    {
      mgrId: 1,
        mgrName: "raju",
        mgrAddress: "skyChaseAve",
    }

  ];
  constructor() { }

  
  getAllManagerService(): Manager[]{
    return this.allManager;
  }
}
