import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeListHttpComponent } from './employee-list-http.component';

describe('EmployeeListHttpComponent', () => {
  let component: EmployeeListHttpComponent;
  let fixture: ComponentFixture<EmployeeListHttpComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EmployeeListHttpComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeeListHttpComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
