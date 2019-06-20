package edu.mayo.dhs.ievaluate.api.models.jobs;

import java.util.UUID;

/**
 * Represents a currently executing job - typically triggered via a git webhook or similar
 */
public abstract class ApplicationJob {
    /**
     * A unique identifier for this job
     */
    protected UUID jobUID;

    /**
     * The unique identifier of the {@link edu.mayo.dhs.ievaluate.api.applications.ProfiledApplication} to which this
     * job pertains
     */
    protected UUID applicationUID;

    /**
     * The version of the application being run for this job. Typically, a git commit hash or something similar
     */
    protected String applicationVersion;

    /**
     * The current job stage
     */
    protected JobStage stage;


    public UUID getJobUID() {
        return jobUID;
    }

    public void setJobUID(UUID jobUID) {
        this.jobUID = jobUID;
    }

    public UUID getApplicationUID() {
        return applicationUID;
    }

    public void setApplicationUID(UUID applicationUID) {
        this.applicationUID = applicationUID;
    }

    public String getApplicationVersion() {
        return applicationVersion;
    }

    public void setApplicationVersion(String applicationVersion) {
        this.applicationVersion = applicationVersion;
    }

    public JobStage getStage() {
        return stage;
    }

    public void setStage(JobStage stage) {
        this.stage = stage;
    }

    public boolean isCompleted() {
        return stage.equals(JobStage.COMPLETE) || stage.equals(JobStage.ERROR);
    }

    public boolean isCompletedExceptionally() {
        return stage.equals(JobStage.ERROR);
    }

    public enum JobStage {
        /**
         * Compilation Stage: compile the pipeline via Maven/SBT/gem/etc. or some CI
         */
        COMPILE,
        /**
         * Deployment Stage: Deploy compiled pipeline to some container (VM, HPC Cluster, etc.) that can run the job
         */
        DEPLOY,
        /**
         * Execution Stage: Pipeline is generating new results for baselines
         */
        EXECUTE,
        /**
         * Evaluation Stage: Generating application metrics
         */
        EVALUATE,
        /**
         * Execution Complete
         */
        COMPLETE,
        /**
         * Error Stage: an error occurred during job processing
         */
        ERROR
    }
}
