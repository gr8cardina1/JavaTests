package com.example.demo.utils;

import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class DateUtils {
    final String DATE_PATTERN="yyyy-MM-dd";

    public Boolean isFutureDate (String inDate) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat(DATE_PATTERN);
        String currentDate = dateFormat.format( new Date());

        SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN);
        Date date1 = sdf.parse(inDate);
        Date date2 = sdf.parse(currentDate);

        return date1.after(date2);
    }
}
