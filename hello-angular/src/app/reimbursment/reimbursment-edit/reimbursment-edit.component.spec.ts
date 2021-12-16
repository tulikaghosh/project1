import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReimbursmentEditComponent } from './reimbursment-edit.component';

describe('ReimbursmentEditComponent', () => {
  let component: ReimbursmentEditComponent;
  let fixture: ComponentFixture<ReimbursmentEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReimbursmentEditComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ReimbursmentEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
