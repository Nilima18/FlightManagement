import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { BookingService } from 'src/app/service/booking.service';
import { FormArray, FormBuilder, FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-create-booking',
  templateUrl: './create-booking.component.html',
  styleUrls: ['./create-booking.component.scss']
})
export class CreateBookingComponent implements OnInit {

  constructor(private route: ActivatedRoute,private service:BookingService , private router: Router,private formBuilder: FormBuilder) { }
  bookingForm!:FormGroup;
  passengers!:FormArray;
 flightId:number=0;
 pnr:any

  ngOnInit(): void {

    this.bookingForm=this.formBuilder.group({
      name:[''],
      email:[''],
      noOfSeat:[''],
      meal:[''],
     passengers: new FormArray([this.formBuilder.array([this.createPassenger])])
     //passengers : this.formBuilder.array([this.createPassenger])
    });
     
    this.route.queryParams.subscribe((params:any) =>
    {
      console.log(params);
      this.flightId=params.number
    })

  }
  createPassenger(): FormGroup {  
    return this.formBuilder.group({  
      name: [''],  
      age: [''],  
      gender: [''],
      seatNo:[''] 
    });  
  }   
  addPassenger(): void {  
    this.passengers = this.bookingForm.get('passengers') as FormArray;  
    this.passengers.push(this.createPassenger());  
  }  

  onSubmit(): void {
    this.service.createNewBooking(this.bookingForm.value ,this.flightId)
    .subscribe(data =>{
     this.pnr=data
      console.log(data);
     // alert(data="Ticket booking is successfully")
      this.router.navigate(['booking-confirmation'],{queryParams:{number:this.pnr}});
    })
  }


}
