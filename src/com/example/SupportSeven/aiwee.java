package com.example.SupportSeven;

/**
 * Created by Luffy on 1/28/2015.
 */
public class aiwee {
    public static void main(String[] args) {
        String s= null;
        System.out.println("my string = " + capitalizeFirstLetter(s));
    }
    public static String capitalizeFirstLetter(String data)
    {
        return data.substring(0, 1).toUpperCase() + data.substring(1).toLowerCase();
    }
}
