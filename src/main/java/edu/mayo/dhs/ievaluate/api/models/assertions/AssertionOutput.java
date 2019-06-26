package edu.mayo.dhs.ievaluate.api.models.assertions;

import java.util.List;
import java.util.Map;

/**
 * An application assertion output definition
 */
public abstract class AssertionOutput {

    /**
     * @return An ordered listing of value field names that serve as keys for {@link #asValueMap()} ()}
     */
    public abstract List<String> valueFieldNames();

    /**
     * @return The output parameters as a map
     */
    public abstract Map<String, String> asValueMap();

    /**
     * Used to instantiate this output definition instance with the given parameter map
     *
     * @param values The values map representing pipeline output
     */
    public abstract void fromOutputMap(Map<String, String> values);

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
