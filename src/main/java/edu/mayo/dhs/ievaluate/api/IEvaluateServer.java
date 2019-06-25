package edu.mayo.dhs.ievaluate.api;

import edu.mayo.dhs.ievaluate.api.applications.ApplicationManager;
import edu.mayo.dhs.ievaluate.api.applications.ProfiledApplication;
import edu.mayo.dhs.ievaluate.api.plugins.IEvaluatePlugin;
import edu.mayo.dhs.ievaluate.api.plugins.PluginManager;
import edu.mayo.dhs.ievaluate.api.storage.StorageProvider;
import org.apache.logging.log4j.Logger;

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
