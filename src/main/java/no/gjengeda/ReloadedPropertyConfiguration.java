package no.gjengeda;

import java.io.File;
import java.net.URL;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;
import org.apache.log4j.Logger;

public class ReloadedPropertyConfiguration extends PropertiesConfiguration {

    private boolean ignoreResourceNotFound = false;
    
    public ReloadedPropertyConfiguration() {
        super();
        setReloadingStrategy(new FileChangedReloadingStrategy());
    }

    public ReloadedPropertyConfiguration(File file) throws ConfigurationException {
        super(file);
        setReloadingStrategy(new FileChangedReloadingStrategy());
    }

    public ReloadedPropertyConfiguration(String fileName) throws ConfigurationException {
        super(fileName);
        setReloadingStrategy(new FileChangedReloadingStrategy());
    }

    public ReloadedPropertyConfiguration(URL url) throws ConfigurationException {
        super(url);
        setReloadingStrategy(new FileChangedReloadingStrategy());
    }

    @Override
    public void load() throws ConfigurationException {
        try {
            super.load();
        } catch (ConfigurationException e) {
            if(ignoreResourceNotFound) {
                Logger.getLogger(getClass()).info(String.format("Could not load file [%s]. Ignoring...", getFileName()));
            } else {
                throw e;
            }
                
        }
    }

    public void setIgnoreResourceNotFound(boolean ignoreResourceNotFound) {
        this.ignoreResourceNotFound = ignoreResourceNotFound;
    }

}
