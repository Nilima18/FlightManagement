import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-update-flight',
  templateUrl: './update-flight.component.html',
  styleUrls: ['./update-flight.component.scss']
})
export class UpdateFlightComponent implements OnInit {

  flight:any
  constructor() { }

  ngOnInit(): void {
  }

  updateFlight(flight:any){

  }
}
