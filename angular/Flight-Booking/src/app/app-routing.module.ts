import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AirlineListComponent } from './airline/airline-list/airline-list.component';
import { RegisterAirlineComponent } from './airline/register-airline/register-airline.component';
import { UpdateAirlineComponent } from './airline/update-airline/update-airline.component';

import { GetAllFlightsComponent } from './Flight/get-all-flights/get-all-flights.component';
import { NewFlightComponent } from './Flight/new-flight/new-flight.component';
import { SearchFlightComponent } from './Flight/search-flight/search-flight.component';
import { HomeComponent } from './home/home.component';


const routes: Routes = [
  {path:"flight",component:GetAllFlightsComponent},
  {path:"createFlight",component:NewFlightComponent},
  {path:"home",component:HomeComponent},
  {path:"searchFlight",component:SearchFlightComponent},
   {path:"airline-list",component:AirlineListComponent},
   {path:"register-airline",component:RegisterAirlineComponent},
   {path:"update-airline",component:UpdateAirlineComponent}
  
  

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
