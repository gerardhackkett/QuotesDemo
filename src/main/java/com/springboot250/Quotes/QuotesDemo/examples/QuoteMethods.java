package com.allstate.ghackquotes.quotes.examples;
//This file uses seperate methods to get all user details
//It stores the data in an array and then displays it using a Lamda expression  eg parameter -> expression
//A lambda expression is a short block of code which takes in parameters and returns a value
import java.util.ArrayList;
import java.util.Scanner;

public class QuoteMethods {

    static Scanner myScanner = new Scanner(System.in);
    static ArrayList<String> quoteDetailsArray = new ArrayList<>();

    private static double seatsfactor;
    private static double capacityfactor;
    private static double marketValueFactor;

    static String vehicleReg = "";
    static int noOfSeats=0;
    static int engineCapacity=0;
    static int otherVehicles = 0;
    static int quote=0;
    static String bodyStyle="";
    static String registeredDate = "";
    static String owner ="";
    static double marketValue =0;
    static boolean involvedInAccident = false;
    static boolean changedFromManufacturersSpec = false;
    static boolean registeredKeeper = false;


    public static void main(String[] args) {
        vehicleReg();
        seatCount();
        bodyType();
        engineCapacity();
        marketValue();
        involvedInAccidents();
        manufacturersSpec();
        registeredDate();
        howManyHouseholdVehicles();
        registeredOwner();
        calculateQuote(seatsfactor, capacityfactor, marketValueFactor);
        storeItemsInArray(vehicleReg,noOfSeats,bodyStyle,engineCapacity, marketValue,involvedInAccident, changedFromManufacturersSpec,registeredDate,otherVehicles ,registeredKeeper );
        displayLambda();

        //allow several sets of user details to be entered and stored



    }

    public static String vehicleReg(){
        //Vehicle Reg
        System.out.println("Enter the registration of the vehicle egLA51Abc");
        String vehicleReg = myScanner.nextLine();
        return vehicleReg;
    }

    public static int seatCount(){
        //Number of seats //VALIDATE between 2 and 7
        //int noOfSeats;

        do {
            System.out.println("How many seats does the vehicle have (2 to 7)?");
            //noOfSeats = myScanner.nextInt();
            noOfSeats = Integer.parseInt(myScanner.nextLine());
        } while (noOfSeats > 2 && noOfSeats > 7);

        switch(noOfSeats) {
            case 2:
                seatsfactor = 1.3;
                break;
            case 3:
                seatsfactor = 1.4;
                break;
            case 4:
                seatsfactor = 1.2;
                break;
            case 5:
                seatsfactor = 1.6;
                break;
            case 6:
                seatsfactor = 1.7;
                break;
            case 7:
                seatsfactor = 1.8;
                break;
            default:
                seatsfactor = 1.5;
        }


        return noOfSeats;
    }
    
    public static Double seatCountFactor(){
        //Number of seats //VALIDATE between 2 and 7
        int seatCount= seatCount();

            switch(seatCount) {
                case 2:
                    seatsfactor = 1.3;
                    break;
                case 3:
                    seatsfactor = 1.4;
                    break;
                case 4:
                    seatsfactor = 1.2;
                    break;
                case 5:
                    seatsfactor = 1.6;
                    break;
                case 6:
                    seatsfactor = 1.7;
                    break;
                case 7:
                    seatsfactor = 1.8;
                    break;
                default:
                    seatsfactor = 1.5;
            }

      return seatsfactor;
    }

    public static String bodyType(){
        //Body Type  ///VALIDATE coupe,hatchback,estate
        System.out.println("Enter the vehicle body type - eg.Coupe,hatchback,estate");
        String bodyStyle = myScanner.nextLine();

        return bodyStyle;

    }

    public static int engineCapacity(){

        System.out.println("What is the engine capacity?");
        int engineCapacity = myScanner.nextInt();

        if(engineCapacity < 1000){
            System.out.println("What is the engine capacity?  (must be greater than 1000)");
            engineCapacity = myScanner.nextInt();
        }

        switch(engineCapacity) {
            case 1000:
                capacityfactor = 1.0;
                break;
            case 1100:
                capacityfactor = 1.1;
                break;
            case 1500:
                capacityfactor = 1.5;
                break;
            case 1600:
                capacityfactor = 1.6;
                break;
            case 2000:
                capacityfactor = 2.0;
                break;
            case 2500:
                capacityfactor = 2.5;
                break;
            case 3000:
                capacityfactor = 3.0;
                break;
            default:
                capacityfactor = 0;
        }

        return engineCapacity;
    }


