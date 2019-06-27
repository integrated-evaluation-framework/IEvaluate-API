package edu.mayo.dhs.ievaluate.api.applications.definitions;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Denotes a group of application parameters
 */
public abstract class ApplicationParameterGroup {

    /**
     * Denotes the group name. Can be null
     */
    private final String groupName;
    /**
     * An ordered list of parameters in this group
     */
    private final List<ApplicationParameter> parameters;

    public ApplicationParameterGroup(String groupName, ApplicationParameter... parameters) {
        this.groupName = groupName;
        this.parameters = new ArrayList<>(Arrays.asList(parameters));
    }

    public String getGroupName() {
        return groupName;
    }

    public List<ApplicationParameter> getParameters() {
        return parameters;
    }

    /**
     * Convert an input based on this parameter group definition into an appropriate json node as would be expected in
     * {@link edu.mayo.dhs.ievaluate.api.applications.ApplicationProvider#unmarshal(JsonNode)}
     * @param input The value to convert to JSON
     * @return The applicable JSON node
     */
    public abstract JsonNode toApplicationJson(JsonNode input);

}
