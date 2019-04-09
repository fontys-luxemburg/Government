package government.controller;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/api")
public class Application extends ResourceConfig {

    public Application() {
        register(JacksonFeature.class);
        packages("government");
    }
}