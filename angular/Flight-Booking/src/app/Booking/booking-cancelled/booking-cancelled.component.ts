import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-booking-cancelled',
  templateUrl: './booking-cancelled.component.html',
  styleUrls: ['./booking-cancelled.component.scss']
})
export class BookingCancelledComponent implements OnInit {

  constructor(private route: ActivatedRoute , private router:Router) { }
 pnr:number=0
  ngOnInit(): void {


    this.route.queryParams.subscribe((params:any) =>
    {
      console.log(params);
      this.pnr=params.number
    })
  }
  backToBooking(){
    this.router.navigate(['searchFlight']);

  }
  }




