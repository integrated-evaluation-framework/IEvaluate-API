package edu.mayo.dhs.ievaluate.api;

import edu.mayo.dhs.ievaluate.api.models.applications.ProfiledApplication;
import edu.mayo.dhs.ievaluate.api.plugins.IEvaluatePlugin;
import edu.mayo.dhs.ievaluate.api.util.StorageProvider;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;

/**
 * A running IEvaluate server instance
 */
public interface IEvaluateServer {

    /* ===== Begin Plugin Management Functions ===== */

    /**
     * @param name  The name of the plugin
     * @param clazz The plugin class that is expected
     * @param <T>   The {@link IEvaluatePlugin} implementation type corresponding to clazz
     * @return The instantiated instance of the {@link IEvaluatePlugin}
     */
    <T extends IEvaluatePlugin> T getPlugin(String name, Class<T> clazz);

    /**
     * Do not call before application initialization is complete
     * @return A mapping of Registered Plugin Name => Plugin Instances
     */
    Map<String, IEvaluatePlugin> getRegisteredPlugins();

    /* ===== Begin Application Management Functions ===== */

    /**
     * @return A collection of all {@link ProfiledApplication} currently registered to the Integrated Evaluation Framework
     */
    Collection<ProfiledApplication> getRegisteredApplications();

    /**
     * @param uid   The unique ID of the application
     * @return The application with this unique identifier
     */
    ProfiledApplication getApplication(UUID uid);

    /**
     * Registers and performs appropriate serialization an application instance
     *
     * @param application The application instance
     */
    void registerApplication(ProfiledApplication application);

    /* ===== End Application Management Functions ===== */

    /* ===== Begin Serialization Functions ===== */

    /**
     * @return The {@link StorageProvider} associated with the current running instance
     */
    StorageProvider getStorage();

    /**
     * Registers the given storage provider as the provider to use for storage operations.
     * @param provider The provider to register
     * @throws IllegalStateException if multiple storage providers are registered
     */
    void registerStorageProvider(StorageProvider provider);

    /* ===== Begin Serialization Functions ===== */

}
