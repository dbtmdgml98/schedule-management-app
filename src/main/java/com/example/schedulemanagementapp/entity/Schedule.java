package com.example.schedulemanagementapp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Schedule {

    private Long id;
    private String thingsToDo;
    private String name;
    private String password;
    private String dateOfWriting;
    private String dateOfUpdating;

}
