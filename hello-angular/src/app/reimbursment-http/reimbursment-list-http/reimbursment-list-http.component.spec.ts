import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReimbursmentListHttpComponent } from './reimbursment-list-http.component';

describe('ReimbursmentListHttpComponent', () => {
  let component: ReimbursmentListHttpComponent;
  let fixture: ComponentFixture<ReimbursmentListHttpComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReimbursmentListHttpComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ReimbursmentListHttpComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
