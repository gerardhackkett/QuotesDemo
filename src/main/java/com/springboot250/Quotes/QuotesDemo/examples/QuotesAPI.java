package com.allstate.ghackquotes.quotes.examples;
//Example API File- used to create API methods for our web server
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration

public class QuotesAPI {


    public static void main(String[] args) throws Exception{
        SpringApplication.run(QuotesAPI.class, args);
    }


    @RequestMapping("/parameterUse")
    String desc(

                //@RequestParam(value = "vehicleRegistrationNumber", defaultValue = "New Quotation") String vehicleRegistrationNumber,
                @RequestParam(value = "firstName", defaultValue = "Gerard") String firstName,
                @RequestParam(value = "lastName", defaultValue = "Hackett") String lastName,
                @RequestParam(value = "registration", defaultValue = "LA53AGC") String registration,
                @RequestParam(value = "bodyType", defaultValue = "Coupe") String bodyType,
                @RequestParam(value = "marketValue", defaultValue = "9000") Double marketValue,
                @RequestParam(value = "owner", defaultValue = "Spouse") String owner,
                @RequestParam(value = "otherVehicles", defaultValue = "2" ) int otherVehicles,
                @RequestParam(value = "registeredDate", defaultValue = "1") String registeredDate,
                @RequestParam(value = "engineCC", defaultValue = "1") int engineCC,
                @RequestParam(value = "manufactureresspec", defaultValue = "1") String manufactureresspec,
                @RequestParam(value = "accident", defaultValue = "1") String accident,
                @RequestParam(value = "productID", defaultValue = "EH56HI") String productID,
                @RequestParam(value = "quoteAmount", defaultValue = "10000") int quoteAmount)




    {
        Quotation customerInvoice = new Quotation( firstName,  lastName,  registration,  bodyType,  marketValue,  owner,  otherVehicles,  registeredDate,  engineCC,  manufactureresspec,  accident,  productID, quoteAmount);







        return String.format("<h1 style=\"color:blue;\">Invoice</h1>Description: %s <br/>Quotation ID: %s " +
                        "<br/> Item Price: £%.2f <br/> Quantity: %d " +
                        "<br/><br/> Cost: £%.2f",
                //customerInvoice.getDescription(),customerInvoice.getProductId(),
                customerInvoice.getRegistration(),customerInvoice.getBodyType(),
                customerInvoice.calculateTotalCostOfInvoice());
    }



    @RequestMapping("/")
    String CreateASaleTestMethod(){
        return "Gerard's API Working";
    }

    @RequestMapping("/addtwonumbers")
    double AddTwoNumbers(){
        return 10+20;
    }




    //http://localhost:8080/addtwonumberspassedin?numberoneparam=100&numbertwoparam=900
    @RequestMapping("/addtwonumberspassedin")
    double AddTwoNumbersGivenBuUser(@RequestParam("numberoneparam")double numberone,
                                    @RequestParam ("numbertwoparam") double numbertwo)
    {
        return numberone+numbertwo;
    }






}



