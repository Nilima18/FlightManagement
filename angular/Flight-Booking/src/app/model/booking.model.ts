export class Booking{
    constructor(
    public pnr:number,
    public name:string,
    public departure_date:Date,
    public booking_date:Date,
   
    public passenger:Array<{ passenger_id:Number,passenger_name:String,passenger_age:Number,passenger_seat:Number,amount:Number}>,
    )
     {}
 }