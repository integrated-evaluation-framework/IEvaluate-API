package edu.mayo.dhs.ievaluate.api.plugins;

import java.util.Map;

/**
 * Responsible for all aspects of {@link IEvaluatePlugin} lifecycle and management
 */
public interface PluginManager {

    /**
     * @param name  The name of the plugin
     * @param clazz The plugin class that is expected
     * @param <T>   The {@link IEvaluatePlugin} implementation type corresponding to clazz
     * @return The instantiated instance of the {@link IEvaluatePlugin}, or null if none present
     */
    <T extends IEvaluatePlugin> T getPlugin(String name, Class<T> clazz);

    /**
     * @return A mapping of Registered Plugin Name => Plugin Instances
     */
    Map<String, IEvaluatePlugin> getRegisteredPlugins();
}
