import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class AirlineService {

  
  constructor(private http:HttpClient) { }

  findAllAirlines() {
    return this.http.get("http://65.1.65.7:8083/airline");
  }

  registerAirline(airline : any){
    return this.http.post("http://65.1.65.7:8083/airline/register" ,airline)

  }

  updateAirline(airline:any){
    return this.http.put("http://65.1.65.7:8083/airline",airline);
  }

  blockAirlineById(id :number){
    return this.http.get("http://65.1.65.7:8083/airline/block"+"/"+id);
  }

  unblockAirlineById(id :number){
    return this.http.get("http://65.1.65.7:8083/airline/unblock"+"/"+id);
  }
 
}
