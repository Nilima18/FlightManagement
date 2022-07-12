import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class FlightService {
  flight:any;

  constructor(private Http:HttpClient) { }

  FlightSearchApi = 'http://localhost:8083/flight';

  searchFlights(destination:string,source:string){
    return this.Http.get(this.FlightSearchApi+"/" + destination +"/" +source);
  }

  getAllFlights(){
    return this.Http.get("http://localhost:8083/flight/allFlights");
  }

  addNewFlightDetails(flight:any){
    return this.Http.post("http://localhost:8083/flight/addNewFlight" ,flight);
  }

}
