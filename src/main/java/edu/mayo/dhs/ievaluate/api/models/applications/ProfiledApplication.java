package edu.mayo.dhs.ievaluate.api.models.applications;

import edu.mayo.dhs.ievaluate.api.models.tasks.ApplicationTask;

import java.util.List;
import java.util.UUID;

/**
 * Implementations define applications that are to be profiled/evaluated within the framework
 */
public abstract class ProfiledApplication {
    /**
     * A unique identifier for this application
     */
    protected UUID id;

    /**
     * A user-friendly name for this application
     */
    protected String name;

    /**
     * A description of this application
     */
    protected String description;

    /**
     * A list of {@link ApplicationTask} that define what assertion tasks this application can perform
     * (and thus what ought to be evaluated)
     */
    protected List<ApplicationTask> tasks;



}
