package de.dracoon.model;

import java.util.List;

/**
 * @author priyatham.bolli
 */
public class Node {

    private String name;
    private Boolean inheritPermissions;
    private List<Long> adminIds;

    public Node(String name, List<Long> adminIds) {
        this.name = name;
        this.inheritPermissions = false;
        this.adminIds = adminIds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getInheritPermissions() {
        return inheritPermissions;
    }

    public void setInheritPermissions(Boolean inheritPermissions) {
        this.inheritPermissions = inheritPermissions;
    }

    public List<Long> getAdminIds() {
        return adminIds;
    }

    public void setAdminIds(List<Long> adminIds) {
        this.adminIds = adminIds;
    }
}
