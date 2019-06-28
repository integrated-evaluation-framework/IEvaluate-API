package edu.mayo.dhs.ievaluate.api.applications.definitions;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.*;

/**
 * Special case application parameter that denotes a group of application parameters
 */
public abstract class ApplicationParameterGroup implements ApplicationParameter {

    /**
     * Denotes the group name. Can be null
     */
    protected final String groupName;
    /**
     * An ordered list of parameters in this group
     */
    protected final List<ApplicationParameter> parameters;

    protected final boolean isRepeatable;

    protected final Map<String, ApplicationParameter> topLevelParams;

    public ApplicationParameterGroup(String groupName, boolean isRepeatable, ApplicationParameter... parameters) {
        this.groupName = groupName;
        this.parameters = new ArrayList<>(Arrays.asList(parameters));
        this.isRepeatable = isRepeatable;
        this.topLevelParams = new HashMap<>();
        this.parameters.forEach(p -> topLevelParams.put(p.fieldName(), p));
    }

    public String getGroupName() {
        return groupName;
    }

    public List<ApplicationParameter> getParameters() {
        return parameters;
    }

    @Override
    public String fieldName() {
        return groupName;
    }

    @Override
    public String getLabel() {
        return null; // Groups are a special implementation
    }

    @Override
    public String getValidationRegex() {
        return null; // Groups are a special implementation
    }

    @Override
    public String getAcceptedValuesHumanReadible() {
        return null; // Groups are a special implementation
    }

    @Override
    public Class<?> getParameterType() {
        return null; // Groups are a special implementation that have no parameter type, as they are a collection of params
    }

    @Override
    public boolean isCollection() {
        return isRepeatable;
    }

    /**
     * Convert an input based on this parameter group definition into an appropriate json node as would be expected in
     * {@link edu.mayo.dhs.ievaluate.api.applications.ApplicationProvider#unmarshal(JsonNode)}
     * @param input The value to convert to JSON
     * @return The applicable JSON node
     */
    public abstract JsonNode toApplicationJson(JsonNode input);

}
