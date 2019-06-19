package edu.mayo.dhs.ievaluate.api.plugins;

import java.io.File;

/**
 * Subclasses define plugins that extend functionality of the integrated evaluation framework
 * <br/>
 * Note that for the most part, implementations do not need to worry about registering the plugin with the
 * {@link edu.mayo.dhs.ievaluate.api.IEvaluateServer} as this is handled by default prior to {@link #onInit()}
 */
public abstract class IEvaluatePlugin {

    /**
     * Called during {@link edu.mayo.dhs.ievaluate.api.IEvaluateServer.InitState#PRE_INIT}
     * Any config.json file embedded within the plugin will be copied over by default if not already existing.
     * <br/>
     * No guarantees are yet made about the state of any dependencies
     *
     * @param configDir A directory for configuration storage assigned to this plugin.
     */
    public void loadConfig(File configDir) {
    }

    /**
     * Used to initialize plugin functionality.
     * <br/>
     * Called during the plugin loading process before {@link #onEnable()}.
     * At this point, only the plugins listed in {@link PluginDescriptor#getRequired()} will be available and will
     * only have run their onInit() methods.
     */
    public void onInit() {
    }

    /**
     * Used to initialize plugin functionality.
     * <br/>
     * Called during the plugin loading process after all plugins have completed {@link #onInit()}. This is the last
     * step of execution prior to the server being fully initialized
     */
    public void onEnable() {
    }


}
