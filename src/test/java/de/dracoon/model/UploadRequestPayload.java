package de.dracoon.model;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author priyatham.bolli
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UploadRequestPayload {

    public UploadRequestPayload() {
        this.resolutionStrategy = "fail";
        this.keepShareLinks = false;
    }

    public String resolutionStrategy;
    public Boolean keepShareLinks;
    public String fileName;
    public FileKey fileKey;
    public UserFileKeyList userFileKeyList;

    public String getResolutionStrategy() {
        return resolutionStrategy;
    }

    public void setResolutionStrategy(String resolutionStrategy) {
        this.resolutionStrategy = resolutionStrategy;
    }

    public Boolean getKeepShareLinks() {
        return keepShareLinks;
    }

    public void setKeepShareLinks(Boolean keepShareLinks) {
        this.keepShareLinks = keepShareLinks;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public FileKey getFileKey() {
        return fileKey;
    }

    public void setFileKey(FileKey fileKey) {
        this.fileKey = fileKey;
    }

    public UserFileKeyList getUserFileKeyList() {
        return userFileKeyList;
    }

    public void setUserFileKeyList(UserFileKeyList userFileKeyList) {
        this.userFileKeyList = userFileKeyList;
    }
}
