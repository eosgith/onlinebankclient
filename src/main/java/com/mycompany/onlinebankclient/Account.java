/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.onlinebankclient;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Java class that represents Account data
 *
 * @authors Eithne O'Sullivan -	17132185, Aaron Pope - 13100106, Kenneth Byrne -
 * 17132410, Jemma McCreesh - 16144457 * 
 * @date 18th April 18
 */

@XmlRootElement
public class Account<T> {
    
    // Overloaded constructor to hold Account variables
    public Account(int id, int sortCode, int accountNumber, String accountName) {
        this.id = id;
        this.sortCode = sortCode;
        this.accountNumber = accountNumber;
        this.currentBalance = 0.0;
        //this.listOfTransactions = listOfTransaction;
        this.accountName = accountName;
    }

    // Default constructor
    public Account() {
    }
    
    // Private variables
    private int id;
    private int sortCode;
    private int accountNumber;
    private double currentBalance;
    //private int listOfTransactions;
    private String accountName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSortCode() {
        return sortCode;
    }

    public void setSortCode(int sortCode) {
        this.sortCode = sortCode;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    
    /*public int getListOfTransactions() {
        return listOfTransactions;
    }

    public void setListOfTransactions(int listOfTransactions) {
        this.listOfTransactions = listOfTransactions;
    }*/
    
    public boolean credit(double amount) {
        currentBalance = currentBalance + amount;
        return true;
    }
   
    public boolean debit(double amount) {
        if (currentBalance >= amount){
           currentBalance = currentBalance - amount; 
           return true;
        }
        else{
           return false; 
        }
    }

    @Override
    public String toString() {
        return "Account{" + "id=" + id + ", sortCode=" + sortCode + ", accountNumber=" + accountNumber + ", currentBalance=" + currentBalance + ", accountName=" + accountName + '}';
    }
    
    

}
