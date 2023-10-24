public class Flight {
    String flighNumber;
    String destination;
    int capacity;
     int bookedSeatEconomy;
     int bookedSeatsBusiness;
     public Flight(String flighNumber, String destination,int capacity){
         this.flighNumber=flighNumber;
         this.destination=destination;
         this.capacity=capacity;
         this.bookedSeatEconomy=0;
         this.bookedSeatsBusiness=0;
     }
     public String getFlighNumber(){
         return flighNumber;
     }
     public String getDestination(){
         return  destination;
     }

     public int getAvaliableSeatEconomy(){
         return  capacity-bookedSeatEconomy;
     }
    public int getAvaliableSeatsBusiness(){
        return capacity - bookedSeatsBusiness;
    }

    public boolean bookSeat(int numPassengers, boolean isBusinesssClass){
         if(isBusinesssClass){
             if(bookedSeatsBusiness + numPassengers <=capacity){
                 bookedSeatsBusiness+=numPassengers;
                 return true;
             }
         }else{
             if(bookedSeatEconomy+numPassengers<=capacity){
                 bookedSeatEconomy+=numPassengers;
                 return true;
             }
         }
         return false;
    }

}
