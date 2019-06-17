package edu.mayo.dhs.ievaluate.api.applications;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * Implementations define how to marshal and unmarshal {@link ProfiledApplication} instances from storage, as well as
 * produce new instances
 *
 * @param <T> The type of {@link ProfiledApplication} this provider produces
 */
public interface ApplicationProvider<T extends ProfiledApplication> {

    /**
     * @return A user-friendly name for this type of application
     */
    String applicationName();

    /**
     * @return The application class that this provider will produce.
     */
    Class<T> applicationClass();

    /**
     * @param applicationInstance The application instance to marshal
     * @return A Json Representation of the Application Instance
     * @throws IllegalStateException if the class of the supplied applicationInstance does not match T
     */
    JsonNode marshal(ProfiledApplication applicationInstance);

    /**
     * @param json The json representation of the application instance
     * @return An instantiation of the profiled application generated from this json representation
     */
    T unmarshal(JsonNode json);


    /**
     * @return A new instance of this application
     */
    T produceNew();

}
