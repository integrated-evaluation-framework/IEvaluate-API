package edu.mayo.dhs.ievaluate.api.models.metrics;

import java.util.Date;

/**
 * Output Evaluation Metrics for Tasks
 */
public final class MetricDatapoint {

    /**
     * The name of the metric
     */
    private String name;

    /**
     * The date at which the metric was measured
     */
    private Date measuredTime;

    /**
     * The value assigned to this metric at {@link #measuredTime}
     */
    private double value;
}
