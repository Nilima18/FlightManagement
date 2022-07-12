import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { FlightService } from 'src/app/service/flight.service';

@Component({
  selector: 'app-new-flight',
  templateUrl: './new-flight.component.html',
  styleUrls: ['./new-flight.component.scss']
})
export class NewFlightComponent implements OnInit {
  flight: any;

  constructor(private formBuilder:FormBuilder,private router: Router,private service:FlightService) { }
  ngOnInit(): void {
    
  }

   
  addForm =this.formBuilder.group({
    flightNumber:"",
    airlineName:"",
    arrivalCity:"",
    departureCity:"",
    arrivalTime:"",
    departureTime:"",
    price:"",
    seats:"",
    instrument:"",
    meal:"",
    days:""
  })
  
  onSubmit(): void {
    this.service.addNewFlightDetails(this.addForm.value)
    .subscribe(data =>{
      
      console.log(data);
      this.router.navigate(['flight']);
    })
  }
  

}
