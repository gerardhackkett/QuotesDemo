package com.springboot250.Quotes.QuotesDemo.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="quotations")
public class Quote implements Serializable {


    public Quote(String firstname , String lastname, Double quote, String registration, String bodytype, Double marketvalue, String owner, Integer othervehicles, String registereddate, Integer enginecc, String manufactureresspec, String accident) {
        this.firstName=firstname;
        this.lastName=lastname;
        this.quote = quote;
        this.registration = registration;
        this.bodytype = bodytype;
        this.marketvalue = marketvalue;
        this.owner = owner;
        this.othervehicles = othervehicles;
        this.registereddate = registereddate;
        this.enginecc = enginecc;
        this.manufactureresspec = manufactureresspec;
        this.accident = accident;
    }

    public Quote(){}

    @Column(name="id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="registration")
    private String registration;

    @Column(name="bodytype")
    private String bodytype;

    @Column(name="marketvalue")
    private Double marketvalue;

    @Column(name="owner")
    private String owner;

    @Column(name="othervehicles")
    private Integer othervehicles;

    @Column(name="registereddate")
    private String registereddate;

    @Column(name="enginecc")
    private Integer enginecc;

    @Column(name="manufactureresspec")
    private String manufactureresspec;

    @Column(name="accident")
    private String accident;

    @Column(name="quote")
    private Double quote;


    //Getters
    public Integer getId() {
        return id;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getRegistration() {
        return registration;
    }
    public String getBodytype() {
        return bodytype;
    }
    public Double getMarketvalue() {
        return marketvalue;
    }
    public String getOwner() {
        return owner;
    }
    public Integer getOthervehicles() {
        return othervehicles;
    }
    public String getRegistereddate() {
        return registereddate;
    }
    public Integer getEnginecc() {
        return enginecc;
    }
    public String getManufactureresspec() {
        return manufactureresspec;
    }
    public String getAccident() {
        return accident;
    }
    public Double getQuote() {
        return quote;
    }
    //Setters
    public void setId(Integer id) {
        this.id = id;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setRegistration(String registration) {
        this.registration = registration;
    }
    public void setBodytype(String bodytype) {
        this.bodytype = bodytype;
    }
    public void setMarketvalue(Double marketvalue) {
        this.marketvalue = marketvalue;
    }
    public void setOwner(String owner) {
        this.owner = owner;
    }
    public void setOthervehicles(Integer othervehicles) {
        this.othervehicles = othervehicles;
    }
    public void setRegistereddate(String registereddate) {
        this.registereddate = registereddate;
    }
    public void setEnginecc(Integer enginecc) {
        this.enginecc = enginecc;
    }
    public void setManufactureresspec(String manufactureresspec) {
        this.manufactureresspec = manufactureresspec;
    }
    public void setAccident(String accident) {
        this.accident = accident;
    }
    public void setQuote(Double quote) {
        this.quote = quote;
    }



}