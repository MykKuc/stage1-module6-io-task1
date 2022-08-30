package com.epam.mjc.io;

import java.io.*;


public class FileReader {

    public Profile getDataFromFile(File file) {

        StringWriter myStringWriter = new StringWriter();

        try {
            BufferedReader myBufferedReader = new BufferedReader(new java.io.FileReader(file));
            String theInfo;
            while ((theInfo = myBufferedReader.readLine()) != null) {
                myStringWriter.write(theInfo);
            }
            myBufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String theDataFromMyStringWriter = myStringWriter.toString();
        System.out.println(theDataFromMyStringWriter);

        String theName = theDataFromMyStringWriter.substring(6, theDataFromMyStringWriter.indexOf("Age:"));
        System.out.println(theName);

        String theAge = theDataFromMyStringWriter.substring(theDataFromMyStringWriter.indexOf("Age:") + 5, theDataFromMyStringWriter.indexOf("Email:"));
        System.out.println(theAge);
        int theAgeAsAnInteger = Integer.parseInt(theAge);


        String theEmail = theDataFromMyStringWriter.substring(theDataFromMyStringWriter.indexOf("Email:") + 7, theDataFromMyStringWriter.indexOf("Phone:"));
        System.out.println(theEmail);

        String thePhoneNumber = theDataFromMyStringWriter.substring(theDataFromMyStringWriter.indexOf("Phone:") + 7, theDataFromMyStringWriter.length());
        System.out.println(thePhoneNumber);
        long phoneNumberAsLong = Long.parseLong(thePhoneNumber);

        return new Profile(theName,theAgeAsAnInteger,theEmail,phoneNumberAsLong);
    }

}
