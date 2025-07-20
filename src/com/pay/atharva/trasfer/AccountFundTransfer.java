package com.pay.atharva.trasfer;

import com.pay.atharva.bean.user;
import com.pay.atharva.service.UserService;
import com.pay.atharva.utils.Utils;
import com.pay.atharva.validate.ValidateUser;


import java.util.Scanner;

public class AccountFundTransfer implements UserService {
    user u1, u2;
    Scanner sc = new Scanner(System.in);
    int activeAcc;
    private String accountType;


    //init Block
    {
        u1 = new user();
        u2 = new user();

    }

    public static void main(String[] args) {
        AccountFundTransfer fundTransfer = new AccountFundTransfer();
        fundTransfer.mainMenu();


    }

    private void mainMenu() {

        System.out.println("");
        System.out.println(u1.getUserName());
        System.out.println(u2.getUserName());


            System.out.println("1. Login");
            System.out.println("2. Create Account");


        System.out.println("");

        int menuChoice = sc.nextInt();

        if (menuChoice == 1) {
            this.login();

//                logout(u1);
//            } else if (activeAcc == 2) {
//                logout(u2);
//
//            } else {

//            }
            } else if (menuChoice == 2) {
                if (u1.getAccountNumber() != null && u2.getAccountNumber() != null) {
                    print("[ !! Only 2 Users can be Created !! ]\n\n");
                    this.mainMenu();
                }
                this.createAccount();
            } else {
                print("[ !! Invalid or Empty Input !! ]");
            }


        }

        //Account Login code
        @Override
        public void login () {
            print("--------Welcome To Bank Login---------");
            print("====|  Enter Bank Account Number  |====");
            String userAccountNumber = sc.next();
            int userPin;
            if (userAccountNumber.equalsIgnoreCase(u1.getAccountNumber())) {
                print("====|  Enter Your Pin  |====");
                userPin = sc.nextInt();
                if (ValidateUser.verifyPin(userPin, u1)) {
                    activeAcc = 1;
                    print("====|  Login Successfully   |====");
                    createLog(u1, "====|  Login Successfully   |====");
                    userFunctionalities();

                } else {
                    print("[ !! Pin is Not Valid or Empty !! ]");
                    mainMenu();
                }

            } else if (userAccountNumber.equalsIgnoreCase(u2.getAccountNumber())) {
                print("====|  Enter Your Pin  |====");
                userPin = sc.nextInt();
                if (ValidateUser.verifyPin(userPin, u2)) {
                    activeAcc = 2;
                    print("====|  Login Successfully   |====");
                    createLog(u1, "====|  Login Successfully   |====");
                    userFunctionalities();

                } else {
                    print("[ !! Pin is Not Valid or Empty !! ]");
                    mainMenu();
                }

            } else {
                print("[!! Account Number Does Not Exist !! ]");
                mainMenu();
            }


        }

    @Override
    public void userFunctionalities() {
        if (activeAcc != 0) {
            System.out.println("1. Logout");
            System.out.println("2. My Account Detail");
            System.out.println("3. Account Activity");
            System.out.println("4. Fund Transfer");
            System.out.println("5. Withdraw");
            System.out.println("6. Change Pin");
        }

        if (activeAcc != 0) {

            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    if (activeAcc == 1)
                    {
                        logout(u1);
                        userFunctionalities();
                        break;
                    } else if (activeAcc == 2) {
                        logout(u2);
                        userFunctionalities();
                        break;
                    }

                case 2:
                    if (activeAcc == 1)
                    {
                        accountInfoUserFunctionalities(u1);
                        userFunctionalities();
                        break;
                    } else if (activeAcc == 2) {
                        accountInfoUserFunctionalities(u2);
                        userFunctionalities();
                        break;
                    }

                case 3:
                    if (activeAcc == 1)
                    {
                        print(u1.getHistory());
                        userFunctionalities();
                        break;
                    } else if (activeAcc == 2) {
                        print(u2.getHistory());
                        userFunctionalities();
                        break;
                    }
                case 4:
                    if (activeAcc == 1)
                    {
                        int amount;
                        print("====|  Enter Amount   |====");
                        amount = sc.nextInt();
                        print("====|  Enter Your Pin  |====");
                        int Pin = sc.nextInt();

                        fundTransfer(amount , Pin,u1 , u2);
                        userFunctionalities();
                        break;
                    } else if (activeAcc == 2) {
                        int amount;
                        print("====|  Enter Amount   |====");
                        amount = sc.nextInt();
                        print("====|  Enter Your Pin  |====");
                        int Pin = sc.nextInt();

                        fundTransfer(amount , Pin,u2 , u1);
                        userFunctionalities();
                        break;
                    }
                case 5:
                    if (activeAcc == 1)
                    {
                        withdraw(u1);
                        userFunctionalities();
                        break;
                    } else if (activeAcc == 2) {
                        withdraw(u2);
                        userFunctionalities();
                        break;
                    }
                case 6:
                    if (activeAcc == 1)
                    {
                        changePin(u1);
                        userFunctionalities();
                        break;
                    } else if (activeAcc == 2) {
                        changePin(u2);
                        userFunctionalities();
                        break;
                    }


            }
        }
    }

