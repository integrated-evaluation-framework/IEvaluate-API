package edu.mayo.dhs.ievaluate.api.models.baselines;

import edu.mayo.dhs.ievaluate.api.applications.ProfiledApplication;
import edu.mayo.dhs.ievaluate.api.models.tasks.ApplicationTask;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Represents an assertion made about an input that is stored as a ground truth
 * This assertion is determined by individual abstractor assertions who eventually reach a quorum
 */
public abstract class BaselineAssertion {
    protected UUID id;
    protected BaselineCohort baseline;
    protected ProfiledApplication application;
    protected ApplicationTask task;
    protected String input;
    protected Map<String, String> inputParams;
    protected List<AbstractorAssertion> assertions;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public BaselineCohort getBaseline() {
        return baseline;
    }

    public void setBaseline(BaselineCohort baseline) {
        this.baseline = baseline;
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

    public List<AbstractorAssertion> getAssertions() {
        return assertions;
    }

    public void setAssertions(List<AbstractorAssertion> assertions) {
        this.assertions = assertions;
    }
}
