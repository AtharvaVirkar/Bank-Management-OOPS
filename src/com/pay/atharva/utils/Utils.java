package com.pay.atharva.utils;

import java.sql.Timestamp;
import java.util.Random;

public class Utils {

    /*
    Generating 11 digit Random Account Number
    */

    public static String generateAcNum() {
        // Generate a random long between 10000000000L and 99999999999L (inclusive)
        Random rnd = new Random();
        Long part1 = 10000000000L + rnd.nextLong(90000000000L);


        return String.valueOf(part1);
    }

    /*
        Timestamp
    */
    public static String getTimestamp()
    {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return String.valueOf(timestamp);
    }
}
