package edu.mayo.dhs.ievaluate.api.models.baselines;

import java.util.UUID;

/**
 * Represents an (output) assertion made by an abstractor
 */
public abstract class AbstractorAssertion {
    protected UUID id;
    protected UUID abstractorUID;
    protected String assertedValue;
}
