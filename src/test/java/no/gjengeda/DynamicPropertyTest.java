package no.gjengeda;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;
import org.apache.log4j.Logger;
import org.junit.Test;

public class DynamicPropertyTest {

    private static final Logger LOGGER = Logger.getLogger(DynamicPropertyTest.class);

    @Test
    public void testDynamicPropertyLoading() throws ConfigurationException {
        PropertiesConfiguration config = new PropertiesConfiguration("my.properties");
        config.setReloadingStrategy(new FileChangedReloadingStrategy());
        for (int i = 0; i < 2; i++) {
            LOGGER.debug(config.getString("myprop"));
        }
    }
}
