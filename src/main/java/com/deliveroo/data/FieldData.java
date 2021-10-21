package com.deliveroo.data;

public class FieldData {

    String fieldName;
    int maxValue;
    int startValue;

    public FieldData(String fieldName, int maxValue, int startValue) {
        this.fieldName = fieldName;
        this.maxValue = maxValue;
        this.startValue = startValue;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    public int getStartValue() {
        return startValue;
    }

    public void setStartValue(int startValue) {
        this.startValue = startValue;
    }
}