//    Account Creation code

        @Override
        public void createAccount () {
            System.out.println("--------Fill Detail to Continue---------");

//Bank Name

            System.out.println("====|  Enter Bank Name  |====");
            String bankName = sc.next();
            sc.nextLine();
            if (!ValidateUser.checkLength(3, bankName, false)) {
                print("[!! Bank Name is Not Valid or Empty !! ]\n---------------------------------------------\n\n");
                createAccount();

            }
//User Name

            System.out.println("====|  Enter Full Name  |====");
            String fullName = sc.nextLine();

            if (!ValidateUser.checkLength(2, fullName, false)) {
                print("[!! Name is Not Valid or Empty !! ]");
                createAccount();
            }

//Email

            System.out.println("====|  Email  |====");
            String email = sc.next();
            if (!ValidateUser.checkLength(10, email, false) || !ValidateUser.validateEmail(email)) {
                print("[!! Email is Not Valid or Empty !! ]");
                createAccount();
            }

//Mobile No

            System.out.println("====|  Mobile Number  |====");
            String mobile = sc.next();
            if (!ValidateUser.validateMobileNumber(mobile)) {
                print("[!! Mobile Number is Not Valid or Empty !! ]");
                createAccount();
            }

//IFSC no

            System.out.println("====|  Create IFSC Code  |====");
            String ifsc = sc.next();
            if (!ValidateUser.checkLength(11, ifsc, true)) {
                print("[!! IFSC Number is Not Valid or Empty !! ]");
                createAccount();
            }

//Account type

            System.out.println("====|  Select Account Type  |====");
            print("1. Saving");
            print("2. Current");

            int accountTypeChoice = sc.nextInt();

            if (accountTypeChoice == 1) {
                accountType = "Saving";

            } else if (accountTypeChoice == 2) {
                accountType = "Current";
            } else {
                print("[ !! Invalid or Empty Input !! ]");
            }


//Amount Save

            System.out.println("====|  Enter Amount You want to Deposit  |====");
            int balance = sc.nextInt();
            if (balance < 0) {
                print("[ !! Invalid or Empty Input !! ]");
            }


//PIN

            System.out.println("====|  Create 6 Digit Pin  |====");
            int pin = sc.nextInt();
            if (!ValidateUser.checkLength(6, String.valueOf(pin), true)) {
                print("[ !! Pin is Not Valid or Empty !! ]");
                createAccount();
            }


//Account No

            System.out.println("====|  Generating 11 Digit Account Number   |====");
            String accountNumber = Utils.generateAcNum();



            if (u1.getAccountNumber() == null) {

                u1.setBankName(bankName);
                u1.setAccountBalance(balance);
                u1.setAccountPin(pin);
                u1.setEmail(email);
                u1.setAccountNumber(accountNumber);
                u1.setAccountType(accountType);
                u1.setHistory(Utils.getTimestamp());
                u1.setMobile(mobile);
                u1.setIfscCode(ifsc);
                u1.setUserName(fullName);
                this.createLog(u1, "====|  Account is Created Successfully   |====");
                this.accountInfo(u1);
            } else if (u2.getAccountNumber() == null) {
                u2.setBankName(bankName);
                u2.setAccountBalance(balance);
                u2.setAccountPin(pin);
                u2.setEmail(email);
                u2.setAccountNumber(accountNumber);
                u2.setAccountType(accountType);
                u2.setHistory(Utils.getTimestamp());
                u2.setMobile(mobile);
                u2.setIfscCode(ifsc);
                u2.setUserName(fullName);
                this.createLog(u2, "====|  Account is Created Successfully   |====");
                this.accountInfo(u2);
            }


        }

        private  void accountInfoUserFunctionalities(user u){
            System.out.println("-----------*******-------------");
            System.out.println("-----------***[ Account Created Successfully ]***-------------");
            System.out.println("!! Account Detail !!");
            System.out.println("!!~ Bank Name => " + u.getBankName());
            System.out.println("!!~ Account Name => " + u.getUserName());
            System.out.println("!!~ Account Email => " + u.getEmail());
            System.out.println("!!~ Mobile Number => " + u.getMobile());
            System.out.println("!!~ Account Number => " + u.getAccountNumber());
            System.out.println("!!~ Account Balance => " + u.getAccountBalance());
            System.out.println("!!~ Account Type => " + u.getAccountType());
            System.out.println("!!~ IFSC Code => " + u.getIfscCode());
            System.out.println("!!~ Account Pin => " + u.getAccountPin());
            print("-----------*******-------------");
            this.userFunctionalities();
        }
        private void accountInfo (user u){
            System.out.println("-----------*******-------------");
            System.out.println("-----------***[ Account Created Successfully ]***-------------");
            System.out.println("!! Account Detail !!");
            System.out.println("!!~ Bank Name => " + u.getBankName());
            System.out.println("!!~ Account Name => " + u.getUserName());
            System.out.println("!!~ Account Email => " + u.getEmail());
            System.out.println("!!~ Mobile Number => " + u.getMobile());
            System.out.println("!!~ Account Number => " + u.getAccountNumber());
            System.out.println("!!~ Account Balance => " + u.getAccountBalance());
            System.out.println("!!~ Account Type => " + u.getAccountType());
            System.out.println("!!~ IFSC Code => " + u.getIfscCode());
            System.out.println("!!~ Account Pin => " + u.getAccountPin());
            print("-----------*******-------------");
            this.mainMenu();

        }


        //Creating Print Function so that we don't need to write SOUT again and again
        private void print (String s){
            System.out.println(s);
        }

        @Override
        public void logout (user u){
        activeAcc =0;
        print("====|  Logout Successfully   |====");
        createLog(u, "Account Logout");
        mainMenu();

        }

        @Override
        public void fundTransfer ( int amount, int pin, user fromUser, user toUser){
            if (ValidateUser.verifyPin(pin, fromUser)) {
                if (amount <= fromUser.getAccountBalance()) {
                    toUser.setAccountBalance(toUser.getAccountBalance() + amount);
                    fromUser.setAccountBalance(fromUser.getAccountBalance() - amount);
                    print("====|  Transaction Successful   |====\nYour Balance is:- " + fromUser.getAccountBalance());
                    createLog(fromUser, amount + "Transfer to " + toUser.getUserName());
                    createLog(toUser, amount + "Received from " + fromUser.getUserName());
                    userFunctionalities();
                } else {
                    print("[!! Insufficient Balance !! ]");
                    print("------------------------------------");
                    userFunctionalities();
                }

            } else {
                print("[!! Pin is Not Correct !! ]");
                mainMenu();
            }

        }




    @Override
        public void withdraw (user u){
            int amount;
            print("====|  Enter Amount   |====");
            amount = sc.nextInt();
            print("====|  Enter Your Pin  |====");
            int Pin = sc.nextInt();
            if (ValidateUser.verifyPin(Pin, u)) {

                if (u.getAccountBalance() <= amount) {

                    u.setAccountBalance(u.getAccountBalance() - amount);
                    print("====|  Withdraw Successful   |====\nYour Balance is:- " + u.getAccountBalance());
                    createLog(u, amount + " withdraw");
                    userFunctionalities();
                } else {

                    print("[!! Insufficient Balance !! ]");
                    print("------------------------------------");
                }
            } else {
                print("[!! Pin is Not Correct !! ]");
                userFunctionalities();
            }


        }

        @Override
        public void changePin (user u) {
            print("====|  Enter Your Old Pin  |====");
            int Pin = sc.nextInt();
            if (ValidateUser.verifyPin(Pin, u))
            {
                print("====|  Enter Your New Pin  |====");
                int nPin = sc.nextInt();
                u.setAccountPin(nPin);
                print("====|  Successfully Pin Changed   |====");
                userFunctionalities();
            }
            else
            {
                print("[!! Incorrect Old Pin !! ]");
                userFunctionalities();
            }


        }

        @Override
        public void createLog (user u, String msg){

            String history = null;

            if (u.getHistory() == null) {
                history = "";
            } else {
                history = u.getHistory();
            }
            u.setHistory(msg + "on" + Utils.getTimestamp() + "\n" + history);
        }

    }
