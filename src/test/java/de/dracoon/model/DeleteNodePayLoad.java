package de.dracoon.model;

import java.util.List;

/**
 * @author priyatham.bolli
 */
public class DeleteNodePayLoad {

    private DeleteNodePayLoad(){
    }

    private List<Integer> nodeIds;

    public DeleteNodePayLoad(List<Integer> nodeIds) {
        this.nodeIds = nodeIds;
    }

    public List<Integer> getNodeIds() {
        return nodeIds;
    }

    public void setNodeIds(List<Integer> nodeIds) {
        this.nodeIds = nodeIds;
    }
}
