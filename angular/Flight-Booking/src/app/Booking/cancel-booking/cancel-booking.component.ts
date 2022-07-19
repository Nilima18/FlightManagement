import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BookingService } from 'src/app/service/booking.service';

@Component({
  selector: 'app-cancel-booking',
  templateUrl: './cancel-booking.component.html',
  styleUrls: ['./cancel-booking.component.scss']
})
export class CancelBookingComponent implements OnInit {

  constructor(private service:BookingService , private router: Router) { }
  pnr:any=""
  ngOnInit(): void {
  }
 
  cancelBookingByPnr(pnr:any){
    this.pnr=pnr;
    this.service.cancelBookingByPnr(pnr).subscribe(data =>{
      console.log(data)
      alert("booking cancelled")
      this.router.navigate(['booking-cancelled'],{queryParams:{number:this.pnr}})
     
    }  )

  }

  
  
}
