package edu.mayo.dhs.ievaluate.api.models.assertions;

/**
 * Defines what to expect from an assertion and how to compare its inputs and outputs
 */
public abstract class AssertionDefinition {
    public abstract Class<? extends AssertionInput> getInputType();
    public abstract Class<? extends AssertionOutput> getOutputType();
}
