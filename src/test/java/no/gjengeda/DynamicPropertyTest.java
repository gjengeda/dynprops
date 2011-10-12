package no.gjengeda;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/ApplicationContext.xml")
public class DynamicPropertyTest {

    private static final Logger LOGGER = Logger.getLogger(DynamicPropertyTest.class);

    @Autowired
    private PropertiesConfiguration config;
    
    @Test
    public void testDynamicPropertyLoading() throws ConfigurationException {
        LOGGER.debug(config.getFileName());
        for (int i = 0; i < 2; i++) {
            LOGGER.debug(config.getString("myprop"));
        }
    }
}
