package com.epam.mjc.io;

import java.io.*;


public class FileReader {

    public Profile getDataFromFile(File file) {

        StringWriter myStringWriter = new StringWriter();

        try (BufferedReader myBufferedReader = new BufferedReader(new java.io.FileReader(file))
        ) {
            String theInfo;
            while ((theInfo = myBufferedReader.readLine()) != null) {
                myStringWriter.write(theInfo);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String theDataFromMyStringWriter = myStringWriter.toString();

        String theName = theDataFromMyStringWriter.substring(6, theDataFromMyStringWriter.indexOf("Age:"));

        String theAge = theDataFromMyStringWriter.substring(theDataFromMyStringWriter.indexOf("Age:") + 5, theDataFromMyStringWriter.indexOf("Email:"));
        int theAgeAsAnInteger = Integer.parseInt(theAge);

        String theEmail = theDataFromMyStringWriter.substring(theDataFromMyStringWriter.indexOf("Email:") + 7, theDataFromMyStringWriter.indexOf("Phone:"));

        String thePhoneNumber = theDataFromMyStringWriter.substring(theDataFromMyStringWriter.indexOf("Phone:") + 7);
        long phoneNumberAsLong = Long.parseLong(thePhoneNumber);

        return new Profile(theName,theAgeAsAnInteger,theEmail,phoneNumberAsLong);
    }

}
