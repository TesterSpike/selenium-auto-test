package automation;

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


    public SystemVariable() {
        properties = getTestPropertiesFile("test");
        Path url = Paths.get(getPropertyByName("baseUrl", "defaultValue").replace("\"", ""));
        baseUrl = url.toUri().toString();
        System.out.println(baseUrl);
        defaultPriority = getPropertyByName("defaultPriority", "Urgent");
    }

    private String getPropertyByName(String propertyName, String defaultValue) {
        return (properties.getProperty(propertyName) == null) ? defaultValue : properties.getProperty(propertyName);
    }

    private Properties getTestPropertiesFile(String env) {
        //If you have multiple environments you can use an environment variable on the command line to specify which one to use
        //String env = System.getProperty("Environment");

        Properties properties = new Properties();
        try (InputStream input = new FileInputStream("./src/test/resources/" + env + ".properties")) {
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return properties;
    }
}


