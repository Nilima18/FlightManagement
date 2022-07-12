import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AirlineService } from 'src/app/service/airline.service';

@Component({
  selector: 'app-register-airline',
  templateUrl: './register-airline.component.html',
  styleUrls: ['./register-airline.component.scss']
})
export class RegisterAirlineComponent implements OnInit {

  constructor(private formBuilder: FormBuilder, private service:AirlineService , private router: Router) { }
  addForm!: FormGroup;
  errorMessage:string="";
  airlines:any[]=[];
  ngOnInit() {
    this.addForm = this.formBuilder.group({
      airlineName: ['', Validators.required],
      contact: ['', Validators.required],
      status: ['', Validators.required]
    })
  }
    
      
 onSubmit():void {
  this.service.registerAirline(this.addForm.value)
    .subscribe(data => {
      console.log(data);
      this.router.navigate(['airline-list']);
    });
}

    
  }

