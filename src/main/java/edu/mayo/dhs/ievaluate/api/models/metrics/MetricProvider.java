package edu.mayo.dhs.ievaluate.api.models.metrics;

import edu.mayo.dhs.ievaluate.api.applications.ApplicationAssertionCollection;
import edu.mayo.dhs.ievaluate.api.models.baselines.BaselineCohort;
import edu.mayo.dhs.ievaluate.api.models.tasks.ApplicationTask;

/**
 * Produces {@link MetricDatapoint} for a given application and task
 */
public abstract class MetricProvider {
    /**
     * @param task The task to produce metrics for
     * @param assertions The assertions made by the
     * @param cohort The baseline cohort the metrics should be generate from
     * @return A datapoint corresponding to this metric generated from the supplied cohort and task.
     */
    public abstract MetricDatapoint produceMetrics(ApplicationTask task, ApplicationAssertionCollection assertions, BaselineCohort cohort);
}
