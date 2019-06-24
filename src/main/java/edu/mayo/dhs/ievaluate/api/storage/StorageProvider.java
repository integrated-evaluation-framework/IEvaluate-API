package edu.mayo.dhs.ievaluate.api.storage;

import com.fasterxml.jackson.databind.JsonNode;
import edu.mayo.dhs.ievaluate.api.applications.ProfiledApplication;
import edu.mayo.dhs.ievaluate.api.models.metrics.MetricDatapoint;
import edu.mayo.dhs.ievaluate.api.models.tasks.ApplicationTask;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Storage provider for serialization of application data
 */
public interface StorageProvider {
    /**
     * @return A mapping of {@link edu.mayo.dhs.ievaluate.api.applications.ProfiledApplication} class name to the
     * serialized representation from the respective {@link edu.mayo.dhs.ievaluate.api.applications.ApplicationProvider}
     */
    Map<String, JsonNode> loadRegisteredApplications();

    /**
     * Saves the current application manager and relevant states
     */
    void saveRegisteredApplications();

    /**
     * Retrieves a set of data points corresponding to the supplied parameters
     *
     * @param application The application to get metrics for
     * @param metricName  The metric name to get
     * @param task        The application task to generate metrics for
     * @param versions    The collection of versions of the application to get metrics for
     * @return An ordered collection of {@link MetricDatapoint}s in sequential (typically chronological) order
     */
    List<MetricDatapoint> getMetrics(ProfiledApplication application, String metricName, ApplicationTask task, Collection<String> versions);


    /**
     * Saves a collection of metric data points
     *
     * @param application The application the datapoints pertain to
     * @param task        The task the datapoints pertain to
     * @param metrics     A collection of data points corresponding to the provided application and task
     */
    void saveMetrics(ProfiledApplication application, ApplicationTask task, Collection<MetricDatapoint> metrics);
}
