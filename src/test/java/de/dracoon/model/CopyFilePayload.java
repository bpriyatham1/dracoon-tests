package de.dracoon.model;

import java.util.List;

/**
 * @author priyatham.bolli
 */
public class CopyFilePayload {

    private List<Item> items;
    private String resolutionStrategy;
    private Boolean keepShareLinks;

    public static final String RESOLUTION_STRATEGY = "autorename";

    public CopyFilePayload(List<Item> items) {
        this.items = items;
        this.keepShareLinks = false;
        this.resolutionStrategy = RESOLUTION_STRATEGY;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public String getResolutionStrategy() {
        return RESOLUTION_STRATEGY;
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
}
