import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReimbursmentEditHttpComponent } from './reimbursment-edit-http.component';

describe('ReimbursmentEditHttpComponent', () => {
  let component: ReimbursmentEditHttpComponent;
  let fixture: ComponentFixture<ReimbursmentEditHttpComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReimbursmentEditHttpComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ReimbursmentEditHttpComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
