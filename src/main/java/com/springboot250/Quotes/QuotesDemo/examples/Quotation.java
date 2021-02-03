package com.allstate.ghackquotes.quotes.examples;
//THIS is an example of a Quote object.
public class Quotation {
    private String firstName;
    private String lastName;
    private String registration;
    private String bodyType;
    private Double marketValue;
    private String owner;
    private int otherVehicle;
    private String registeredDate;
    private int engineCC;
    private String manufactureresspec;
    private String accident;
    private String productID;
    private int quoteAmount;



    public Quotation(String firstName, String lastName, String registration, String bodyType, Double marketValue, String owner, int otherVehicles, String registeredDate, int engineCC, String manufactureresspec, String accident, String productID, int quoteAmount) {
        this.firstName= firstName;
        this.lastName=lastName;
        this.registration= registration;
        this.bodyType= bodyType;
        this.marketValue=marketValue;
        this.owner=owner;
        this.otherVehicle= otherVehicles;
        this.registeredDate=registeredDate;
        this.engineCC=engineCC;
        this.manufactureresspec= manufactureresspec;
        this.accident=accident;
        this.quoteAmount=quoteAmount;
        this.productID= productID;
    }

    public Quotation(){

    }

    public int getQuoteAmount() {
        return quoteAmount;
    }

    public void setQuoteAmount(int quoteAmount) {
        this.quoteAmount = quoteAmount;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public Double getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(Double marketValue) {
        this.marketValue = marketValue;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getOtherVehicle() {
        return otherVehicle;
    }

    public void setOtherVehicle(int otherVehicle) {
        this.otherVehicle = otherVehicle;
    }

    public String getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(String registeredDate) {
        this.registeredDate = registeredDate;
    }

    public int getEngineCC() {
        return engineCC;
    }

    public void setEngineCC(int engineCC) {
        this.engineCC = engineCC;
    }

    public String getManufactureresspec() {
        return manufactureresspec;
    }

    public void setManufactureresspec(String manufactureresspec) {
        this.manufactureresspec = manufactureresspec;
    }

    public String getAccident() {
        return accident;
    }

    public void setAccident(String accident) {
        this.accident = accident;
    }




    public String VATCodeOfProduct() {
        return productID.substring(0,2);
    }

    public double calculateVATRate() {
        switch(VATCodeOfProduct()){
            case "T0" : return 0.0;
            case "T1" : return 0.2;
            case "T2" : return 0.5;
            default:return 100.00;
        }
    }

    public double calculateVATAmount() {
       // return calculateVATRate()*quantity*itemPrice;

        return quoteAmount/calculateVATRate() *100;

    }



    public double calculateTotalCostOfInvoice() {
        return calculateVATAmount()+quoteAmount;
    }
}
