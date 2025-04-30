package com.example.activity.workspaces.permissions;

import java.util.List;

/**
 * Holds information for maintainers of workspace group.
 */
public class UserWorkspacePermission {
    private Integer workspaceUserPermissionId = null;
    private Integer workspaceId = null;
    private Integer userId = null;
    private Integer roleId = null;
    private List<WorkspacePermissions> permissionOverrideList = null;
}
