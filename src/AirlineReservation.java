import java.util.Scanner;

public class AirlineReservation {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Flight[][] flights=new Flight[3][3];

        flights[0][0]=new Flight("AA101","New York", 100);
        flights[0][1]=new Flight("AA102","Los Angelos", 120);
        flights[0][2]=new Flight("AA103","Chigago", 80);

        flights[1][0]=new Flight("BA201","London", 150);
        flights[1][1]=new Flight("BA202","Paris", 130);
        flights[1][2]=new Flight("BA203","Rome", 110);

        flights[2][0]=new Flight("LH301","Berlin", 90);
        flights[2][1]=new Flight("LH302","Munich", 100);
        flights[2][2]=new Flight("LH303","Franfurkt", 120);

        while(true){
            System.out.println("Avalable Flights: ");
            System.out.println("1. American Airlines(AA) ");
            System.out.println("2. British Airways(BA) ");
            System.out.println("3. Lufthansa (LH) ");
            System.out.println("0. Exit ");

            System.out.println("Select an airline (1-3) or 0 to exit");
            int airlineChoice=scan.nextInt();
              if(airlineChoice==0){
                  System.out.println("Goodbye!");
                  break;
              }else if(airlineChoice>=1 && airlineChoice<=3){
                  System.out.println("Available Flights for the selected airline: ");
                  for(int i=0;i<3;i++){
                      //int i=0
                      //1.flights[0][1]
                      System.out.println((i+1)+ ". " + flights[airlineChoice-1][i].getFlighNumber() + " to "+
                              flights[airlineChoice -1][i].getDestination()+" Available Economy Seats: "+
                              flights[airlineChoice-1][i].getAvaliableSeatEconomy()+ " Available Business Seats "+
                              flights[airlineChoice-1][i].getAvaliableSeatsBusiness());
                  }
                  System.out.println("Select a flight (1-3): ");
                  int flightChoice=scan.nextInt();
                  if(flightChoice>=1 && flightChoice<=3){
                      //obj 1 flight[0][0]
                      Flight selectedFlight=flights[airlineChoice-1][flightChoice-1];

                      System.out.println("Enter the number of passagers: ");
                      int numPassengers=scan.nextInt();

                      System.out.println("Select seat (1.Economy, 2. Business): ");
                      int seatClassChoice=scan.nextInt();

                      boolean isBusinessClass=seatClassChoice==2;
//                      if(seatClassChoice==2){
//                          boolean isBusinessClass=true;
//
//                      }
                 if(selectedFlight.bookSeat((numPassengers), isBusinessClass)){

                     System.out.print("Booking confirmed! enjoy your flight to "+ selectedFlight.getDestination()+".");
                     int renainingEconomySeats= selectedFlight.getAvaliableSeatEconomy();
                     int renainingBusinessSeats= selectedFlight.getAvaliableSeatsBusiness();
                     System.out.println("Remaining Economy Class Seats "+ renainingEconomySeats);
                     System.out.println("Remaining Business Class Seats "+ renainingBusinessSeats);
                 }else{
                     System.out.println("Sorry there are not enough" +
                             " seats in the selected class or the flight is fully booked");
                 }
                  }else{
                      System.out.println("Invalid flight choice.");
                  }

              }else{
                  System.out.println("Invalid airline choice. please select 1,2,3 or 0 to exit.");
              }

        }
    }


}
