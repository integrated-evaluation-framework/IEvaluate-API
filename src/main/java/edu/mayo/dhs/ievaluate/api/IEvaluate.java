package edu.mayo.dhs.ievaluate.api;

/**
 * A global entry point for static access to all of the integrated evaluation framework's functionality on the
 * currently running IEvaluate instance
 */
public final class IEvaluate {

    private static IEvaluateServer server;

    private IEvaluate() {} // Static class, not to be instantiated

    /**
     * Gets the current {@link IEvaluateServer} powering the application
     *
     * @return The registered server instance
     */
    public static IEvaluateServer getServer() {
        return IEvaluate.server;
    }

    /**
     * Attempts to register a {@link IEvaluateServer} singleton as the currently running application
     * <br/>
     * This will fail with an {@link UnsupportedOperationException} if a server is already registered
     *
     * @param server Server instance
     */
    public static void setServer(IEvaluateServer server) {
        if (IEvaluate.server != null) {
            throw new UnsupportedOperationException("A server is already registered!");
        }

        IEvaluate.server = server;
    }
}
