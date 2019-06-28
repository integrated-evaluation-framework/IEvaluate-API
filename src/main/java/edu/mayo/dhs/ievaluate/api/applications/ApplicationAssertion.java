package edu.mayo.dhs.ievaluate.api.applications;

import edu.mayo.dhs.ievaluate.api.models.assertions.AssertionDefinition;
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
    protected ProfiledApplication application;
    protected ApplicationTask task;
    protected Date assertionDtm;
    protected String applicationVersion;
    protected String input;
    protected Map<String, String> inputParams;
    protected Map<String, String> assertedValue;
    protected List<String> applicationDiagnostics;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public ProfiledApplication getApplication() {
        return application;
    }

    public void setApplication(ProfiledApplication application) {
        this.application = application;
    }

    public ApplicationTask getTask() {
        return task;
    }

    public void setTask(ApplicationTask task) {
        this.task = task;
    }

    public Date getAssertionDtm() {
        return assertionDtm;
    }

    public void setAssertionDtm(Date assertionDtm) {
        this.assertionDtm = assertionDtm;
    }

    public String getApplicationVersion() {
        return applicationVersion;
    }

    public void setApplicationVersion(String applicationVersion) {
        this.applicationVersion = applicationVersion;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public Map<String, String> getInputParams() {
        return inputParams;
    }

    public void setInputParams(Map<String, String> inputParams) {
        this.inputParams = inputParams;
    }

    public Map<String, String> getAssertedValue() {
        return assertedValue;
    }

    public void setAssertedValue(Map<String, String> assertedValue) {
        this.assertedValue = assertedValue;
    }

    public List<String> getApplicationDiagnostics() {
        return applicationDiagnostics;
    }

    public void setApplicationDiagnostics(List<String> applicationDiagnostics) {
        this.applicationDiagnostics = applicationDiagnostics;
    }

    /**
     * Used to force implementations to define an equals method, with the same contract
     *
     * @param other The other assert
     * @return true if these two items are the same
     * @see Object#equals(Object)
     */
    public abstract boolean matches(ApplicationAssertion other);

    /**
     * Used to force implementations to define a hash method, with the same contract
     *
     * @return A hash code corresponding to this object
     * @see Object#hashCode()
     */
    public abstract int toHash();

    @Override
    public final int hashCode() {
        return toHash();
    }

    @Override
    public final boolean equals(Object other) {
        return other instanceof ApplicationAssertion && matches((ApplicationAssertion) other);
    }
}
