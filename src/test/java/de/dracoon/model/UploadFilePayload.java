package de.dracoon.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.Instant;

/**
 * @author priyatham.bolli
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UploadFilePayload {

    private String name;
    private Long size;
    private Integer parentId;
    private String timestampCreation;
    private String timestampModification;

    public UploadFilePayload(String name, Long size, Integer parentId) {
        this.name = name;
        this.size = size;
        this.parentId = parentId;
        this.timestampCreation = Instant.now().toString();
        this.timestampModification = Instant.now().toString();
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getTimestampCreation() {
        return timestampCreation;
    }

    public void setTimestampCreation(String timestampCreation) {
        this.timestampCreation = timestampCreation;
    }

    public String getTimestampModification() {
        return timestampModification;
    }

    public void setTimestampModification(String timestampModification) {
        this.timestampModification = timestampModification;
    }
}
