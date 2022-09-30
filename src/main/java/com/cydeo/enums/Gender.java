package com.cydeo.enums;

public enum Gender {
    MALE("Male"), FEMALE("Female");//assign as enum value // if is job in progress can't be constant

   private String value;//field

    Gender(String value) {//constructor
        this.value = value;
    }

    public String getValue() {//and getter because is private value
        return value;
    }
}
