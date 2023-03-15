package prog2.exercise5.flight.booking.system;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class FlightBooking {
    private final String flightCompany = "Flights-of-Fancy";
    private String flightID;
    private int size;
    private String passengerFullName[]=new String[size];
    private String passengerGender[]=new String[size];
    private int passengerAge[]=new int[size];
    private  String tripSource = "NANJING";
    private  String sourceAirport = "NANJING LUKOU INTERNATIONAL AIRPORT";
    private  String tripDestination = "OULU";
    private  String destinationAirport = "OULU AIRPORT";
    private LocalDate departureDate;
    private LocalDate returnDate;
    private int childPassengers;
    private int adultPassengers;
    private int totalPassengers;
    private double departingTicketPrice;
    private double returnTicketPrice;

    private double totalTicketPrice=0;
    private String ticketNumber[]=new String[size];
    private  boolean dateerror;
    boolean natively;


    public FlightBooking(int sizee) {
        this.size=sizee;
        ticketNumber=new String[sizee];
        passengerFullName=new String[sizee];
        passengerGender=new String[sizee];
        passengerAge=new int[sizee];


    }

    public String displayTripDetails(int index) {

        if (dateerror=false) {
            return "Dear" + passengerFullName + ". Thank you for booking your flight with " + flightCompany +
                    ". Following are the details of your booking and the trip:\n\n" +
                    "Ticket Number: " + getTicketNumber(index) +
                    "\nFrom " + getTripSource() + "to " + getTripDestination() +
                    "\nDate of departure: " + departureDate.toString() +
                    "\nDate of return: " + returnDate.toString() +
                    "\nTotal passengers: " + totalPassengers +
                    "\nTotal ticket price in Euros: " + getTotalTicketPrice();
        }
        else {
            return "Dear" + passengerFullName + ". Thank you for booking your flight with " + flightCompany +
                    ". Following are the details of your booking and the trip:\n" +
                    "Ticket Number: " + getTicketNumber(index) +
                    "\nFrom " + getTripSource() + "to " + getTripDestination() +
                    "\nDate of departure: " + departureDate.toString() +
                    "\nDate of return: " + returnDate.toString() +
                    "\nTotal passengers: " + totalPassengers +
                    "\nTotal ticket price in Euros: " + getTotalTicketPrice()+"\n\nIMPORTANT NOTICE: As per our policy, the return date was changed because it was less than two days apart from your departure date.";
        }
    }

    enum TripType{
        ONE_WAY,RETURN
    }
    enum BookingClass{
        FIRST,BUSINESS,ECONOMY
    }
    enum TripSource{
        NANJING, BEIJING, SHANGHAI, OULU, HELSINKI, PARIS
    }
    enum 	TripDestination{
        NANJING, BEIJING, SHANGHAI, OULU, HELSINKI, PARIS
    }
    enum 	SourceAirport{
        NanjingLukouInternationalAirport, BeijingCapitalInternationalAirport,ShanghaiPudongInternationalAirport,OuluAirport, HelsinkiAirport,ParisCharlesdeGaulleAirport
    }
    enum DestinationAirport{
        NanjingLukouInternationalAirport, BeijingCapitalInternationalAirport,ShanghaiPudongInternationalAirport,OuluAirport, HelsinkiAirport,ParisCharlesdeGaulleAirport

    }
    public void setPassengerFullName(int index,String passengerFullName) {
        this.passengerFullName[index]=passengerFullName;
    }
    public String getPassengerFullName(int index) {
        return this.passengerFullName[index];
    }



    public void setPassengerGender(int index,String gender) {
passengerGender[index]=gender;

    }
    public String getPassengerGender(int index) {
        return passengerGender[index];
    }

    public void setPassengerAge(int index,int age) {
passengerAge[index]=age;
    }
    public int getPassengerAge(int index) {
        return passengerAge[index];
    }
public void reserveTickets(int total){
    LocalDate ff;LocalDate dd;int age;

        double childrennum=0;double adultnum=0;
        Scanner sc=new Scanner(System.in);
    for(int i=0; i<total; ++i){
        System.out.println("enter the fullname of the passenger"+(i+1));
setPassengerFullName(i,sc.nextLine());
        System.out.println("enter the gender of the passenger"+(i+1));
        setPassengerGender(i,sc.nextLine());
        System.out.println("enter the age of the passenger"+(i+1));
        age=sc.nextInt();
        setPassengerAge(age,i);
        System.out.println("enter the tripsource of the passenger"+(i+1));
setTripSource(sc.nextLine());
        System.out.println("enter the tripDestination of the passenger"+(i+1));
setTripDestination(sc.nextLine(),sc.nextLine());
        System.out.println("enter the TripType of the passenger"+(i+1));
setTripType(sc.nextLine());
        System.out.println("enter the BookingClass of the passenger"+(i+1));

setBookingClass(sc.nextLine());
        System.out.println("enter the DepartureDate(in format of xxxx-xx-xx) of the passenger"+(i+1));
ff=LocalDate.parse(sc.nextLine());
setDepartureDate(ff);
        System.out.println("enter the ReturnDate(in format of xxxx-xx-xx)  of the passenger"+(i+1));
        dd=LocalDate.parse(sc.nextLine());
setReturnDate(dd);
if(age>=18){
    adultnum++;
}else{
    childrennum++;
}
        setTicketNumber(i);

    }
setDepartingTicketPrice(childrennum,adultnum);
    setReturnTicketPrice();
    setTotalTicketPrice();
}

    public String getsourceAirport() {
        return sourceAirport;
    }
FlightBooking.SourceAirport sa;
    public void setSourceAirport(String a) {
        switch (a){
            case"1":sa=SourceAirport.NanjingLukouInternationalAirport;break;
            case"2":sa=SourceAirport.BeijingCapitalInternationalAirport;break;
            case"3":sa=SourceAirport.OuluAirport;break;
            case"4":sa=SourceAirport.HelsinkiAirport;break;
        }
    }

    public String getdestinationAirport() {
        return destinationAirport;
    }

    public void setDestinationAirport(String a,String b) {
        switch (b){
            case"1":sa=SourceAirport.NanjingLukouInternationalAirport;break;
            case"2":sa=SourceAirport.BeijingCapitalInternationalAirport;break;
            case"3":sa=SourceAirport.OuluAirport;break;
            case"4":sa=SourceAirport.HelsinkiAirport;break;
        }
    }

















    FlightBooking.TripSource bk;
    FlightBooking.SourceAirport be;
    public void setTripSource(String choicee){

        switch (choicee){
            case "1":bk= TripSource.NANJING;break;
            case"2":bk=TripSource.BEIJING;break;

            case"3":bk=TripSource.OULU;break;
            case"4":bk=TripSource.HELSINKI;break;



        }
        switch(choicee){
            case"1":be=SourceAirport.NanjingLukouInternationalAirport;break;
            case"2":be=SourceAirport.BeijingCapitalInternationalAirport;break;
            case"3":be=SourceAirport.OuluAirport;break;
            case"4":be=SourceAirport.HelsinkiAirport;break;

        }
    }
    public TripSource getTripSource(){return  bk;}
    public void setTripDestination(String s,String b) {
        if(s!=b) {
            int source = Integer.parseInt(s);
            int destination = Integer.parseInt(b);
            if ((source <= 2 && destination <= 2) | (source >= 3 && destination >= 3)) {
                natively = true;
            } else {
                natively = false;
            }
            FlightBooking.TripDestination fff;
            FlightBooking.DestinationAirport fft;
            switch (b) {
                case "1":
                    fff = TripDestination.NANJING;
                    fft = DestinationAirport.NanjingLukouInternationalAirport;
                    break;
                case "2":
                    fff = TripDestination.BEIJING;
                    fft = DestinationAirport.BeijingCapitalInternationalAirport;
                    break;
                case "3":
                    fff = TripDestination.OULU;
                    fft = DestinationAirport.OuluAirport;
                    break;
                case "4":
                    fff = TripDestination.HELSINKI;
                    fft = DestinationAirport.HelsinkiAirport;
                    break;
            }
        }
        else{
            System.out.println("what a fucking assignment!why do not you check it in flesh!the machine check is a lump of garbage");
        }
    }
    public String getTripDestination() {return this.tripDestination;}
    TripType ty;
    public void setTripType(String s){
        switch (s){
            case"1":ty=TripType.ONE_WAY;
                break;
            case"2":ty=TripType.RETURN;
                break;
        }
    }

    FlightBooking.BookingClass bs;
    public void setBookingClass(String b){
        switch (b){
            case"1":bs=BookingClass.FIRST;
                break;
            case"2":bs=BookingClass.BUSINESS;
                break;
            case"3":bs=BookingClass.ECONOMY;
                break;
        }
    }
    public BookingClass getBookingClass(){
        return bs;
    }
    public void setTicketNumber(int index){
        String a,b,c;
        if (natively==true){
            c="DOM";
        }else {
            c="INT";
        }
        if(ty==TripType.ONE_WAY){
            a="11";
        }else {
            a="22";
        }
        if(bs==BookingClass.FIRST){
            b="F";
        } else if (bs==BookingClass.BUSINESS) {
            b="B";
        }else {
            b="E";
        }
        ticketNumber[index]=a+b+"PQHK"+c;

    }

    public String getTicketNumber(int index) {
        setTicketNumber(index);

        return ticketNumber[index];
    }



    public int getChildrenPassengers() {
        return this.childPassengers;
    }

    public int getAdultPassengers() {
        return adultPassengers;
    }

    public String getFlightID() {
        return this.flightID;
    }


    public String getSourceAirport() {
        return this.sourceAirport;
    }



    public String getDestinationAirport() {
        return this.destinationAirport;
    }

    public void setTotalPassengers(int childPassengers, int adultPassengers) {
        this.totalPassengers = childPassengers + adultPassengers;
        this.totalPassengers = totalPassengers;
    }



    public LocalDate getDepartureDate() {
        return this.departureDate;
    }

    public LocalDate getReturnDate() {return  this.returnDate;}
    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }
    public void setReturnDate(LocalDate returnDate) {
        long dategap=ChronoUnit.DAYS.between(departureDate,returnDate);
        if(dategap<2){
            returnDate=departureDate.plusDays(2);
            dateerror=true;
        }
        else{
            dateerror=false;
        }
        this.returnDate = returnDate;
    }
    public void setDepartingTicketPrice(double child, double adults) {
        double c=child;
        double a=adults;
        double addition;
        double rateoftax;double rateofservice;
        if(natively==true){
            rateofservice=0.05;
            rateoftax=0.1;
        }
        else {
            rateofservice=0.1;
            rateoftax=0.15;
        }
        switch (bs) {
            case FIRST:
                addition = 250;
                break;
            case BUSINESS:
                addition = 150;
                break;
            case ECONOMY:
                addition = 50;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + bs);
        }

        departingTicketPrice=(c+a)*300+(c+a)*300*rateofservice+(c+a)*300*rateoftax+(c+a)*addition;

    }
    public double getDepartingTicketPrice() {

        return this.departingTicketPrice;
    }
    public void setReturnTicketPrice() {
        if(ty==TripType.ONE_WAY){
            returnTicketPrice=0;
        }
        else{
            returnTicketPrice=departingTicketPrice;
        }
    }
    public double getReturnTicketPrice() {

        return this.returnTicketPrice;
    }
    double a[]=new double[3];
    public void setTotalTicketPrice() {
       totalTicketPrice=departingTicketPrice+returnTicketPrice;
    }

    public double getTotalTicketPrice() {
        return totalTicketPrice;
    }









    public void setFlightID(String flightID) {
        this.flightID = flightID;
    }

    public void setAdultPassengers(int adultPassengers) {
        this.adultPassengers = adultPassengers;
    }

    public void setChildPassengers(int childPassengers) {
        this.childPassengers = childPassengers;
    }









    public String getFlightCompany() {
        return this.flightCompany;
    }

    public int getTotalPassengers() {
        this.totalPassengers = this.adultPassengers + this.childPassengers;
        return totalPassengers;
    }


}



