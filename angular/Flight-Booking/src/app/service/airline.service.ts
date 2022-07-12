import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Airline } from '../model/airline.model';

@Injectable({
  providedIn: 'root'
})
export class AirlineService {

  
  constructor(private http:HttpClient) { }

  findAllAirlines() {
    return this.http.get("http://localhost:8083/airline");
  }

  registerAirline(airline : any){
    return this.http.post("http://localhost:8083/airline/register" ,airline)

  }

  updateAirline(airline:any){
    return this.http.put("http://localhost:8083/airline",airline);
  }

 
}
