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
     * The application version
     */
    private String applicationVersion;

    /**
     * The value assigned to this metric at {@link #measuredTime}
     */
    private double value;

    public MetricDatapoint() {}

    public MetricDatapoint(String name, Date measuredTime, String applicationVersion, double value) {
        this.name = name;
        this.measuredTime = measuredTime;
        this.applicationVersion = applicationVersion;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getMeasuredTime() {
        return measuredTime;
    }

    public void setMeasuredTime(Date measuredTime) {
        this.measuredTime = measuredTime;
    }

    public String getApplicationVersion() {
        return applicationVersion;
    }

    public void setApplicationVersion(String applicationVersion) {
        this.applicationVersion = applicationVersion;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
