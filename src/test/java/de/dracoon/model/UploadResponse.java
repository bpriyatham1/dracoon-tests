package de.dracoon.model;

/**
 * @author priyatham.bolli
 */
public final class UploadResponse {

    public UploadResponse() {
    }

    public Integer size;
    public String hash;

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

}
