import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class BookingService {

  constructor(private Http:HttpClient) { }

  getBookingRecordByPnr(id:any){
    this.Http.get("http://localhost:8081/booking/"+id);
    
  }


}
