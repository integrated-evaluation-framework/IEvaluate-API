package edu.mayo.dhs.ievaluate.api.models.assertions;

/**
 * Used to define application assertion outputs
 */
public abstract class AssertionOutput {

    /**
     * Used to force implementations to define an equals method, with the same contract
     *
     * @param other The other asserted output
     * @return true if these two items are the same
     * @see Object#equals(Object)
     */
    public abstract boolean matches(AssertionOutput other);

    /**
     * Used to force implementations to define a hash method, with the same contract
     *
     * @return A hash code corresponding to this object
     * @see Object#hashCode()
     */
    public abstract int toHash();

    @Override
    public final int hashCode() {
        return toHash();
    }

    @Override
    public final boolean equals(Object other) {
        return other instanceof AssertionOutput && matches((AssertionOutput)other);
    }
}
