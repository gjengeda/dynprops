package no.gjengeda;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;
import org.apache.log4j.Logger;

public class ReloadedPropertyConfiguration extends PropertiesConfiguration {

    public void init() {
        setReloadingStrategy(new FileChangedReloadingStrategy());
        try {
            load();
        } catch (ConfigurationException e) {
            Logger.getLogger(getClass()).debug(String.format("Could not load file [%s]. Ignoring...", getFileName()));
        }
    }
    
}
