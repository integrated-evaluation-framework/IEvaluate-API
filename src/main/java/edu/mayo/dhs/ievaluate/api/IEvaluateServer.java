package edu.mayo.dhs.ievaluate.api;

import edu.mayo.dhs.ievaluate.api.applications.ApplicationManager;
import edu.mayo.dhs.ievaluate.api.applications.ProfiledApplication;
import edu.mayo.dhs.ievaluate.api.models.assertions.AssertionDefinition;
import edu.mayo.dhs.ievaluate.api.models.assertions.AssertionInput;
import edu.mayo.dhs.ievaluate.api.models.assertions.AssertionOutput;
import edu.mayo.dhs.ievaluate.api.plugins.IEvaluatePlugin;
import edu.mayo.dhs.ievaluate.api.plugins.PluginManager;
import edu.mayo.dhs.ievaluate.api.storage.StorageProvider;
import org.apache.logging.log4j.Logger;

import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * A running IEvaluate server instance
 */
public interface IEvaluateServer {

    /* ===== Begin Manager Access Functions ===== */

    /**
     * @return The {@link ApplicationManager} instance responsible for {@link ProfiledApplication} management
     */
    ApplicationManager getApplicationManager();

    /**
     * @return The {@link PluginManager} instance responsible for {@link IEvaluatePlugin} management
     */
    PluginManager getPluginManager();

    /* ===== End Manager Access Functions ===== */

    /* ===== Begin Serialization Functions ===== */

    /**
     * @return The logger for this application
     */
    Logger getLogger();

    /**
     * @return The {@link StorageProvider} associated with the current running instance, can be null if none registered
     */
    StorageProvider getStorage();

    /**
     * Registers the given storage provider as the provider to use for storage operations.
     * <b>Must</b> be registered during {@link IEvaluatePlugin#onInit()}, no defaults are provided
     * @param provider The provider to register
     * @throws IllegalStateException if multiple storage providers are registered
     */
    void registerStorageProvider(StorageProvider provider);

    /* ===== End Serialization Functions ===== */

    /* ===== Begin Assertion Definitions ===== */

    /**
     * Registers a new {@link AssertionDefinition}. Must be done before {@link InitState#POST_ENABLE}
     * @param clazz The class of the definition to register
     */
    void registerAssertionDefinition(Class<? extends AssertionDefinition> clazz);

    /**
     * Gets a singleton definition instance for assertions that specify an input and output type
     * @param clazz The class of the assertion definition
     * @return The assertion definition singleton
     */
    AssertionDefinition getAssertionDefinition(Class<? extends AssertionDefinition> clazz);

    /**
     * Creates an assertion input instance of the specified type and class
     * @param clazz The {@link AssertionInput} class to instantiate
     * @param inputParams The parameters defining the input
     * @return A new {@link AssertionInput} instance of type clazz initialized with the specified parameters
     */
    AssertionInput getAssertionInput(Class<? extends AssertionInput> clazz, Map<String, String> inputParams);

    /**
     * Creates an assertion output instance of the specified type and class
     * @param clazz The {@link AssertionOutput} class to instantiate
     * @param values The parameters defining the assertion value
     * @return A new {@link AssertionOutput} instance of type clazz initialized with the specified values
     */
    AssertionOutput getAssertionOutput(Class<? extends AssertionOutput> clazz, Map<String, String> values);

    /* ===== End Assertion Definitions ===== */

    /* ===== Begin Server State Handling ===== */

    /**
     * @return The current {@link InitState} of the server
     */
    InitState getInitializationState();

    /**
     * Denotes the current initialization state of the IEvaluate server application
     */
    enum InitState {
        /**
         * Prior to {@link IEvaluatePlugin#onInit()} being called
         */
        PRE_INIT,
        /**
         * Currently calling {@link IEvaluatePlugin#onInit()}
         */
        INIT,
        /**
         * Post {@link IEvaluatePlugin#onInit()}, but pre {@link IEvaluatePlugin#onEnable()}
         */
        PRE_ENABLE,
        /**
         * Currently calling {@link IEvaluatePlugin#onEnable()}
         */
        ENABLING,
        /**
         * Currently finished {@link IEvaluatePlugin#onEnable()}, but not all items are loaded
         */
        POST_ENABLE,
        /**
         * Post {@link IEvaluatePlugin#onEnable()}, server should be considered fully initialized.
         */
        COMPLETE
    }


}
