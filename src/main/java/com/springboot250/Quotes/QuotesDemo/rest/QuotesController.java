//This class represents the API/Controller layer -uses GET,POST,DELETE and PUT http requests

package com.springboot250.Quotes.QuotesDemo.rest;
import com.springboot250.Quotes.QuotesDemo.entities.Quote;
import com.springboot250.Quotes.QuotesDemo.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Collection;

@RestController
//@Controller is typically used in combination with a @RequestMapping annotation used on request handling methods
//@RestController is a specialized version of the controller. It includes the @Controller and @ResponseBody annotations and as a result, simplifies the controller implementation:
@RequestMapping("/quotes")
public class    QuotesController {

    DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    Date date = new Date();

    //@Autowired - Springboard injects QuoteService into this constructor- dependancy injection
    @Autowired
    private QuoteService quoteService;


    //http://localhost:8080/quoteDetails?registration=LAH124
    @GetMapping("/quoteDetails")
    public String quoteDetails(@RequestParam("registration")String registration)
    {
        return "REG: "+registration;
        //return quoteService.getQuotesByReg(registration);
    }



    //@GetMapping is a composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod.GET)
    @GetMapping("/{lastName}")
    public Collection<Quote> getQuotesByLastName(@PathVariable String lastName) { //PathVariable grabs the string from URL
        return quoteService.getQuotesByLastName(lastName);
    }




    //@GetMapping is a composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public Collection<Quote> getAllQuotes() {
        return quoteService.getAllQuotes();
    }

