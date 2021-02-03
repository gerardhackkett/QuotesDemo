package com.allstate.ghackquotes.quotes.examples;
//This file sequentially goes through each question and adds each item to an Array
//It then writes a file from the Array Data
//After that it reads in from created file
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class QuoteSequential {

    static Scanner myScanner = new Scanner(System.in);
    static ArrayList<String> quoteDetailsArray = new ArrayList<>();

    public static void main(String[] args) {

        String vehicleReg;
        int noOfSeats;
        int engineCapacity;
        int otherVehicles;
        double quote;
        String bodyStyle;
        String registeredDate = null;
        String owner;
        double marketValue;
        boolean involvedInAccident;
        boolean changedFromManufacturersSpec;
        boolean registeredKeeper;






        //Vehicle Reg
        System.out.println("Enter the registration of the vehicle egLA51Abc");
        vehicleReg = myScanner.nextLine();



        //Number of seats //VALIDATE between 2 and 7
        do {
            System.out.println("How many seats does the vehicle have (2 to 7)?");
            noOfSeats = Integer.parseInt(myScanner.nextLine());

        } while (noOfSeats < 2 && noOfSeats > 7);
        double seatsfactor=0.00;

        if(noOfSeats<2 || noOfSeats>7){
            System.out.println("Please enter number of seats(must be between 2 and 7)");
            noOfSeats = myScanner.nextInt();
        }



        //Body Type  ///VALIDATE coupe,hatchback,estate
        System.out.println("Enter the vehicle body type - eg.Coupe,hatchback,estate");
        bodyStyle= myScanner.nextLine();


        //Engine Capacity
        ///VALIDATE >=1000
        System.out.println("What is the engine capacity?");
        engineCapacity = myScanner.nextInt();


            if(engineCapacity < 1000){
                System.out.println("What is the engine capacity?  (must be greater than 1000)");
                engineCapacity = myScanner.nextInt();
                myScanner.nextLine();
            }

        double capacityfactor;




        //MarketValue ///VALIDATE >=0

        do {
            System.out.println("What is the current vehicle value?");
            marketValue = myScanner.nextDouble();
            myScanner.nextLine();
           //marketValue = Double.parseDouble(myScanner.nextDouble());
        } while (marketValue < 0);


        double marketValueFactor;


        //Invvolved in accidents?
        System.out.println("Has the vehicle been involved in any accidents?  Yes/No");
        //involvedInAccident = myScanner.nextBoolean();
        String accidentsresponse =  myScanner.nextLine();

        if(accidentsresponse=="Yes" || accidentsresponse=="yes"){
            involvedInAccident = true;
        }
        else{
            involvedInAccident=false;
        }


        //manufacturers spec?
        System.out.println("Has the vehicle been changed from the manufacturers specification? (Yes or No)");
        //changedFromManufacturersSpec = myScanner.nextBoolean();
        String specificationresponse =  myScanner.nextLine();
        if(specificationresponse=="Yes" || specificationresponse=="yes"){
            changedFromManufacturersSpec = true;
        }
        else{
            changedFromManufacturersSpec=false;
        }



        //Registered Date
        System.out.println("What date was the car registered?");
        registeredDate = myScanner.nextLine();


        //How many household vehicles
        System.out.println("How many other vehicles are in the household");
        otherVehicles = myScanner.nextInt();
        myScanner.nextLine();



        //getVehicleOwner();
        System.out.println("Who is the owner of the vehicle? (proposer, spouse)");
        owner = myScanner.nextLine();
        ///VALIDATE proposer,spouse,other
//        if( owner != "proposer" || owner != "spouse" ||owner != "other"){
//            System.out.println("Who is the owner of the vehicle?");
//            owner = myScanner.nextLine();
//        }

        System.out.println("Are you the registered keeper of the vehicle? (Yes/No)");
        //registeredKeeper =  myScanner.nextBoolean();
        String keeperresponse =  myScanner.nextLine();
        if(keeperresponse=="Yes" || keeperresponse=="yes"){
            registeredKeeper = true;
        }
        else{
            registeredKeeper=false;
        }



        // Iterate the arraylist and display the values using a LAMBDA function
        quoteDetailsArray.forEach(quoteItem -> System.out.println(quoteItem));


        //calculate quote
        switch(engineCapacity) {
            case 1000:
                capacityfactor = 1.0;
                break;
            case 1100:
                capacityfactor = 1.1;
                break;
            case 1600:
                capacityfactor = 1.6;
                break;
            case 1500:
                capacityfactor = 1.8;
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
        System.out.println("capacity  = "+engineCapacity);
        System.out.println("capacity factor  = "+capacityfactor);


        if(marketValue<=1000){
            marketValueFactor=1.0;
        }
        else{
            marketValueFactor=1.2;
        }
        System.out.println("marketvalue  = "+marketValue);
        System.out.println("marketFactor = "+marketValueFactor);



            switch(noOfSeats) {
                case 2:
                    seatsfactor = 1.5;
                    break;
                case 3:
                    seatsfactor = 1.4;
                    break;
                case 4:
                    seatsfactor = 1.3;
                    break;
                case 5:
                    seatsfactor = 1.5;
                    break;
                case 6:
                    seatsfactor = 1.6;
                    break;
                case 7:
                    seatsfactor = 1.7;
                    break;
                default:
                    seatsfactor = 1.5;


        }
        System.out.println("seats  = "+noOfSeats);
        System.out.println("SeatFactor = "+seatsfactor);




        quote = 100 *seatsfactor *capacityfactor * marketValueFactor;
        System.out.println("Your Quotation is: £"+quote);
        // 100 * seatFactor * engineCCFactor * vehicleValueFactor




        //store all these details in an array
        quoteDetailsArray.add(vehicleReg);
        quoteDetailsArray.add(Integer.toString(noOfSeats));
        quoteDetailsArray.add(bodyStyle);
        quoteDetailsArray.add(Integer.toString(engineCapacity));
        quoteDetailsArray.add(Double.toString(marketValue));



        //Display one or all of the quotations from the array using formatted output

//        /* ******************** WRITE TO THE TEXT FILE *********************
//         *******************************************************************/
        try {
            FileWriter myWriter = new FileWriter("quotedetails.txt");
            myWriter.write("Car Registration\t" + vehicleReg +"\n");
            myWriter.write("Number of seats\t\t" + noOfSeats  +"\n");
            myWriter.write("Body Style\t\t\t" + bodyStyle +"\n");
            myWriter.write("Engine CC\t\t\t" + engineCapacity +"\n");
            myWriter.write("Value of vehicle\t" + marketValue +"\n");
            myWriter.write("Quotation\t\t\t" + quote +"\n");
            myWriter.close();
            System.out.println("******************** WRITE DATA TO A TEXT FILE ********************");
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }



        System.out.println("******************** READ DATA FROM A TEXT FILE ********************");

        /*******************************************************************
         * ********************** READ THE TEXT FILE **********************
         *******************************************************************/

        // The name of the file to open.
        String fileName = "quotedetails.txt";

        // This will reference one line at a time
        String line = null;

        try
        {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while((line = bufferedReader.readLine()) != null)
            {
                System.out.println(line);
            }

            // Always close files.
            bufferedReader.close();
        }
        catch(FileNotFoundException ex)
        {
            System.out.println("Unable to open file '" + fileName + "'");
        }
        catch(IOException ex)
        {
            System.out.println("Error reading file '"+ fileName + "'");
        }




    }


}
