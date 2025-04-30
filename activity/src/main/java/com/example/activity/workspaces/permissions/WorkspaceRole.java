package com.example.activity.workspaces.permissions;

import java.util.List;

/**
 * Roles within workspace to make maintenance easier across multiple lead users.
 */
public class WorkspaceRole {
    private Integer roleId = null;
    private String name = null;
    private boolean isDefaultRole = false;
    private List<WorkspacePermissions> permissionList = null;
}
