package com.allstate.ghackquotes.quotes.examples;
//This calls the QuoteMethods class to run each method
public class QuoteApplication {

    public static void main(String[] args) {


        //run VehicleInformation  to get all details
        String vehicleReg = QuoteMethods.vehicleReg();

        int noOfSeats = QuoteMethods.seatCount();

        String bodyStyle = QuoteMethods.bodyType();

        int engineCapacity = QuoteMethods.engineCapacity();

        Double marketValue = QuoteMethods.marketValue();

        Boolean involvedInAccident =QuoteMethods.involvedInAccidents();

        Boolean changedFromManufacturersSpec = QuoteMethods.manufacturersSpec();

        String registeredDate = QuoteMethods.registeredDate();

        int otherVehicles = QuoteMethods.howManyHouseholdVehicles();

        Boolean registeredKeeper = QuoteMethods.registeredOwner();


        Double seatsfactor = QuoteMethods.seatCountFactor();
        Double capacityfactor = QuoteMethods.engineCapacityFactor();
        Double marketValueFactor= QuoteMethods.marketValueFactor();
        // run CalculateQuote
        QuoteMethods.calculateQuote(seatsfactor,capacityfactor,marketValueFactor);


        //run StoreQuoteDetails
        QuoteMethods.storeItemsInArray(vehicleReg,noOfSeats, bodyStyle,engineCapacity, marketValue, involvedInAccident,  changedFromManufacturersSpec, registeredDate, otherVehicles, registeredKeeper);
        QuoteMethods.displayLambda();


    }
}
