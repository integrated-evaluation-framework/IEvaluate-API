package edu.mayo.dhs.ievaluate.api.models.baselines;

import java.util.List;
import java.util.UUID;

/**
 * Represents a cohort against which an application should be profiled to obtain performance metrics
 */
public abstract class BaselineCohort {
    protected UUID id;
    protected String name;
    protected List<BaselineAssertion> items;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BaselineAssertion> getItems() {
        return items;
    }

    public void setItems(List<BaselineAssertion> items) {
        this.items = items;
    }
}
