package de.dracoon.staticdata;

/**
 * @author priyatham.bolli
 */
public enum RestParameters {

    USER_ID("user_id"),
    NODE_ID("node_id"),
    TOKEN("token"),
    UUID("uuid");

    private final String parameterName;

    RestParameters(String parameterName) {
        this.parameterName = parameterName;
    }

    public String getParameterName() {
        return parameterName;
    }

}
