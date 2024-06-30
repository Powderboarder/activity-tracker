package com.example.activity.Exceptions;

public class ActivityNotFoundException extends RuntimeException {
    public ActivityNotFoundException(final Long id) {
		super("Could not find activity " + id);
	}
}
