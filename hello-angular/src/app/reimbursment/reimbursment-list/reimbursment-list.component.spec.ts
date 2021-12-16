import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReimbursmentListComponent } from './reimbursment-list.component';

describe('ReimbursmentListComponent', () => {
  let component: ReimbursmentListComponent;
  let fixture: ComponentFixture<ReimbursmentListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReimbursmentListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ReimbursmentListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
