import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeEditHttpComponent } from './employee-edit-http.component';

describe('EmployeeEditHttpComponent', () => {
  let component: EmployeeEditHttpComponent;
  let fixture: ComponentFixture<EmployeeEditHttpComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EmployeeEditHttpComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeeEditHttpComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
