package com.cydeo.enums;

public enum Gender {
    MALE("Male"), FEMALE("Female");//assign as value in enum constant

   private String value;//to get the value we need constructor and getter

    Gender(String value) {//constructor
        this.value = value;
    }

    public String getValue() {//and getter because is private value
        return value;
    }
}
