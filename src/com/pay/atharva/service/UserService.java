package com.pay.atharva.service;

import com.pay.atharva.bean.user;

public interface UserService {
    public void login();


    public  void userFunctionalities();

    public void createAccount();

    public void logout(user u);

    public void fundTransfer( int ammount , int pin , user fromUser, user toUser);

    public void withdraw(user u);

    public void changePin(user u);

    public void createLog(user u , String str);
}
