package com.springboot250.Quotes.QuotesDemo.repo;

import com.springboot250.Quotes.QuotesDemo.entities.Quote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;



//<dependency>
//			<groupId>com.h2database</groupId>
//			<artifactId>h2</artifactId>
//			<scope>runtime</scope>
//		</dependency>
//this is added to the pom so that we can use In Memory Database - Hypersonic
//Usually this is used for testing


//1) added hypersonic to the pom.xml
//2) commented out the SQL stuff from application.properties
//3) add the following to application properties:
// Enabling H2 Console
//spring.h2.console.enabled=true
//4) launch the Spring Boot app and visit http://localhost:8080/h2-console
//5) get the DATABASE URL from the Spring Boot Startu log and put it in the connection url




public interface QuoteRepository  extends JpaRepository<Quote, Integer> {

    Collection<Quote> findQuotationByLastName(String lastName);
    //Collection<Quote> findQuotationByReg(String registration);
}
