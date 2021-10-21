package com.deliveroo;

import com.deliveroo.data.FieldData;
import com.deliveroo.service.ParseCronStringServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class ParseCronStringApplication {


    public static void main(String[] args) {
        String cronString = null;
        if (args.length > 0) {
            cronString = args[0];
        }
        List<FieldData> possibleDetails = new ArrayList<>();
        possibleDetails.add(new FieldData("minute", 60, 0));
        possibleDetails.add(new FieldData("hour", 24, 0));
        possibleDetails.add(new FieldData("day of month", 31, 1));
        possibleDetails.add(new FieldData("month", 12, 1));
        possibleDetails.add(new FieldData("day of week", 7, 1));
        possibleDetails.add(new FieldData("command", 0, 0));
        ParseCronStringServiceImpl parseCronString = new ParseCronStringServiceImpl();
        parseCronString.parseString(cronString, possibleDetails);

    }
}
