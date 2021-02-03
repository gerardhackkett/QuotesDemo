   //This class represents the Service Layer where we perform the business logic

    package com.springboot250.Quotes.QuotesDemo.service;

    import com.springboot250.Quotes.QuotesDemo.entities.Quote;

    import java.util.Collection;

    public interface QuoteService {

    Quote getQuote(Quote quote);
    //returns quote with a value in it

    Collection<Quote> getAllQuotes();

    Collection<Quote> getQuotesByLastName(String lastName);

//    Collection<Quote> getQuotesByReg(String registration);

}
