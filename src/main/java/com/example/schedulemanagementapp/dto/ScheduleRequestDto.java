package com.example.schedulemanagementapp.dto;

import lombok.Getter;

@Getter
public class ScheduleRequestDto {

    private String thingsToDo;
    private String name;
    private String password;
    private String dateOfWriting;
    private String dateOfUpdating;
}
