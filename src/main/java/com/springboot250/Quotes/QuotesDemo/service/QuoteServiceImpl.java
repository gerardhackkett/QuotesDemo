package com.springboot250.Quotes.QuotesDemo.service;
import com.springboot250.Quotes.QuotesDemo.entities.Quote;
import com.springboot250.Quotes.QuotesDemo.repo.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
@Transactional(Transactional.TxType.REQUIRED)
public class QuoteServiceImpl implements QuoteService {

    @Autowired
    private QuoteRepository repository;

    @Override
    public Quote getQuote(Quote quotation) {
        // got the price
        Quote newQuote = calculateQuote(quotation);
        // put the quote into the database
        Quote savedQuotation = repository.save(newQuote);
        // return the saved quotation
        return savedQuotation;
    }

    @Override
    public Collection<Quote> getAllQuotes() {
        return repository.findAll();
    }

    @Override
    public Collection<Quote> getQuotesByLastName(String lastName) {
        return repository.findQuotationByLastName(lastName);
    }

//    @Override
//    public Collection<Quotation> getQuotesByReg(String registration) {
//        return repository.findQuotationByReg(registration);
//    }




    private Quote calculateQuote(Quote quotation) {

        double  householdVehiclesFactor;
        double capacityFactor;
        double marketValueFactor;


        switch(quotation.getOthervehicles()){
            case 0:
                householdVehiclesFactor = 1.5;
                break;
            case 1:
                householdVehiclesFactor = 1.5;
                break;
            case 2:
                householdVehiclesFactor = 1.5;
                break;
            case 3:
                householdVehiclesFactor = 1.4;
                break;
            case 4:
                householdVehiclesFactor = 1.3;
                break;
            case 5:
                householdVehiclesFactor = 1.5;
                break;
            case 6:
                householdVehiclesFactor = 1.6;
                break;
            case 7:
                householdVehiclesFactor = 1.7;
                break;
            default:
                householdVehiclesFactor = 1.5;

        }


        switch(quotation.getEnginecc()) {
            case 100:
                capacityFactor = 1.0;
                break;
            case 200:
                capacityFactor = 1.1;
                break;
            case 300:
                capacityFactor = 1.6;
                break;
            case 400:
                capacityFactor = 2.0;
                break;
            case 500:
                capacityFactor = 2.5;
                break;
            case 1000:
                capacityFactor = 2.5;
                break;
            case 1500:
                capacityFactor = 3.0;
                break;
            default:
                capacityFactor = 1.0;
        }


        if(quotation.getMarketvalue()<1000.00){
            marketValueFactor=1.0;
        }
        else{
            marketValueFactor=1.2;
        }


        quotation.setQuote(100 * householdVehiclesFactor * capacityFactor * marketValueFactor);
        //quotation.setQuote(250.00);
        return quotation;
    }

}