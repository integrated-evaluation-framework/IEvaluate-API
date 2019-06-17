package edu.mayo.dhs.ievaluate.api.plugins;


import java.util.List;

/**
 * A POJO representation of the plugin.json file attached to all plugin JAR files
 */
public final class PluginDescriptor {
    /**
     * The name of the plugin
     */
    private String name;

    /**
     * The main plugin class that extends {@link IEvaluatePlugin}
     */
    private String mainClass;

    /**
     * Hard dependencies that must be loaded into the classpath prior to plugin load
     */
    private List<String> required;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMainClass() {
        return mainClass;
    }

    public void setMainClass(String mainClass) {
        this.mainClass = mainClass;
    }

    public List<String> getRequired() {
        return required;
    }

    public void setRequired(List<String> required) {
        this.required = required;
    }
}
