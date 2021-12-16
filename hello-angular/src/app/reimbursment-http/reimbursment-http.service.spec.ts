import { TestBed } from '@angular/core/testing';

import { ReimbursmentHttpService } from './reimbursment-http.service';

describe('ReimbursmentHttpService', () => {
  let service: ReimbursmentHttpService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ReimbursmentHttpService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
