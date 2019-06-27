package edu.mayo.dhs.ievaluate.api.applications.definitions;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * Represents an application parameter
 */
public interface ApplicationParameter {

    /**
     * @return A name for this parameter field, as would be expected in the json for
     * {@link edu.mayo.dhs.ievaluate.api.applications.ApplicationProvider#unmarshal(JsonNode)}
     */
    String fieldName();

    /**
     * @return A label for this parameter
     */
    String getLabel();

    /**
     * @return Optional regular expression to validate the supplied parameter
     */
    String getValidationRegex();

    /**
     * @return A human-legible representation of accepted values. Required if {{@link #getValidationRegex()}} is not
     * null
     */
    String getAcceptedValuesHumanReadible();

    /**
     * The type of parameter this represents: can be one of
     * <ul>
     *     <li>{@link String}</li>
     *     <li>{@link Boolean}</li>
     *     <li>{@link Integer}</li>
     *     <li>{@link Double}</li>
     *     <li>{@link ApplicationParameterGroup}</li>
     * </ul>
     *
     * @return The java object type of this parameter
     */
    Class<?> getParameterType();

    /**
     * @return True if this parameter can hold one or more values.
     */
    boolean isCollection();

    /**
     * Convert an input based on this parameter definition into an appropriate json node as would be expected in
     * {@link edu.mayo.dhs.ievaluate.api.applications.ApplicationProvider#unmarshal(JsonNode)}
     * @param input The value to convert to JSON
     * @return The applicable JSON node
     */
    JsonNode toApplicationJson(JsonNode input);
}
