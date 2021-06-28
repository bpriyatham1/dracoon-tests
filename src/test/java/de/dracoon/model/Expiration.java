package de.dracoon.model;

/**
 * @author priyatham.bolli
 */
public class Expiration {

    private String expireAt;
    private Boolean enableExpiration;

    public Expiration(String expireAt, Boolean enableExpiration) {
        this.expireAt = expireAt;
        this.enableExpiration = enableExpiration;
    }

    public String getExpireAt() {
        return expireAt;
    }

    public void setExpireAt(String expireAt) {
        this.expireAt = expireAt;
    }

    public Boolean getEnableExpiration() {
        return enableExpiration;
    }

    public void setEnableExpiration(Boolean enableExpiration) {
        this.enableExpiration = enableExpiration;
    }

}
