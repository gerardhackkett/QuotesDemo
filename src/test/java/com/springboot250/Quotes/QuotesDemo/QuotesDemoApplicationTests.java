package com.springboot250.Quotes.QuotesDemo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.springboot250.Quotes.QuotesDemo.entities.Quote;
import com.springboot250.Quotes.QuotesDemo.rest.QuotesController;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.Arrays;
import java.util.List;

//The @SpringBootTest annotation tells Spring Boot to look for a main configuration class
@SpringBootTest
public class QuotesDemoApplicationTests {
	Quote Myquote;
	String firstname;
	String lastname;
	Double quote;
	String registration;
	String bodytype;
	Double marketvalue;
	String owner;
	Integer othervehicles;
	String registereddate;
	Integer enginecc;
	String manufactureresspec;
	String accident;



	Quote quote1 = new Quote("Gerard", "Hackett", 280.00, "LA51ABC", "Coupe", 9000.00, "Spouse", 2, "1/1/2021", 1000, "No", "No");
	Quote quote2 = new Quote("Jimi", "Hendrix", 280.00, "LA51ABC", "Coupe", 9000.00, "Spouse", 2, "1/1/2021", 1000, "No", "No");

	double householdVehiclesFactor = 1.5;
	double capacityFactor=2.5;
	double marketValueFactor=1.0;

	List<Quote > allQuotesList = Arrays.asList(quote1, quote2);
	Quote[] allQuotesArray = {quote1, quote2};

	@Autowired
	private QuotesController controller;


	@Test
	public void contextLoads() {
		assertThat(controller).isNotNull();
	}

	@Test
	public void testFirstName() {
		assertThat(quote1.getFirstName()).isEqualTo("Gerard");
		assertThat(quote2.getFirstName()).isEqualTo("Jimi");
	}

	@Test
	public void testLastName() {
		assertThat(quote1.getLastName()).isEqualTo("Hackett");
		assertThat(quote2.getLastName()).isEqualTo("Hendrix");
	}

	@Test
	public void testCalculateQuote(){

		assertThat(quote1.getQuote()).isEqualTo(280.00);

	}

	@Test
	public void testValues(){
		assertThat(quote1.getLastName()).isEqualTo("Hackett");
		assertThat(quote1.getRegistration()).isEqualTo("LA51ABC");
		assertThat(quote1.getBodytype()).isEqualTo("Coupe");
		assertThat(quote1.getOwner()).isEqualTo("Spouse");
		assertThat(quote1.getEnginecc()).isEqualTo(1000);
		assertThat(quote1.getMarketvalue()).isEqualTo(9000.00);

	}




//    @Test
//    public void testCreateEmptyQuote(){
//        Quote quote = new Quote();
//        assertThat(quote.getFirstName()).isEqualTo("");
//        assertThat(quote.getLastName()).isEqualTo("");
//        assertThat(quote.getOwner()).isEqualTo("");
//        assertThat(quote.getRegistration()).isEqualTo("");
//        assertThat(quote.getRegistereddate()).isEqualTo("");
//        assertThat(quote.getManufactureresspec()).isEqualTo("");
//        assertThat(quote.getEnginecc()).isEqualTo("");
//        assertThat(quote.getAccident()).isEqualTo("");
//        assertThat(quote.getBodytype()).isEqualTo("");
//        assertThat(quote.getQuote()).isEqualTo("");
//        assertThat(quote.getMarketvalue()).isEqualTo("");
//        assertThat(quote.getOthervehicles()).isEqualTo("");
//    }




//    @Test
//    public void testAddPriceToQuote(){
//		Quote quote= new Quote("Gerard", "Hackett", 280.00, "LA51ABC", "Coupe", 9000.00, "Spouse", 2, "1/12021", 500, "No", "No");
//		assertThat(Myquote.getQuote()).isEqualTo(280.00);
//
//
//    }

//    @Test
//    public void testAddFirstNameToQuote(){
//
//        Myquote.setFirstName("Gerard");
//        assertThat(Myquote.getFirstName()).isEqualTo("Gerard");
//    }

//    @Test
//    public void testAddLastNameToQuote(){
//
//        Myquote.setLastName("Hackett");
//        assertThat(Myquote.getLastName()).isEqualTo("Hackett");
//    }

//    @Test
//    public void testAddBodyTypeToQuote(){
//
//        Myquote.setBodytype("Coupe");
//        assertThat(Myquote.getBodytype()).isEqualTo("Coupe");
//
//    }


//    @Test
//    public void testAddAccidentToQuote(){
//
//        Myquote.setAccident("No");
//        assertThat(Myquote.getAccident()).isEqualTo("No");
//
//    }


//    @Test
//    public void testAddEngineCCToQuote(){
//
//        Myquote.setEnginecc(1000);
//        assertThat(Myquote.getEnginecc()).isEqualTo(1000);
//    }


//    @Test
//    public void testAddManufacturingSpecToQuote(){
//
//        Myquote.setManufactureresspec("No");
//        assertThat(Myquote.getManufactureresspec()).isEqualTo("No");
//
//    }


//    @Test
//    public void testAddOtherVehiclesToQuote(){
//
//        Myquote.setOthervehicles(1);
//        assertThat(Myquote.getOthervehicles()).isEqualTo(1);
//    }


//    @Test
//    public void testAddRegisteredDateToQuote(){
//
//        Myquote.setRegistereddate("1/1/2021");
//        assertThat(Myquote.getRegistereddate()).isEqualTo("1/1/2021");
//    }


//    @Test
//    public void testAddRegistrationToQuote(){
//
//        Myquote.setRegistration("ABC123");
//        assertThat(Myquote.getRegistration()).isEqualTo("ABC123");
//    }


//    @Test
//    public void testAddOwnerToQuote(){
//
//        Myquote.setOwner("Spouse");
//        assertThat(Myquote.getOwner()).isEqualTo("Spouse");
//    }



}

//@RunWith(SpringRunner.class)
//@DataJpaTest
//
//