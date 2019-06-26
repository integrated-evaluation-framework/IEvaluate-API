package edu.mayo.dhs.ievaluate.api.models.baselines;

import java.util.Map;
import java.util.UUID;

/**
 * Represents an (output) assertion made by an abstractor
 */
public abstract class AbstractorAssertion {
    protected UUID id;
    protected UUID abstractorUID;
    protected Map<String, String> assertedValue;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getAbstractorUID() {
        return abstractorUID;
    }

    public void setAbstractorUID(UUID abstractorUID) {
        this.abstractorUID = abstractorUID;
    }

    public Map<String, String> getAssertedValue() {
        return assertedValue;
    }

    public void setAssertedValue(Map<String, String> assertedValue) {
        this.assertedValue = assertedValue;
    }
}
