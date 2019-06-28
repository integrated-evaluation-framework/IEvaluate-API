package edu.mayo.dhs.ievaluate.api.applications;

import edu.mayo.dhs.ievaluate.api.IEvaluate;
import edu.mayo.dhs.ievaluate.api.applications.definitions.ApplicationParameter;
import edu.mayo.dhs.ievaluate.api.applications.definitions.ApplicationParameterGroup;

import java.util.List;

/**
 * Defines {@link ProfiledApplication}s for dynamic (non-programmatic) creation.
 * <br/>
 * Application definitions do *not* need to be created if the applications will only be created programmatically w/o a
 * need for user input
 */
public abstract class ApplicationDefinition extends ApplicationParameterGroup {


    private final Class<? extends ApplicationProvider<? extends ProfiledApplication>> providerClazz;

    public ApplicationDefinition(String groupName, Class<? extends ApplicationProvider<? extends ProfiledApplication>> providerClazz,
                                 ApplicationParameter... parameters) {
        super(groupName, false, parameters);
        this.providerClazz = providerClazz;
    }


    /**
     * @return The name of the type of application represented by this definition
     */
    public String definitionName() {
        return groupName;
    }

    /**
     * @return The application provider corresponding to this definition
     */
    public ApplicationProvider<? extends ProfiledApplication> getApplicationProvider() {
        return IEvaluate.getApplicationManager().getApplicationProviders().get(providerClazz.getName()); // Callback to API, registration should be handled separately
    }

    /**
     * @return An ordered sequence of application parameters
     */
    public List<ApplicationParameter> asParameterList() {
        return parameters;
    }
}
