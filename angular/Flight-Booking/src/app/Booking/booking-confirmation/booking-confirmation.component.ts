import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-booking-confirmation',
  templateUrl: './booking-confirmation.component.html',
  styleUrls: ['./booking-confirmation.component.scss']
})
export class BookingConfirmationComponent implements OnInit {
 
  pnr:number=0
  constructor(private route: ActivatedRoute , private router:Router) { }
 
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
