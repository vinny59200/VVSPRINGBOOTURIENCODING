package com.vv.springbooturiencoding.management;

import java.text.DecimalFormat;

public class a {
    public static void main(String[] args) {
        double value = 1234.567890;
        getDecimal(value, 5);
    }

    private static void getDecimal(double value, int numPlaces) {
        double toProcess = value % 1;

        String numberSigns = "";
        for (int i = 0; i < numPlaces; i++) {
            numberSigns += "#";
        }

        DecimalFormat fmt = new DecimalFormat("." + numberSigns);

        System.out.println(fmt.format(toProcess).substring(1));
    }
}
