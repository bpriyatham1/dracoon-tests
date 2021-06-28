package de.dracoon.model;

/**
 * @author priyatham.bolli
 */
public final class Items {

    private Integer UserId;
    private FileKey fileKey;

    public Items() {
    }

    public Integer getUserId() {
        return UserId;
    }

    public void setUserId(Integer userId) {
        UserId = userId;
    }

    public FileKey getFileKey() {
        return fileKey;
    }

    public void setFileKey(FileKey fileKey) {
        this.fileKey = fileKey;
    }
}
