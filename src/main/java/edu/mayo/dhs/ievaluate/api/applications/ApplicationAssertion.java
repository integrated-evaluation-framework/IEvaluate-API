package edu.mayo.dhs.ievaluate.api.applications;

import edu.mayo.dhs.ievaluate.api.models.tasks.ApplicationTask;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Represents an assertion made by an application in relation to a certain task
 */
public abstract class ApplicationAssertion {
    protected UUID id;
    protected ApplicationTask task;
    protected Date assertionDtm;
    protected String applicationVersion;
    protected String input;
    protected Map<String, String> inputParams;
    protected List<String> applicationDiagnostics;
}
