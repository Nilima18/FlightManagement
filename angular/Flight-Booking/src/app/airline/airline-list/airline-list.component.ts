import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AirlineService } from 'src/app/service/airline.service';

@Component({
  selector: 'app-airline-list',
  templateUrl: './airline-list.component.html',
  styleUrls: ['./airline-list.component.scss']
})
export class AirlineListComponent implements OnInit {
  airlines: any=[];
  
 airline_id:number=0;
  airline :any
 
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
  

  blockAirline(id:number){
    this.airline_id=id;
    this.service.blockAirlineById(id)
    .subscribe((res:any) =>
    {
      console.log(res)
      alert("Airline is Blocked")
      //this.router.navigate(['airline-list']);
      this.getAllAirlines()
    })

  }

  unblockAirline(id:number){
    this.airline_id=id;
    this.service.unblockAirlineById(id)
    .subscribe((res:any)=>
    {
      console.log(res)
      alert("Airline is unblocked")
      this.getAllAirlines();
    }
    )
  }
  
}
