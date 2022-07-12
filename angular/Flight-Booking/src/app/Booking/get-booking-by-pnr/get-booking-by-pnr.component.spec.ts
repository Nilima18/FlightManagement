import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetBookingByPnrComponent } from './get-booking-by-pnr.component';

describe('GetBookingByPnrComponent', () => {
  let component: GetBookingByPnrComponent;
  let fixture: ComponentFixture<GetBookingByPnrComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GetBookingByPnrComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GetBookingByPnrComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
