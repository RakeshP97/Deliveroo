package com.deliveroo.service;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParseCronStringServiceImplTest {

    ParseCronStringServiceImpl parseCronString = new ParseCronStringServiceImpl();

    @Test
    public void testMinutesValue(){

        List<Integer> possibleValues = parseCronString.getThePossibleValues(60, "*/15", 0);
        assertEquals(4, possibleValues.size());

    }

    @Test
    public void testHoursValue(){
        List<Integer> possibleValues = parseCronString.getThePossibleValues(24, "0",0);
        assertEquals(1, possibleValues.size());

    }


    @Test
    public void testDayOfMonth(){
        List<Integer> possibleValues = parseCronString.getThePossibleValues(31, "1,15", 0);
        assertEquals(2, possibleValues.size());

    }

    @Test
    public void testMonths(){
        List<Integer> possibleValues = parseCronString.getThePossibleValues(12, "*",1);
        assertEquals(12, possibleValues.size());

    }

    @Test
    public void testDayOfTheWeek(){
        List<Integer> possibleValues = parseCronString.getThePossibleValues(12, "1-5",1);
        assertEquals(5, possibleValues.size());

    }
}
