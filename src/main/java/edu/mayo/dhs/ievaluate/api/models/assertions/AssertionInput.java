package edu.mayo.dhs.ievaluate.api.models.assertions;

import java.util.List;
import java.util.Map;

public abstract class AssertionInput {

    /**
     * @return An ordered listing of parameter names that serve as keys for {@link #asParameterMap()}
     */
    public abstract List<String> parameterNames();

    /**
     * @return The input parameters as a map
     */
    public abstract Map<String, String> asParameterMap();

    /**
     * Used to force implementations to define an equals method, with the same contract
     *
     * @param other The other assert
     * @return true if these two items are the same
     * @see Object#equals(Object)
     */
    public abstract boolean matches(AssertionInput other);

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
        return other instanceof AssertionInput && matches((AssertionInput)other);
    }
}
