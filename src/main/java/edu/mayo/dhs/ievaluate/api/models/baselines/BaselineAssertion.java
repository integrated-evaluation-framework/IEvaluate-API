package edu.mayo.dhs.ievaluate.api.models.baselines;

import edu.mayo.dhs.ievaluate.api.ProfiledApplication;
import edu.mayo.dhs.ievaluate.api.models.tasks.PipelineTask;

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
    protected PipelineTask task;
    protected String input;
    protected Map<String, String> inputParams;
    protected List<AbstractorAssertion> assertions;
}
