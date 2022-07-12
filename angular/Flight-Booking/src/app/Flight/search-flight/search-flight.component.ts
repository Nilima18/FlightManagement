import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FlightService } from 'src/app/service/flight.service';

@Component({
  selector: 'app-search-flight',
  templateUrl: './search-flight.component.html',
  styleUrls: ['./search-flight.component.scss']
})
export class SearchFlightComponent implements OnInit {

  constructor(private router: Router,private service:FlightService) { }

  ngOnInit(): void {
  }
  flights:any[]=[];
  destination:string="";
  source:string="";

  getFlights(destination:any,source:any){
    this.service.searchFlights(destination,source)
    .subscribe((data:any)=>{
      this.flights=data;
      console.log(data);
    })


  }

}
