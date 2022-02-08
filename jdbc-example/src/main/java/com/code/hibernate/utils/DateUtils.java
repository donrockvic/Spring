package com.code.hibernate.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    private static SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

    public static Date parseDate(String dateStr) throws ParseException {
        Date theDate = format.parse(dateStr);
        return theDate;
    }

    public static String formatDate(Date theDate){
        String result = null;

        if(theDate != null)
            result  = format.format(theDate);

        return result;
    }

}
