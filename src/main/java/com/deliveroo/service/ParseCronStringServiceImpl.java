package com.deliveroo.service;


import com.deliveroo.data.FieldData;

import java.util.ArrayList;
import java.util.List;

public class ParseCronStringServiceImpl {

    public static final String SINGLE_SPACE = " ";

    public static final String STAR_SYMBOL = "*";

    public static final String SLASH_SYMBOL = "/";

    public static final String DASH_SYMBOL = "-";

    public static final String COMMA_SYMBOL = ",";

    public static final String COMMAND = "command";

    /**
     * Prints the possible for the given input value.
     *
     * @param cronString
     * @param possibleStrings
     */

    public void parseString(final String cronString, List<FieldData> possibleStrings) {

        if (cronString == null || cronString.isEmpty()) {
            return;
        } else {
            String[] cronFields = cronString.split(SINGLE_SPACE);
            int i = 0;
            for (String cronField : cronFields) {
                FieldData fieldData = possibleStrings.get(i);
                StringBuffer paddedField = new StringBuffer(String.format("%-14s", fieldData.getFieldName()));
                if (fieldData.getFieldName().equals(COMMAND)) {
                    paddedField.append(cronField);
                } else {
                    List<Integer> possibleValues = getThePossibleValues(fieldData.getMaxValue(),
                            cronField, fieldData.getStartValue());
                    for (Integer val : possibleValues) {
                        paddedField.append(val + SINGLE_SPACE);
                    }
                }
                System.out.println(new String(paddedField).trim());
                i++;
            }
        }
    }

    /**
     * Calculate the possible for the given input.
     *
     * @param maxvalue
     * @param cronField
     * @param startValue
     * @return List of possible values.
     */

    public List<Integer> getThePossibleValues(final int maxvalue,
                                              final String cronField, final int startValue) {

        List<Integer> possibleValues = new ArrayList<>();
        if (cronField.contains(STAR_SYMBOL)) {
            if (cronField.contains(SLASH_SYMBOL)) {
                int divisorValue = Integer.parseInt(cronField.substring(cronField.indexOf(SLASH_SYMBOL) + 1));
                int total = maxvalue / divisorValue;
                for (int i = 0; i < total; i++) {
                    possibleValues.add(divisorValue * i);
                }
            } else {
                int total = maxvalue + startValue;
                for (int i = startValue; i < total; i++) {
                    possibleValues.add(i);
                }
            }
        } else if (cronField.contains("-")) {
            int firstDay = Integer.parseInt(cronField.substring(0, cronField.indexOf(DASH_SYMBOL)));
            int endDay = Integer.parseInt(cronField.substring(cronField.indexOf(DASH_SYMBOL) + 1));
            for (int i = firstDay; i <= endDay; i++) {
                possibleValues.add(i);
            }


        } else if (cronField.contains(COMMA_SYMBOL)) {
            String[] s = cronField.split(COMMA_SYMBOL);
            for (int i = 0; i < s.length; i++) {
                possibleValues.add(Integer.parseInt(s[i]));
            }
        } else {
            possibleValues.add(Integer.parseInt(cronField));
        }
        return possibleValues;
    }
}
