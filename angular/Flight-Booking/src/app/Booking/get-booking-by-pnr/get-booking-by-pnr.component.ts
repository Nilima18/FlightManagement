import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BookingService } from 'src/app/service/booking.service';

@Component({
  selector: 'app-get-booking-by-pnr',
  templateUrl: './get-booking-by-pnr.component.html',
  styleUrls: ['./get-booking-by-pnr.component.scss']
})
export class GetBookingByPnrComponent implements OnInit {

  constructor(private service:BookingService , private router: Router) { }

  ngOnInit(): void {
  }

  booking:any[]=[];

  getBookingByPnr(id:any){
    this.service.getBookingRecordByPnr(id)
    
  }

}
