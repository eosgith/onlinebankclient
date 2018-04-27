/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.onlinebankclient;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Java class that represents Transaction data
 *
 * @authors Eithne O'Sullivan -	17132185, Aaron Pope - 13100106, Kenneth Byrne -
 * 17132410, Jemma McCreesh - 16144457
 * @date 18th April 18
 */
@XmlRootElement
public class Transaction {
    
    private int id;
    private int transactionCode;
    private String transactionType;
    private Date date;
    private double postTransactionBalance;
    private String description;
    private double amount;

    // Overloaded Constructor
    public Transaction(int id, int transactionCode, String transactionType, Date date, double amount, double postTransactionBalance, String description) {    
        this.id = id;
        this.transactionCode = transactionCode;
        this.transactionType = transactionType;
        this.date = date;
        this.postTransactionBalance = postTransactionBalance;
        this.amount = amount;
        this.description = description;
    }

    // Default Constructor
    public Transaction() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTransactionCode() {
        return transactionCode;
    }

    public void setTransactionCode(int transactionCode) {
        this.transactionCode = transactionCode;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getPostTransactionBalance() {
        return postTransactionBalance;
    }

    public void setPostTransactionBalance(double postTransactionBalance) {
        this.postTransactionBalance = postTransactionBalance;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Transaction{" + "id=" + id + ", transactionCode=" + transactionCode + ", transactionType=" 
                + transactionType + ", date=" + date + ", postTransactionBalance=" + postTransactionBalance 
                + ", description=" + description + ", amount=" + amount + '}';
    }
    
    

}
