package edu.mayo.dhs.ievaluate.api.models.metrics;

import edu.mayo.dhs.ievaluate.api.applications.ApplicationAssertionCollection;
import edu.mayo.dhs.ievaluate.api.applications.ProfiledApplication;
import edu.mayo.dhs.ievaluate.api.models.baselines.BaselineCohort;
import edu.mayo.dhs.ievaluate.api.models.tasks.ApplicationTask;

import java.util.Collection;
import java.util.Map;

/**
 * Produces {@link MetricDatapoint}s for a given application and task
 */
public abstract class MetricProvider {

    /**
     * @return The metric names with which to associate this provider
     */
    public abstract String[] providedMetrics();

    /**
     * @param application          The application to produce metrics for
     * @param applicationVersion   The version of the application
     * @param task                 The task to produce metrics for
     * @param cohort               The gold standard cohort
     * @param comparatorStatistics The statistics generated from {@link #produceStatistics(ProfiledApplication, String, ApplicationTask, ApplicationAssertionCollection, BaselineCohort, Map)}
     *                             for this task and baseline cohort
     * @return A datapoint corresponding to this metric generated from the supplied cohort and task.
     */
    public abstract Collection<MetricDatapoint> produceMetrics(ProfiledApplication application, String applicationVersion, ApplicationTask task, BaselineCohort cohort, Map<String, Double> comparatorStatistics);

    /**
     * Updates an input modifiable map with statistics derived from comparing two collection sets
     *
     * @param application        The application to produce statistics for
     * @param applicationVersion The version of the application
     * @param task               The task to evaluate
     * @param assertions         Application assertion collection
     * @param cohort             The cohort to compare against
     * @param prexisting         Any statistics already generated prior to this provider
     */
    public abstract void produceStatistics(ProfiledApplication application, String applicationVersion, ApplicationTask task, ApplicationAssertionCollection assertions, BaselineCohort cohort, Map<String, Double> prexisting);
}
