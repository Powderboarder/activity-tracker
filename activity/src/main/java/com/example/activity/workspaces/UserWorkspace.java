package com.example.activity.workspaces;

import java.time.ZonedDateTime;

/**
 * User association to a workspace, and potential team in workspace.
 */
public class UserWorkspace {
    private Integer userId = null;
    private Integer workspaceId = null;
    private Integer teamId = null;
    private ZonedDateTime joinDate = null;
}
