import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AirlineService } from 'src/app/service/airline.service';

@Component({
  selector: 'app-update-airline',
  templateUrl: './update-airline.component.html',
  styleUrls: ['./update-airline.component.scss']
})
export class UpdateAirlineComponent implements OnInit {

  constructor(private service:AirlineService , private router:Router) { }
  airline: any;
  ngOnInit(): void {
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
