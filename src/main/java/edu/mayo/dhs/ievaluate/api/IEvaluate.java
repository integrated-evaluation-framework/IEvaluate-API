package edu.mayo.dhs.ievaluate.api;

import edu.mayo.dhs.ievaluate.api.applications.ApplicationManager;
import edu.mayo.dhs.ievaluate.api.storage.StorageProvider;
import org.apache.logging.log4j.Logger;

/**
 * A global entry point for static access to all of the integrated evaluation framework's functionality on the
 * currently running IEvaluate instance.
 *
 * Thread safety (or appropriate barriers) is expected of all API functions once the server's initialization
 * state reaches {@link IEvaluateServer.InitState#COMPLETE}
 */
public final class IEvaluate {

    private static IEvaluateServer SERVER;

    private IEvaluate() {
    } // Static class, not to be instantiated

    /**
     * Gets the current {@link IEvaluateServer} powering the application
     *
     * @return The registered server instance
     */
    public static IEvaluateServer getServer() {
        return IEvaluate.SERVER;
    }

    /**
     * Attempts to register a {@link IEvaluateServer} singleton as the currently running application
     * <br/>
     * This will fail with an {@link UnsupportedOperationException} if a server is already registered
     *
     * @param server Server instance
     */
    public static void setServer(IEvaluateServer server) {
        if (IEvaluate.SERVER != null) {
            throw new UnsupportedOperationException("A server is already registered!");
        }

        IEvaluate.SERVER = server;
    }

    /**
     * @return The IEvaluate Application Logger Instance
     * @see IEvaluateServer#getLogger()
     */
    public static Logger getLogger() {
        if (IEvaluate.SERVER == null) {
            throw new UnsupportedOperationException("Server not yet initialized!");
        }
        return SERVER.getLogger();
    }

    /**
     * @return The IEvaluate Application Manager
     * @see IEvaluateServer#getApplicationManager()
     */
    public static ApplicationManager getApplicationManager() {
        return SERVER.getApplicationManager();
    }

    /**
     * @return The Storage Provider serving this application
     * @see IEvaluateServer#getStorage()
     */
    public static StorageProvider getStorage() {
        return SERVER.getStorage();
    }
}
