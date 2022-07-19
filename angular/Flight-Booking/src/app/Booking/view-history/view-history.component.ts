import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BookingService } from 'src/app/service/booking.service';

@Component({
  selector: 'app-view-history',
  templateUrl: './view-history.component.html',
  styleUrls: ['./view-history.component.scss']
})
export class ViewHistoryComponent implements OnInit {
  email:any=""
  bookingRecords:any=[]
  b:any
  constructor(private service:BookingService , private router:Router) { }

  ngOnInit(): void {
  }

  viewHistory(email:any){
    this.email=email
    this.service.viewHistory(email)
    .subscribe(data =>
      {
this.bookingRecords=data
console.log(data)
      })

  }
}
