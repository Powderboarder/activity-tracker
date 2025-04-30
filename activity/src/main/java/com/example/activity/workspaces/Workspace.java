package com.example.activity.workspaces;

import java.time.ZonedDateTime;
import java.util.Date;

/**
 * This is a workspace that will link users together for competition, and motivation.
 */
public class Workspace {
    private Integer workspaceId = null;
    private boolean isAllowedTeams = false;
    private ZonedDateTime expirationDate = null;
    private Integer createdByUserId = null;
    private Date createDate = null;

    /**
     * Potential to add additional tracking for prize based competitions.
     */
}
