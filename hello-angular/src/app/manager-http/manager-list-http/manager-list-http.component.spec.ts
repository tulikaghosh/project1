import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ManagerListHttpComponent } from './manager-list-http.component';

describe('ManagerListHttpComponent', () => {
  let component: ManagerListHttpComponent;
  let fixture: ComponentFixture<ManagerListHttpComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ManagerListHttpComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ManagerListHttpComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
