package edu.mayo.dhs.ievaluate.api;

import edu.mayo.dhs.ievaluate.api.models.applications.ProfiledApplication;
import edu.mayo.dhs.ievaluate.api.util.StorageProvider;

import java.util.Collection;
import java.util.UUID;

/**
 * Global API entry point for the IEvaluate Framework
 */
public interface IEvaluate {

    /* ===== Begin Application Management Functions ===== */

    /**
     * @return A collection of all {@link ProfiledApplication} currently registered to the Integrated Evaluation Framework
     */
    Collection<ProfiledApplication> getRegisteredApplications();

    /**
     * @param uid The unique ID of the application
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
}
