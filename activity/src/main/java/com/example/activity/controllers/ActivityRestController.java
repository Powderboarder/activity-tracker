package com.example.activity.controllers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import java.util.List;
import java.util.stream.Collectors;
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
import com.example.activity.beans.Activity;
import com.example.activity.datasource.ActivityRepository;

@RestController
class ActivityRestController {

    private final ActivityRepository repository;

    ActivityRestController(ActivityRepository repository) {
        this.repository = repository;
    }

    /**
     * Pulls all values stored in the data repository
     * 
     * @return
     */
    @GetMapping("/activity")
    CollectionModel<EntityModel<Activity>> all() {

        List<EntityModel<Activity>> activityList = repository.findAll().stream()
                .map(activity -> EntityModel.of(activity,
                        linkTo(methodOn(ActivityRestController.class).one(activity.getActivityId())).withSelfRel(),
                        linkTo(methodOn(ActivityRestController.class).all()).withRel("activity")))
                .collect(Collectors.toList());

        return CollectionModel.of(activityList, linkTo(methodOn(ActivityRestController.class).all()).withSelfRel());
    }

    /**
     * Pulls specific entry in the data repository
     * 
     * @param id unique id of the activity
     * @return
     */
    @GetMapping("/activity/{id}")
    EntityModel<Activity> one(@PathVariable Long id) {

        Activity employee = repository.findById(id)
                .orElseThrow(() -> new ActivityNotFoundException(id));

        return EntityModel.of(employee,
                linkTo(methodOn(ActivityRestController.class).one(id)).withSelfRel(),
                linkTo(methodOn(ActivityRestController.class).all()).withRel("activity"));
    }

    /**
     * Create a new activity from JSON object
     * 
     * @param newActivity new activity details
     * @return
     */
    @PostMapping("/activity")
    Activity newActivity(@RequestBody Activity newActivity) {
        return repository.save(newActivity);
    }

    /**
     * Updates the values for an existing activity
     * 
     * @param newActivity
     * @param id
     * @return
     */
    @PutMapping("/activity/{id}")
    Activity replaceActivity(@RequestBody Activity newActivity, @PathVariable Long id) {

        return repository.findById(id)
                .map(activity -> {
                    activity.setActivityUserId(newActivity.getActivityUserId());
                    activity.setActivityType(newActivity.getActivityType());
                    activity.setActivityDate(newActivity.getActivityDate());
                    activity.setDurationInMinutes(newActivity.getDurationInMinutes());
                    activity.setDistance(newActivity.getDistance());
                    activity.setDistanceMeasurementType(newActivity.getDistanceMeasurementType());
                    return repository.save(activity);
                }) //
                .orElseGet(() -> {
                    return repository.save(newActivity);
                });
    }

    /**
     * Deletes an existing activity.
     * 
     * @param id
     */
    @DeleteMapping("/activity/{id}")
    void deleteActivity(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
