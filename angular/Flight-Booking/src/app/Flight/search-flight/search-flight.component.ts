import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { BookingService } from 'src/app/service/booking.service';
import { FlightService } from 'src/app/service/flight.service';

@Component({
  selector: 'app-search-flight',
  templateUrl: './search-flight.component.html',
  styleUrls: ['./search-flight.component.scss']
})
export class SearchFlightComponent implements OnInit {

  constructor(private route: ActivatedRoute,private router: Router,private service:FlightService,private bservice:BookingService) { }

  ngOnInit(): void {
  }
  flights:any[]=[];
  destination:string="";
  source:string="";
  flightId:number=0

  getFlights(destination:any,source:any){
    this.service.searchFlights(destination,source)
    .subscribe((data:any)=>{
      this.flights=data;
      console.log(data);
    })


  }

  bookTicket(id:any){
    this.flightId=id;
  
    
    this.router.navigate(['app-create-booking'],{queryParams:{number:this.flightId}});
  }

}
