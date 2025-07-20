package com.pay.atharva.validate;

import com.pay.atharva.bean.user;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateUser {

    private static Matcher matcher;  // Matcher class id used to match the pattern
    private static Pattern pattern; // Pattern class is used to create pattern

    // Email Pattern
    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";


    public static boolean checkLength(int length, String text, boolean lengthEquals) {

        if (text == null) return false;
        if (lengthEquals) {


            return text.length() == length ;

        }
        else
        {

            return text.length() >= length ;
        }
    }

    /*
    Validating Email
    */
    public static boolean validateEmail(String email) {
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

    /*
    Validating Pin
    */
    public static boolean verifyPin(int pin , user u) {
        if (pin == u.getAccountPin()) return true;
        else return false;
    }

    /*
    isNot NUll String
    */
    public static boolean isNotNull(String str) {
        return str != null && str.trim().length() > 0 ? true : false;
    }

    /*
    Validating password with retyped password
    */
    public static boolean validatePassword(String pass) {
    /*if(pass!= null && pass.length() >3)
    {
        return true;
    }
    else
    {
        return false;
    }*/

    //    we can write same code in both the ways ↑  or ↓

        return pass != null && pass.length() > 3 ? true : false;
    }


    /*to check space in string*/

    public static boolean havingSpace(String str)
    {
        boolean space = false;
    //        int f= 0;
        for (int i = 0; i< str.length(); i++)
        {
            if(str.contains(" "))
            {
    //                f = 0;
                space = true;
            }
        }
        return space;
    }

    /*Validating Mobile No*/

    public static boolean validateMobileNumber(String mobileNumber)
    {
        return mobileNumber != null && mobileNumber.length()==10;
    }

}
