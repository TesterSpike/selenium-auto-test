package automation;

import automation.util.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class SystemVariable {
    public String baseUrl;
    public String defaultPriority;
    private Properties properties;
    private final Logger logger = new Logger(getClass());


    public SystemVariable() {
        properties = getPropertiesFile(System.getProperty("env"));
        Path url = Paths.get(getPropertyByName("baseUrl", "defaultValue").replace("\"", ""));
        baseUrl = url.toUri().toString();
        defaultPriority = getPropertyByName("defaultPriority", "Urgent");
    }

    private String getPropertyByName(String propertyName, String defaultValue) {
        return (properties.getProperty(propertyName) == null) ? defaultValue : properties.getProperty(propertyName);
    }

    /**
     * Returns a properties object from the file with the supplied name.  The name is appended with '.properties'
     *
     * @param env file name
     * @return Properties object
     */
    @SuppressWarnings("SameParameterValue")
    private Properties getPropertiesFile(String env) {
        Properties props = new Properties();
        try (InputStream input = new FileInputStream("./src/test/resources/" + env + ".properties")) {
            props.load(input);
        } catch (IOException ex) {
            logger.error("Invalid system property key or value", ex);
        }
        return props;
    }
}


