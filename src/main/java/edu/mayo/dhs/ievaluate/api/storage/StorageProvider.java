package edu.mayo.dhs.ievaluate.api.storage;

import com.fasterxml.jackson.databind.JsonNode;
import edu.mayo.dhs.ievaluate.api.applications.ApplicationManager;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;

/**
 * Storage provider for serialization of application data
 */
public interface StorageProvider {
    /**
     * @return A mapping of {@link edu.mayo.dhs.ievaluate.api.applications.ProfiledApplication} class name to the
     * serialized representation from the respective {@link edu.mayo.dhs.ievaluate.api.applications.ApplicationProvider}
     */
    Map<String, JsonNode> loadRegisteredApplications();

    /**
     * Saves the current application manager and relevant states
     */
    void saveRegisteredApplications();
}
