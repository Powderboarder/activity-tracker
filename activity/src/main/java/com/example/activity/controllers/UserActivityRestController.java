package com.example.activity.controllers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.activity.achievements.Achievement;
import com.example.activity.achievements.AchievementBO;
import com.example.activity.beans.Activity;
import com.example.activity.datasource.ActivityRepository;
import com.example.activity.dto.UserActivityServiceDTO;
import com.example.activity.services.UserActivityService;
import com.example.activity.usersummary.UserActivitySummary;

@RestController
public class UserActivityRestController {
    private final ActivityRepository repository;

    UserActivityRestController(final ActivityRepository repository)
    {
        this.repository = repository;
    }

    /**
     * Pulls all activities for a specified user.
     * 
     * @param activityUserId user id value
     * @return
     */
    @GetMapping("/userActivity/{activityUserId}")
    CollectionModel<EntityModel<Activity>> getByUser(@PathVariable final Long activityUserId) {
        final List<EntityModel<Activity>> activityList = repository.findByActivityUserId(activityUserId).stream()
                .map(activity -> EntityModel.of(activity,
                        linkTo(methodOn(ActivityRestController.class).one(activity.getActivityId())).withSelfRel(),
                        linkTo(methodOn(ActivityRestController.class).all()).withRel("userActivity")))
                .collect(Collectors.toList());

        return CollectionModel.of(activityList,
                linkTo(methodOn(UserActivityRestController.class).getByUser(activityUserId)).withSelfRel());
    }

    /**
     * Pulls all activities for a specified user.
     * 
     * @param activityUserId user id value
     * @return
     */
    @GetMapping("/userActivity/{activityUserId}/{fromDate}/{toDate}")
    List<Activity> getByUserDateRange(@PathVariable final Long activityUserId,
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") final Date fromDate,
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") final Date toDate)
    {
        final List<Activity> activityList = repository
                .findByActivityUserIdAndActivityDateBetween(activityUserId, fromDate, toDate);

        return activityList;
    }

    @GetMapping("/userActivitySummary")
    UserActivityServiceDTO getSummaryByUserDateRange(
            @RequestBody final UserActivityServiceDTO userActivityServiceDTO)
    {
        final AchievementBO achievementBO = new AchievementBO();
        final UserActivityService userActivityService = new UserActivityService();

        final List<Activity> activityList = repository.findByActivityUserIdAndActivityDateBetween(
                userActivityServiceDTO.getActivityUserId(),
                userActivityServiceDTO.getSummaryStartDate(),
                userActivityServiceDTO.getSummaryEndDate());
        userActivityServiceDTO.setActivityList(activityList);

        final List<UserActivitySummary> userActivitySummaryList = new ArrayList<UserActivitySummary>();
        userActivitySummaryList
                .addAll(userActivityService.getSummariesFromDateRange(userActivityServiceDTO));
        userActivityServiceDTO.setActivitySummaryList(userActivitySummaryList);

        final List<Achievement> achievementList = achievementBO.getAchievements(userActivitySummaryList);
        userActivityServiceDTO.setAchievementList(achievementList);

        return userActivityServiceDTO;
    }
}
