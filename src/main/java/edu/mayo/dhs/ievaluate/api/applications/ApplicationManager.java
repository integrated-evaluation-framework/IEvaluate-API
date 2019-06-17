package edu.mayo.dhs.ievaluate.api.applications;

import edu.mayo.dhs.ievaluate.api.plugins.IEvaluatePlugin;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;

/**
 * Responsible for all aspects of {@link ProfiledApplication} lifecycle and management
 */
public interface ApplicationManager {

    /**
     * Not available until after {@link IEvaluatePlugin#onInit()}
     * @return A collection of all {@link ProfiledApplication} currently registered to the Integrated Evaluation Framework
     */
    Collection<? extends ProfiledApplication> getRegisteredApplications();

    /**
     * Not available until after {@link IEvaluatePlugin#onInit()}
     * @param uid The unique ID of the application
     * @return The application with this unique identifier
     */
    ProfiledApplication getApplication(UUID uid);

    /**
     * Not available until after {@link IEvaluatePlugin#onInit()}
     * Registers and performs appropriate serialization of an application instance
     *
     * @param application The application instance
     */
    void registerApplication(ProfiledApplication application);

    /**
     * Registers {@link ApplicationProvider} instances.
     * This must be called during the {@link IEvaluatePlugin#onInit()} or {@link IEvaluatePlugin#onEnable()} phase of
     * any plugins
     *
     * @param provider The application provider to register
     * @throws IllegalStateException if the provider is registered after the server is started
     */
    void registerApplicationProvider(ApplicationProvider<?> provider);

    /**
     * @return A mapping of application class names to currently registered application providers
     */
    Map<String, ApplicationProvider<?>> getApplicationProviders();
}
