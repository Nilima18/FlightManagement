export class BookingRecord{
   pnr:number=0;
	  name :string="";
	  email:string="";
	  flightNumber:string="";
      airlineName:string="";
	  source:string="";
	 destination:string="";
	 flightDate:string="";
	 bookingDate:any;
     meal:string="";
	 noOfSeat:number=0;
	  total_amount:number=0;
	  status:string="";
 passengers:Array<{ id: Number; name: String; age: Number; seat: Number; genger: string; }> =[]
    
}