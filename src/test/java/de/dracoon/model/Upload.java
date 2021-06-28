package de.dracoon.model;

/**
 * @author priyatham.bolli
 */
public class Upload {

    private String token;
    private String uploadId;
    private String uploadUrl;

    Upload(){
    }

    public Upload(String token, String uploadId, String uploadUrl) {
        this.token = token;
        this.uploadId = uploadId;
        this.uploadUrl = uploadUrl;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUploadId() {
        return uploadId;
    }

    public void setUploadId(String uploadId) {
        this.uploadId = uploadId;
    }

    public String getUploadUrl() {
        return uploadUrl;
    }

    public void setUploadUrl(String uploadUrl) {
        this.uploadUrl = uploadUrl;
    }

}
