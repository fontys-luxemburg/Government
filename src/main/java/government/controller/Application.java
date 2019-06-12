package government.controller;

import government.annotation.PropertiesFromFile;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;
import java.util.Properties;

@ApplicationPath("/api")
public class Application extends ResourceConfig {
    public Application() {
        register(JacksonFeature.class);
        packages("government");
    }
}
