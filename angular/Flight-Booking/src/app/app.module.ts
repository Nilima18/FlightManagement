import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule, HttpHeaders } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { AirlineService } from './service/airline.service';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HomeComponent } from './home/home.component';
import { NewFlightComponent } from './Flight/new-flight/new-flight.component';
import { SearchFlightComponent } from './Flight/search-flight/search-flight.component';
import { GetAllFlightsComponent } from './Flight/get-all-flights/get-all-flights.component';
import { UpdateFlightComponent } from './Flight/update-flight/update-flight.component';
import { CreateBookingComponent } from './Booking/create-booking/create-booking.component';
import { CancelBookingComponent } from './Booking/cancel-booking/cancel-booking.component';
import { GetBookingByPnrComponent } from './Booking/get-booking-by-pnr/get-booking-by-pnr.component';
import { RegisterAirlineComponent } from './airline/register-airline/register-airline.component';
import { UpdateAirlineComponent } from './airline/update-airline/update-airline.component';
import { AirlineComponent } from './airline/airline/airline.component';
import { AirlineListComponent } from './airline/airline-list/airline-list.component';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NewFlightComponent,
    SearchFlightComponent,
    GetAllFlightsComponent,
    UpdateFlightComponent,
    CreateBookingComponent,
    CancelBookingComponent,
    GetBookingByPnrComponent,
    RegisterAirlineComponent,
    UpdateAirlineComponent,
    AirlineComponent,
    AirlineListComponent,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,

    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
