package com.pay.atharva.bean;

import java.io.Serializable;

public class user implements Serializable {
    private static final long serialVersionUID = 1L;


    private String userName;
    private String email;
    private String ifscCode;
    private String accountType;
    private String bankName;
    private String mobile;
    private String accountNumber;
    private String history;
    private int accountPin;
    private double accountBalance;

    public user(String userName, String email, String ifscCode, String accountType, String bankName, String mobile, String accountNumber, String history, int accountPin, double accountBalance) {
        this.userName = userName;
        this.email = email;
        this.ifscCode = ifscCode;
        this.accountType = accountType;
        this.bankName = bankName;
        this.mobile = mobile;
        this.accountNumber = accountNumber;
        this.history = history;
        this.accountPin = accountPin;
        this.accountBalance = accountBalance;
    }

    @Override
    public String toString() {
        return "user{" +
                "userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", ifscCode='" + ifscCode + '\'' +
                ", accountType='" + accountType + '\'' +
                ", bankName='" + bankName + '\'' +
                ", mobile='" + mobile + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", history='" + history + '\'' +
                ", accountPin=" + accountPin +
                ", accountBalance=" + accountBalance +
                '}';
    }

    public user() {
        super();
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public int getAccountPin() {
        return accountPin;
    }

    public void setAccountPin(int accountPin) {
        this.accountPin = accountPin;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
}
