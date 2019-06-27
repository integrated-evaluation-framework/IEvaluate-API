package edu.mayo.dhs.ievaluate.api.applications;

import edu.mayo.dhs.ievaluate.api.applications.definitions.ApplicationParameter;

import java.util.List;

/**
 * Defines {@link ProfiledApplication}s for dynamic (non-programmatic) creation.
 * <br/>
 * Application definitions do *not* need to be created if the applications will only be created programmatically w/o a
 * need for user input
 */
public abstract class ApplicationDefinition {

    /**
     * @return The name of the type of application represented by this definition
     */
    public abstract String definitionName();

    /**
     * @return The application provider corresponding to this definition
     */
    public abstract ApplicationProvider<? extends ProfiledApplication> getApplicationProvider();

    /**
     * @return An ordered sequence of application parameters
     */
    public abstract List<ApplicationParameter> asParameterList();

}
