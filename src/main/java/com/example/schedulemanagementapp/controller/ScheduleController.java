package com.example.schedulemanagementapp.controller;

import com.example.schedulemanagementapp.dto.ScheduleRequestDto;
import com.example.schedulemanagementapp.dto.ScheduleResponseDto;
import com.example.schedulemanagementapp.entity.Schedule;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/schedules")
public class ScheduleController {

    // 자료 구조가 DB 역할 수행
    private final Map<Long, Schedule> scheduleList = new HashMap<>();

    // 일정 생성
    @PostMapping
    public ScheduleResponseDto createSchedule(@RequestBody ScheduleRequestDto dto) {

        // 식별자가 1씩 증가하도록 만듦
        Long scheduleId = scheduleList.isEmpty() ? 1 : Collections.max(scheduleList.keySet()) + 1;

        // 요청받은 데이터로 Schedule 객체 생성
        Schedule schedule = new Schedule(scheduleId, dto.getThingsToDo(), dto.getName(), dto.getPassword(), dto.getDateOfWriting(), dto.getDateOfUpdating());

        // Inmemory DB에 Schedule 저장
        scheduleList.put(scheduleId, schedule);

        return new ScheduleResponseDto(schedule);
    }

    // 일정 조회
    @GetMapping("/{id}")
    public  ScheduleResponseDto findScheduleById(@PathVariable Long id) {

        Schedule schedule = scheduleList.get(id);

        return new ScheduleResponseDto(schedule);
    }

}