//    @GetMapping("/{singleQuote}")
//    public Quote getSingleQuote(@RequestBody Quote quotation){return quoteService.getQuote(quotation);}

    //@PostMapping is a composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod.POST)
    @PostMapping
    public Quote getQuote(@RequestBody Quote quotation) {


        Quote newQuote = quoteService.getQuote(quotation);
        return newQuote;

    }

    @GetMapping("/createinvoice")
    public String CreateAnInVoiceAPI()
    {
        Collection<Quote> quotes = quoteService.getAllQuotes();
        // Quote firstElement = customerInvoice.stream().findFirst();
        String firstname = quotes.iterator().next().getFirstName();
        String lastname = quotes.iterator().next().getLastName();
        String registration = quotes.iterator().next().getRegistration();
        Double marketvalue = quotes.iterator().next().getMarketvalue();
        Double quote = quotes.iterator().next().getQuote();
        String bodytype = quotes.iterator().next().getBodytype();
        Integer othervehicles = quotes.iterator().next().getOthervehicles();
        String manufactureresspec = quotes.iterator().next().getManufactureresspec();
        String accident = quotes.iterator().next().getAccident();
        String owner = quotes.iterator().next().getOwner();
        String registereddate = quotes.iterator().next().getRegistereddate();
        Integer enginecc = quotes.iterator().next().getEnginecc();

        Quote customerInvoice = new Quote(firstname,lastname,quote, registration, bodytype, marketvalue, owner, othervehicles, registereddate, enginecc, manufactureresspec, accident);

        return "<!-- Latest compiled and minified CSS -->\n" +
                "<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">\n" +
                "\n" +
                "<!-- Latest compiled and minified JavaScript -->\n" +
                "<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\" integrity=\"sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa\" crossorigin=\"anonymous\"></script>\n" +        "\n" +
                "<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->\n" +
                "<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js\"></script>\n" +
                "\n" +
                "<link rel=\"stylesheet\" href=\"Invoice.css\">\n" +
                "\n" +
                "<!------ Include the above in your HEAD tag ---------->\n" +
                "\n" +
                "<div class=\"container\">\n" +
                "    <div class=\"row\" style=\"background-color:lightgray;\">\n" +
                "        <div class=\"col-xs-12\">\n" +
                "            <div class=\"invoice-title\">\n" +
                "                <h2>Invoice</h2><h5>Invoice No: 12345</h5>\n" +
                "            </div>\n" +
                "            <hr>\n" + "            <div class=\"row\" >\n" +
                "                <div class=\"col-xs-6\">\n" +
                "                    <address>\n" +
                "                        <strong>Billed To:</strong><br>\n" +
                "                       "+customerInvoice.getFirstName()+""+ customerInvoice.getLastName()+"<br>\n" +
                "                        1234 Any Street<br>\n" +
                "                        Any Park<br>\n" +
                "                        Belfast, BT1 ANY\n" +
                "                    </address>\n" +
                "                </div>\n" +
                "                <div class=\"col-xs-6 text-right\">\n" +
                "                    <address>\n" +
                "                        <strong>Shipped To:</strong><br>\n" +
                "                        "+customerInvoice.getFirstName()+""+ customerInvoice.getLastName()+"<br>\n" +
                "                        1234 Central  Street<br>\n" +
                "                        Botanic<br>\n" +
                "                        Belfast, BT1 9FQ\n" +
                "                    </address>\n" + "                </div>\n" +
                "            </div>\n" +
                "            <div class=\"row\">\n" +
                "                <div class=\"col-xs-6\">\n" +
                "                    <address>\n" +
                "                        <strong>Payment Method:</strong><br>\n" +
                "                        Visa ending **** 1234<br>\n" +
                "                        ghack@email.com\n" +
                "                    </address>\n" +
                "                </div>\n" +
                "                <div class=\"col-xs-6 text-right\">\n" +
                "                    <address>\n" +
                "                        <strong>Order Date:</strong><br>\n" +
                "                       " + dateFormat.format(date) + "<br><br>\n" +
                "                    </address>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "\n" + "    <br>\n" +
                "    <br>\n" +
                "\n" +
                "    <div class=\"row\">\n" +
                "        <div class=\"col-md-12\">\n" +
                "            <div class=\"panel panel-default\">\n" +
                "                <div class=\"panel-heading\">\n" +
                "                    <h3 class=\"panel-title\"><strong>Product Details</strong></h3>\n" +
                "                </div>\n" +
                "                <div class=\"panel-body\">\n" +
                "                    <div class=\"table-responsive\">\n" +
                "                        <table class=\"table table-striped\">\n" +
                "                            <thead>\n" +
                "                            <tr class=\"warning\">\n" +
                "                                <td><strong>Name</strong></td>\n" +
                "                                <td class=\"text-left\"><strong>Reg Number</strong></td>\n" +
                "                                <td class=\"text-left\"><strong>Car Type</strong></td>\n" + "                                <td class=\"text-right\"><strong>Quote Amount</strong></td>\n" +
                "                                <td class=\"text-right\"><strong>Total</strong></td>\n" +
                "                            </tr>\n" +
                "                            </thead>\n" +
                "                            <tbody>\n" +
                "                            <tr class=\"success\">\n" +
                "                                <td>" + customerInvoice.getFirstName()+" "+ customerInvoice.getLastName()+"</td>\n" +
                "                                <td class=\"text-left\">" + customerInvoice.getRegistration()+ "</td>\n" +
                "                                <td class=\"text-left\">" + customerInvoice.getBodytype() + "</td>\n" +
                "                                <td class=\"text-right\">$" + customerInvoice.getQuote() + "</td>\n" +
                "                                <td class=\"text-right\">$" + customerInvoice.getQuote() + "</td>\n" +
                "                            </tr>\n" +
                "                            <tr>\n" + "                                <td class=\"thick-line\"></td>\n" +
                "                                <td class=\"thick-line\"></td>\n" +
                "                                <td class=\"thick-line\"></td>\n" +
                "                                <td class=\"thick-line text-right\"><strong>Subtotal</strong></td>\n" +
                "                                <td class=\"thick-line text-right\">$" + customerInvoice.getQuote() + "</td>\n" +
                "                            </tr>\n" +
                "                            <tr>\n" +
                "                                <td class=\"no-line\"></td>\n" +
                "                                <td class=\"no-line\"></td>\n" +
                "                                <td class=\"no-line\"></td>\n" +
                "                                <td class=\"no-line text-right\"><strong>VAT</strong></td>\n" +
                "                                <td class=\"no-line text-right\">17.5%</td>\n" +
                "                            </tr>\n" +
                "                            <tr>\n" + "                                <td class=\"no-line\"></td>\n" +
                "                                <td class=\"no-line\"></td>\n" +
                "                                <td class=\"no-line\"></td>\n" +
                "                                <td class=\"no-line text-right\"><strong>Total</strong></td>\n" +
                "                                <td class=\"thick-line text-right\">$ " + customerInvoice.getQuote()/100*117.5 + "</td>\n" +


                "                            </tr>\n" +
                "                            <tr>\n" +
                "                                <td class=\"no-line\"></td>\n" +
                "                                <td class=\"no-line\"></td>\n" +
                "                                <td class=\"no-line\"></td>\n" +
                "                                <td class=\"no-line\"></td>\n" +
                "                                <td class=\"thick-line\"></td>\n" +
                "                            </tr>\n" +
                "                            </tbody>\n" +
                "                        </table>\n" +
                "                    </div>\n" +
                "                </div>\n" + "  " +
                "          </div>\n" +
                "           <input type=\"button\" style=\"padding-left:1%;margin-left:46%; width:100px; \" value=\"Print\" onClick=\"window.print()\"/>\n"+
                "        </div>\n" +
                "    </div>\n" +
                "</div>";
    }




    //http://localhost:8080/quotes?vehicleRegistrationNumber=SNZ9999
