import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BookingRecord } from 'src/app/model/BookingRecord';
import { BookingService } from 'src/app/service/booking.service';

@Component({
  selector: 'app-get-booking-by-pnr',
  templateUrl: './get-booking-by-pnr.component.html',
  styleUrls: ['./get-booking-by-pnr.component.scss']
})
export class GetBookingByPnrComponent implements OnInit {

  constructor(private service:BookingService , private router: Router) { }

  b: any
  bookingRecords:any=[]
  pnr:any="";
  ngOnInit(): void {
     
    
  }

  getBookingByPnr(pnr:any){
    this.service.getBookingRecordByPnr(pnr)
    .subscribe((data:any)=>{
      this.b=data;
      
      console.log(this.b);
    })
  }
 
  
  

}
