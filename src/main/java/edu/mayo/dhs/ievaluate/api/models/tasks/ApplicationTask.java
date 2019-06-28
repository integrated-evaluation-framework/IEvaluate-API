package edu.mayo.dhs.ievaluate.api.models.tasks;

import edu.mayo.dhs.ievaluate.api.models.assertions.AssertionDefinition;

import java.util.UUID;

public abstract class ApplicationTask {

    protected UUID taskUID = UUID.randomUUID();

    public abstract String getName();

    public abstract Class<? extends AssertionDefinition> getTaskAssertionDef();

    public UUID getTaskUID() {
        return taskUID;
    }

    public void setTaskUID(UUID taskUID) {
        this.taskUID = taskUID;
    }
}
