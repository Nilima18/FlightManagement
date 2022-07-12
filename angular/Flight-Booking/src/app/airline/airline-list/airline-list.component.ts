import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AirlineService } from 'src/app/service/airline.service';

@Component({
  selector: 'app-airline-list',
  templateUrl: './airline-list.component.html',
  styleUrls: ['./airline-list.component.scss']
})
export class AirlineListComponent implements OnInit {
  airlines: any=[];
  airline:any;
  errorMessage: string="";

  constructor(private service:AirlineService,private router:Router) { }

  ngOnInit(): void {
  }

  getAllAirlines(){
    this.service.findAllAirlines()
    .subscribe({
      next : (res:any) =>{
        this.airlines=res;
        console.log(res);
      },
      error :(e) =>{
        this.errorMessage = e.message;
      }
    })
  }

  updateAirlineStatus(airline:any){
    this.service.updateAirline(airline)
    .subscribe((res:any) =>{
      this.airline=res;
      console.log(res);
      this.router.navigate(['airline-list']);
    })
  }
}