//    @RequestMapping("/CarDetailsForDatabase")
//    String CarDetailsForDatabase(@RequestParam("vehicleRegistrationNumber")String vehicleRegistrationNumber,
//                                 @RequestParam("numberOfSeats")String numberOfSeats)
//    {
//        return "REG: "+vehicleRegistrationNumber+ "  "+"  Seats= " +numberOfSeats;
//    }






    //With the proceding code, requests to /createinvoice will be handled by get()
    //http://localhost:8080/createnewinvoice
    @RequestMapping("/createnewinvoice")
    public String CreateAnInvoiceWithHardCodeValues(
                                             @RequestParam(value = "firstName", defaultValue = "Gerard") String firstname,
                                             @RequestParam(value = "lastName", defaultValue = "Hackett") String lastname,
                                             @RequestParam(value = "quote", defaultValue = "228.00") Double quote,
                                             @RequestParam(value = "registration", defaultValue = "EH56HI") String registration,
                                             @RequestParam(value = "bodyType", defaultValue = "Coupe") String bodytype,
                                             @RequestParam(value = "marketValue", defaultValue = "18000") Double marketvalue,
                                             @RequestParam(value = "owner", defaultValue = "Spouse") String owner,
                                             @RequestParam(value = "otherVehicles", defaultValue = "2") int othervehicles,
                                             @RequestParam(value = "registeredDate", defaultValue = "1/1/2021") String registereddate,
                                             @RequestParam(value = "engineCC", defaultValue = "1500") int enginecc,
                                             @RequestParam(value = "manufactureresspec", defaultValue = "No") String manufactureresspec,
                                             @RequestParam(value = "accident", defaultValue = "No") String accident)
    {
        System.out.println(dateFormat.format(date));
        Quote customerInvoice = new Quote(firstname,lastname,quote, registration, bodytype, marketvalue, owner, othervehicles, registereddate, enginecc, manufactureresspec, accident);

        return "<!-- Latest compiled and minified CSS -->\n" +
                "<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">\n" +
                "\n" +
                "<!-- Latest compiled and minified JavaScript -->\n" +
                "<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\" integrity=\"sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa\" crossorigin=\"anonymous\"></script>\n" +        "\n" +
                "<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->\n" +
                "<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js\"></script>\n" +
                "\n" +
                "<link rel=\"stylesheet\" href=\"Invoice.css\">\n" +
                "\n" +
                "<!------ Include the above in your HEAD tag ---------->\n" +
                "\n" +
                "<div class=\"container\">\n" +
                "    <div class=\"row\" style=\"background-color:lightgray;\">\n" +
                "        <div class=\"col-xs-12\">\n" +
                "            <div class=\"invoice-title\">\n" +
                "                <h2>Invoice</h2><h5>Invoice No: 12345</h5>\n" +
                "            </div>\n" +
                "            <hr>\n" + "            <div class=\"row\" >\n" +
                "                <div class=\"col-xs-6\">\n" +
                "                    <address>\n" +
                "                        <strong>Billed To:</strong><br>\n" +
                "                        "+customerInvoice.getFirstName()+""+ customerInvoice.getLastName()+"<br>\n" +
                "                        1234 Any Street<br>\n" +
                "                        Any Park<br>\n" +
                "                        Belfast, BT1 ANY\n" +
                "                    </address>\n" +
                "                </div>\n" +
                "                <div class=\"col-xs-6 text-right\">\n" +
                "                    <address>\n" +
                "                        <strong>Shipped To:</strong><br>\n" +
                "                        Mr "+customerInvoice.getFirstName()+" "+ customerInvoice.getLastName()+"<br>\n" +
                "                        1234 Central  Street<br>\n" +
                "                        Botanic<br>\n" +
                "                        Belfast, BT1 9FQ\n" +
                "                    </address>\n" + "                </div>\n" +
                "            </div>\n" +
                "            <div class=\"row\">\n" +
                "                <div class=\"col-xs-6\">\n" +
                "                    <address>\n" +
                "                        <strong>Payment Method:</strong><br>\n" +
                "                        Visa ending **** 1234<br>\n" +
                "                        ghack@email.com\n" +
                "                    </address>\n" +
                "                </div>\n" +
                "                <div class=\"col-xs-6 text-right\">\n" +
                "                    <address>\n" +
                "                        <strong>Order Date:</strong><br>\n" +
                "                       " + dateFormat.format(date) + "<br><br>\n" +
                "                    </address>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "\n" + "    <br>\n" +
                "    <br>\n" +
                "\n" +
                "    <div class=\"row\">\n" +
                "        <div class=\"col-md-12\">\n" +
                "            <div class=\"panel panel-default\">\n" +
                "                <div class=\"panel-heading\">\n" +
                "                    <h3 class=\"panel-title\"><strong>Product Details</strong></h3>\n" +
                "                </div>\n" +
                "                <div class=\"panel-body\">\n" +
                "                    <div class=\"table-responsive\">\n" +
                "                        <table class=\"table table-striped\">\n" +
                "                            <thead>\n" +
                "                            <tr class=\"warning\">\n" +
                "                                <td><strong>Name</strong></td>\n" +
                "                                <td class=\"text-left\"><strong>Reg Number</strong></td>\n" +
                "                                <td class=\"text-left\"><strong>Car Type</strong></td>\n" + "                                <td class=\"text-right\"><strong>Quote Amount</strong></td>\n" +
                "                                <td class=\"text-right\"><strong>Total</strong></td>\n" +
                "                            </tr>\n" +
                "                            </thead>\n" +
                "                            <tbody>\n" +
                "                            <tr class=\"success\">\n" +
                "                                <td>" + customerInvoice.getFirstName()+" "+ customerInvoice.getLastName()+"</td>\n" +
                "                                <td class=\"text-left\">" + customerInvoice.getRegistration()+ "</td>\n" +
                "                                <td class=\"text-left\">" + customerInvoice.getBodytype() + "</td>\n" +
                "                                <td class=\"text-right\">$" + customerInvoice.getQuote() + "</td>\n" +
                "                                <td class=\"text-right\">$" + customerInvoice.getQuote() + "</td>\n" +
                "                            </tr>\n" +
                "                            <tr>\n" + "                                <td class=\"thick-line\"></td>\n" +
                "                                <td class=\"thick-line\"></td>\n" +
                "                                <td class=\"thick-line\"></td>\n" +
                "                                <td class=\"thick-line text-right\"><strong>Subtotal</strong></td>\n" +
                "                                <td class=\"thick-line text-right\">$" + customerInvoice.getQuote() + "</td>\n" +
                "                            </tr>\n" +
                "                            <tr>\n" +
                "                                <td class=\"no-line\"></td>\n" +
                "                                <td class=\"no-line\"></td>\n" +
                "                                <td class=\"no-line\"></td>\n" +
                "                                <td class=\"no-line text-right\"><strong>VAT</strong></td>\n" +
                "                                <td class=\"no-line text-right\">17.5%</td>\n" +
                "                            </tr>\n" +
                "                            <tr>\n" + "                                <td class=\"no-line\"></td>\n" +
                "                                <td class=\"no-line\"></td>\n" +
                "                                <td class=\"no-line\"></td>\n" +
                "                                <td class=\"no-line text-right\"><strong>Total</strong></td>\n" +
                "                                <td class=\"thick-line text-right\">$1450.99</td>\n" +
                "                            </tr>\n" +
                "                            <tr>\n" +
                "                                <td class=\"no-line\"></td>\n" +
                "                                <td class=\"no-line\"></td>\n" +
                "                                <td class=\"no-line\"></td>\n" +
                "                                <td class=\"no-line\"></td>\n" +
                "                                <td class=\"thick-line\"></td>\n" +
                "                            </tr>\n" +
                "                            </tbody>\n" +
                "                        </table>\n" +
                "                    </div>\n" +
                "                </div>\n" + "  " +
                "          </div>\n" +
                "           <input type=\"button\" value=\"Print\" onClick=\"window.print()\"/>\n"+
                "        </div>\n" +
                "    </div>\n" +
                "</div>";
    } // End of CreateAnInvoiceWithHardCodeValues()
}