package com.springboot250.Quotes.QuotesDemo.examples;
//THIS IS AN EXAMPLE OF INVOICE OBJECT
import java.util.ArrayList;
import java.util.List;
import com.allstate.ghackquotes.quotes.examples.Quotation;

public class Invoice {



    List<Quotation> quotationList = new ArrayList<Quotation>();

    public int getProductCount(){
        return quotationList.size();
    };

    public void addProduct(Quotation quotation) {
        quotationList.add(quotation);
    }

    public double productTotal() {

        double totalProduct = 0.0;
        if(quotationList.size()>0){
            for(Quotation quotation : quotationList){
                totalProduct+= quotationList.size()* quotation.getQuoteAmount();
            }
        }


        return totalProduct;
    }
}
