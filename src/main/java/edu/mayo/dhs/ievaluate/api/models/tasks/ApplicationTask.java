package edu.mayo.dhs.ievaluate.api.models.tasks;

import edu.mayo.dhs.ievaluate.api.models.assertions.AssertionDefinition;

public abstract class ApplicationTask {

    public abstract String getName();

    public abstract Class<? extends AssertionDefinition> getTaskAssertionDef();

}
