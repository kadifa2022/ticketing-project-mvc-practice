package com.cydeo.enums;

public enum Status {
    OPEN("Open"), IN_PROGRESS("In Progress"), COMPLETE("Completed");

    private final String projectStatus;


    Status(String projectStatus) {
        this.projectStatus = projectStatus;

    }

    public String getProjectStatus() {
        return projectStatus;
    }
}

