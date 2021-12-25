package com.budgetfriendly.bms.common;

import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.Date;

@Component
public class CommonLogics {

    public Date getBirthDate(Date dob) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String date = format.format(dob);
        Date birth = format.parse(date);
        return birth;
    }

    public int getAge(Date dob){
        int age = 0;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String date = format.format(dob);
        LocalDate currentDate = LocalDate.parse(date);
        int day = currentDate.getDayOfMonth();
        Month month = currentDate.getMonth();
        int year = currentDate.getYear();
        LocalDate today = LocalDate.now();
        LocalDate birthday = LocalDate.of(year, month, day);
        Period p = Period.between(birthday, today);
         age = p.getYears();
        return age;
    }



}