    public static Double engineCapacityFactor(){

        System.out.println("What is the engine capacity?");
        int engineCC = engineCapacity();

        switch(engineCC) {
            case 1000:
                capacityfactor = 1.0;
                break;
            case 1100:
                capacityfactor = 1.1;
                break;
            case 1500:
                capacityfactor = 1.5;
                break;
            case 1600:
                capacityfactor = 1.6;
                break;
            case 2000:
                capacityfactor = 2.0;
                break;
            case 2500:
                capacityfactor = 2.5;
                break;
            case 3000:
                capacityfactor = 3.0;
                break;
            default:
                capacityfactor = 0;
        }

        return capacityfactor;
    }


    public static double marketValue(){

        do {
            System.out.println("What is the current vehicle value?");
            marketValue = myScanner.nextDouble();
                myScanner.nextLine();
        } while (marketValue < 0);



        if(marketValue<=1000){
            marketValueFactor=1.0;
        }
        else{
            marketValueFactor=1.2;
        }

        return marketValue;
    }

    public static double marketValueFactor(){

       Double marketVal= marketValue();


        if(marketVal<=1000){
            marketValueFactor=1.0;
        }
        else{
            marketValueFactor=1.2;
        }

        return marketValueFactor;
    }

    public static boolean involvedInAccidents() {
        boolean involvedInAccident;//Invvolved in accidents?
        System.out.println("Has the vehicle been involved in any accidents?  Yes/No");
        String accidentsresponse =  myScanner.nextLine();

        if(accidentsresponse=="Yes" || accidentsresponse=="yes"){
            involvedInAccident = true;
        }
        else{
            involvedInAccident=false;
        }

        return involvedInAccident;
    }

    public static boolean manufacturersSpec() {
        boolean changedFromManufacturersSpec;//manufacturers spec?
        System.out.println("Has the vehicle been changed from the manufacturers specification? (Yes or No)");
        String specificationresponse =  myScanner.nextLine();
        if(specificationresponse=="Yes" || specificationresponse=="yes"){
            changedFromManufacturersSpec = true;
        }
        else{
            changedFromManufacturersSpec=false;
        }

        return changedFromManufacturersSpec;
    }

    public static String registeredDate() {
        String registeredDate;//Registered Date
        System.out.println("What date was the car registered?");
        registeredDate = myScanner.nextLine();

        return registeredDate;
    }

    public static int  howManyHouseholdVehicles() {
        int otherVehicles;//How many household vehicles
        System.out.println("How many other vehicles are in the household");
        otherVehicles = myScanner.nextInt();
        myScanner.nextLine();

        return otherVehicles;
    }

    public static boolean registeredOwner(){
        System.out.println("Are you the registered keeper of the vehicle? (Yes/No)");
        String keeperresponse =  myScanner.nextLine();
        boolean registeredKeeper;
        if(keeperresponse=="Yes" || keeperresponse=="yes"){
            registeredKeeper = true;
        }
        else{
            registeredKeeper=false;
        }

        return registeredKeeper;
    }

//    seatsfactor= seatCountFactor();
//   capacityfactor = engineCapacityFactor();



//    double seatsFactor= seatCountFactor();
//    double ccfactor = engineCapacityFactor();
//    double marketFactor = marketValueFactor();


    public static double calculateQuote(double seatfactor, double ccFactor, double marketFactor){
        double quote = 100 * seatsfactor * capacityfactor * marketValueFactor;

        System.out.println("==============================================");
        System.out.println("seats = "+noOfSeats);
        System.out.println("marktval = "+marketValue);
        System.out.println("seatsFactor = "+seatsfactor);
        System.out.println("capacityFactor = "+capacityfactor);
        System.out.println("marketValueFactor = "+marketValueFactor);
        System.out.println("Your Quotation is: £"+quote);
        System.out.println("==============================================");
        return quote;
    }

    public static void storeItemsInArray(String vehicleReg, int noOfSeats, String bodyStyle, int engineCapacity, double marketValue, boolean involvedInAccident, boolean changedFromManufacturersSpec, String registeredDate, int otherVehicles, boolean registeredKeeper){
        //store all these details in an array
        quoteDetailsArray.add("LA12ABC");
        quoteDetailsArray.add(Integer.toString(noOfSeats));
        quoteDetailsArray.add("Coupe");
        quoteDetailsArray.add(Integer.toString(engineCapacity));
        quoteDetailsArray.add(Double.toString(marketValue));
        quoteDetailsArray.add(Boolean.toString(involvedInAccident) );
        quoteDetailsArray.add(Boolean.toString(changedFromManufacturersSpec));
        quoteDetailsArray.add("1/1/21");
        quoteDetailsArray.add(Integer.toString(otherVehicles));
        quoteDetailsArray.add(Boolean.toString(registeredKeeper));
    }


    public static void displayLambda(){
        // Iterate the arraylist and display the values using a LAMBDA function
        quoteDetailsArray.forEach(quoteItem -> System.out.println("From Array :"+quoteItem));
    }


}
