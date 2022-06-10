package com.techelevator;

public class Wallet {

    Double balance = 0.00;
    Double quarter = 0.25;
    Double dime = 0.10;
    Double nickle = 0.05;
    Double dollar = 1.00;
    Double twoDollar = 2.00;
    Double fiveDollar = 5.00;

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public void setQuarter(Double quarter) {
        this.quarter = quarter;
    }

    public void setDime(Double dime) {
        this.dime = dime;
    }

    public void setNickle(Double nickle) {
        this.nickle = nickle;
    }

    public void setDollar(Double dollar) {
        this.dollar = dollar;
    }

    public void setTwoDollar(Double twoDollar) {
        this.twoDollar = twoDollar;
    }

    public void setFiveDollar(Double fiveDollar) {
        this.fiveDollar = fiveDollar;
    }

    public Double getBalance() {
        return balance;
    }

    public Wallet() {
        System.out.println(getBalance());
    }



}
