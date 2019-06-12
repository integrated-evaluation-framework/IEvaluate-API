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
}
