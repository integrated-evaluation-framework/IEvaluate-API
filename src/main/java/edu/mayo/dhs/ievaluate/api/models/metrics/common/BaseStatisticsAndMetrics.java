package edu.mayo.dhs.ievaluate.api.models.metrics.common;

import edu.mayo.dhs.ievaluate.api.applications.ApplicationAssertionCollection;
import edu.mayo.dhs.ievaluate.api.applications.ProfiledApplication;
import edu.mayo.dhs.ievaluate.api.models.baselines.BaselineCohort;
import edu.mayo.dhs.ievaluate.api.models.metrics.MetricDatapoint;
import edu.mayo.dhs.ievaluate.api.models.metrics.MetricProvider;
import edu.mayo.dhs.ievaluate.api.models.tasks.ApplicationTask;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Implements some basic statistics and metrics common in the AI domain.
 * While implementation might not be static, usage is common enough for inclusion in the API
 */
public final class BaseStatisticsAndMetrics extends MetricProvider {
    public static final String METRIC_TP = "TRUEPOS";
    public static final String METRIC_FP = "FALSEPOS";
    public static final String METRIC_FN = "FALSENEG";
    public static final String METRIC_RECALL = "RECALL";
    public static final String METRIC_PRECISION = "PRECISION";
    public static final String METRIC_F1 = "F1-SCORE";

    @Override
    public String[] providedMetrics() {
        return new String[]{METRIC_TP, METRIC_FP, METRIC_FN, METRIC_RECALL, METRIC_PRECISION, METRIC_F1};
    }

    @Override
    public Collection<MetricDatapoint> produceMetrics(ProfiledApplication application, String applicationVersion, ApplicationTask task, BaselineCohort cohort, Map<String, Double> comparatorStatistics) {
        Date measuredTime = new Date();
        Set<MetricDatapoint> ret = new HashSet<>();
        if (comparatorStatistics.containsKey(METRIC_TP)) {
            ret.add(new MetricDatapoint("True Positives", measuredTime, applicationVersion, comparatorStatistics.get(METRIC_TP)));
        }
        if (comparatorStatistics.containsKey(METRIC_FP)) {
            ret.add(new MetricDatapoint("False Positives", measuredTime, applicationVersion, comparatorStatistics.get(METRIC_FP)));
        }
        if (comparatorStatistics.containsKey(METRIC_FN)) {
            ret.add(new MetricDatapoint("False Negatives", measuredTime, applicationVersion, comparatorStatistics.get(METRIC_FN)));
        }
        if (comparatorStatistics.containsKey(METRIC_RECALL)) {
            ret.add(new MetricDatapoint("Recall", measuredTime, applicationVersion, comparatorStatistics.get(METRIC_RECALL)));
        }
        if (comparatorStatistics.containsKey(METRIC_PRECISION)) {
            ret.add(new MetricDatapoint("Precision", measuredTime, applicationVersion, comparatorStatistics.get(METRIC_PRECISION)));
        }
        if (comparatorStatistics.containsKey(METRIC_F1)) {
            ret.add(new MetricDatapoint("F1-Score", measuredTime, applicationVersion, comparatorStatistics.get(METRIC_F1)));
        }
        return ret;
    }

    @Override
    public void produceStatistics(ProfiledApplication application, String applicationVersion, ApplicationTask task, ApplicationAssertionCollection assertions, BaselineCohort cohort, Map<String, Double> prexisting) {
        AtomicReference<Double> tpRef = new AtomicReference<>(0.0);
        AtomicReference<Double> fpRef = new AtomicReference<>(0.0);
        // Generate an internal mapping of the specific task
        Map<AssertionSubjectDefinition, String> baselineAssertions = new HashMap<>();
        HashSet<AssertionSubjectDefinition> baselines = new HashSet<>(baselineAssertions.keySet());
        cohort.getItems().stream().filter(assertion -> assertion.getTask().equals(task)).forEach(a -> {
            AssertionSubjectDefinition subj = new AssertionSubjectDefinition(a.getInput(), a.getInputParams());
            // TODO support quorums, for now just pull the first
            String asserted = a.getAssertions().iterator().next().getAssertedValue();
            baselineAssertions.put(subj, asserted);
        });
        assertions.getItems()
                .stream()
                .filter(assertion -> assertion.getTask().equals(task))
                .forEach(a -> {
                    AssertionSubjectDefinition subj = new AssertionSubjectDefinition(a.getInput(), a.getInputParams());
                    baselines.remove(subj);
                    String gold = baselineAssertions.get(subj);
                    if (gold == null) { // False positive
                        fpRef.accumulateAndGet(1.0, Double::sum);
                    } else {
                        if (gold.equals(a.getAssertedValue())) {
                            tpRef.accumulateAndGet(1.0, Double::sum);
                        }
                    }
                });
        double tp = tpRef.get();
        double fp = fpRef.get();
        double fn = baselines.size();
        double recall = tp / (tp + fn);
        double precision = tp / (tp + fp);
        prexisting.put(METRIC_TP, tp);
        prexisting.put(METRIC_FP, fp);
        prexisting.put(METRIC_FN, fn);
        prexisting.put(METRIC_RECALL, recall);
        prexisting.put(METRIC_PRECISION, precision);
        prexisting.put(METRIC_F1, 2 * ((precision * recall) / (precision + recall)));
    }

    private class AssertionSubjectDefinition {
        private String input;
        private Map<String, String> inputParams;

        private AssertionSubjectDefinition(String input, Map<String, String> inputParams) {
            this.input = input;
            this.inputParams = inputParams == null || inputParams.isEmpty() ? null : inputParams; // ensure empty is stored as null for memory
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            AssertionSubjectDefinition that = (AssertionSubjectDefinition) o;
            return Objects.equals(input, that.input) &&
                    Objects.equals(inputParams, that.inputParams);
        }

        @Override
        public int hashCode() {
            return Objects.hash(input, inputParams);
        }
    }

}
