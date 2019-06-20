package edu.mayo.dhs.ievaluate.api.models.jobs;

import edu.mayo.dhs.ievaluate.api.applications.ProfiledApplication;
import edu.mayo.dhs.ievaluate.api.models.baselines.BaselineCohort;
import edu.mayo.dhs.ievaluate.api.models.tasks.ApplicationTask;

import java.util.Collection;
import java.util.List;

/**
 * Handles all aspects of an {@link ApplicationJob} lifecycle
 */
public interface JobManager {
    /**
     * Starts a new job with the given application and version, and creates metrics from the provided baselines
     *
     * @param application The application to run
     * @param version     The version (typically numeric or some git commit hash) to identify the application version to
     *                    run
     * @param tasks       The tasks to generate evaluation metrics for
     * @param baselines   A collection of baselines to run against
     * @return The started job
     */
    ApplicationJob startNewJob(ProfiledApplication application, String version, Collection<ApplicationTask> tasks,
                               Collection<BaselineCohort> baselines);

    /**
     * @return A listing of currently active jobs
     */
    Collection<ApplicationJob> getActiveJobs();

    /**
     * @param application The application to get job history for
     * @return A chronologically ordered (most to least recent) listing of jobs ran for a given application
     */
    List<ApplicationJob> getJobHistory(ProfiledApplication application);

}
