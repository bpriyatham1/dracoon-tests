package de.dracoon.model;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author priyatham.bolli
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FolderPayload {

    private Long parentId;
    private String name;

    public FolderPayload(Long parentId, String name) {
        this.parentId = parentId;
        this.name = name;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

