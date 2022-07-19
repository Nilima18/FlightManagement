import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Booking } from '../model/booking.model';

@Injectable({
  providedIn: 'root'
})
export class BookingService {

  constructor(private http:HttpClient) { }

 getBookingRecordByPnr(pnr:any){
   return this.http.get("http://ec2-65-1-65-7.ap-south-1.compute.amazonaws.com:8080/booking/"+pnr);

 }

 createNewBooking(booking:Booking,id:number){
   return this.http.post("http://ec2-65-1-65-7.ap-south-1.compute.amazonaws.com:8080/booking/"+id,booking)}
   
 cancelBookingByPnr(pnr:any){
   return this.http.get("http://ec2-65-1-65-7.ap-south-1.compute.amazonaws.com:8080/booking/cancel/"+pnr)
 }

 viewHistory(email:any){
   return this.http.get("http://ec2-65-1-65-7.ap-south-1.compute.amazonaws.com:8080/booking/viewHistory?email="+email)
 }

}
