package com.example.activity.api.controllers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.activity.Exceptions.ActivityNotFoundException;
import com.example.activity.api.services.UserActivityService;
import com.example.activity.beans.Activity;
import com.example.activity.beans.UserActivitySummary;
import com.example.activity.dto.UserActivityServiceDTO;
import com.example.activity.testRepository.ActivityRepository;

@RestController
public class UserActivityRestController {
    private final ActivityRepository repository;

    UserActivityRestController(ActivityRepository repository) {
        this.repository = repository;
    }

    /**
     * Pulls all activities for a specified user.
     * 
     * @param activityUserId user id value
     * @return
     */
    @GetMapping("/userActivity/{activityUserId}/{fromDate}/{toDate}")
    List<Activity> getByUserDateRange(@PathVariable Long activityUserId,
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date fromDate,
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date toDate) {
        List<Activity> activityList = repository
                .findByActivityUserIdAndActivityDateBetween(activityUserId, fromDate, toDate);

        return activityList;
    }

    @GetMapping("/userActivitySummary/{activityUserId}/{fromDate}/{toDate}")
    List<UserActivitySummary> getSummaryByUserDateRange(@PathVariable Long activityUserId,
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date fromDate,
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date toDate) {
        UserActivityService userActivityService = new UserActivityService();
        List<UserActivitySummary> userActivitySummaryList = new ArrayList<UserActivitySummary>();
        List<Activity> activityList = repository
                .findByActivityUserIdAndActivityDateBetween(activityUserId, fromDate, toDate);

        UserActivityServiceDTO userActivityServiceDTO = new UserActivityServiceDTO();
        userActivityServiceDTO.setActivityUserId(activityUserId);
        userActivityServiceDTO.setSummaryStartDate(fromDate);
        userActivityServiceDTO.setSummaryEndDate(toDate);
        userActivityServiceDTO.setActivityList(activityList);
        userActivitySummaryList.addAll(userActivityService.getSummariesFromDateRange(userActivityServiceDTO));

        return userActivitySummaryList;
    }
}
