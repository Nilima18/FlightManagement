import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AirlineListComponent } from './airline/airline-list/airline-list.component';
import { RegisterAirlineComponent } from './airline/register-airline/register-airline.component';
import { UpdateAirlineComponent } from './airline/update-airline/update-airline.component';
import { AppComponent } from './app.component';
import { BookingCancelledComponent } from './booking/booking-cancelled/booking-cancelled.component';
import { BookingConfirmationComponent } from './booking/booking-confirmation/booking-confirmation.component';


import { CancelBookingComponent } from './Booking/cancel-booking/cancel-booking.component';
import { CreateBookingComponent } from './Booking/create-booking/create-booking.component';
import { GetBookingByPnrComponent } from './Booking/get-booking-by-pnr/get-booking-by-pnr.component';
import { ViewHistoryComponent } from './booking/view-history/view-history.component';

import { GetAllFlightsComponent } from './Flight/get-all-flights/get-all-flights.component';
import { NewFlightComponent } from './Flight/new-flight/new-flight.component';
import { SearchFlightComponent } from './Flight/search-flight/search-flight.component';
import { UpdateFlightComponent } from './Flight/update-flight/update-flight.component';
import { HomeComponent } from './home/home.component';


const routes: Routes = [
  {path:"flight",component:GetAllFlightsComponent},
  {path:"createFlight",component:NewFlightComponent},
  {path:"home",component:HomeComponent},
  {path:"searchFlight",component:SearchFlightComponent},
   {path:"airline-list",component:AirlineListComponent},
   {path:"register-airline",component:RegisterAirlineComponent},
   {path:"update-airline",component:UpdateAirlineComponent},
   {path:"booking-record",component:GetBookingByPnrComponent},
   {path:"app-create-booking",component:CreateBookingComponent},
   {path:"cancel-booking",component:CancelBookingComponent},
   {path:"booking-confirmation",component:BookingConfirmationComponent},
   
   {path:"manage-flight",component:UpdateFlightComponent},
   {path:"booking-cancelled",component:BookingCancelledComponent},
   {path:"main",component:AppComponent},
   {path:"view-history",component:ViewHistoryComponent}
   
   


   
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
