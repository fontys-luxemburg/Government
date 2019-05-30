package government.controller;

import government.annotation.PropertiesFromFile;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;
import java.util.Properties;

@ApplicationPath("/api")
public class Application extends ResourceConfig {
    @Inject
    @PropertiesFromFile
    Properties props;
    public Application() {
        register(JacksonFeature.class);
        packages("government");
        String tracking_url= System.getenv("tracking_url");
        if(tracking_url != null){
            props.setProperty("tracking_url",tracking_url);
        }
    }
}
