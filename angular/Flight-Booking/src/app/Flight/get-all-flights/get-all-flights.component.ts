import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FlightService } from 'src/app/service/flight.service';

@Component({
  selector: 'app-get-all-flights',
  templateUrl: './get-all-flights.component.html',
  styleUrls: ['./get-all-flights.component.scss']
})
export class GetAllFlightsComponent implements OnInit {

  flights:any[]=[];
  errorMessage:string="";

  constructor(private service:FlightService , private router: Router) { }

  ngOnInit(): void {

    }


    getAllFlights(){
      this.service.getAllFlights()
      .subscribe((data:any) =>{
        
          this.flights=data;
          console.log(data);
      }
        )
      }
    }

  

  




