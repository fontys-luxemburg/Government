package government;

import government.annotation.PropertiesFromFile;

import javax.inject.Inject;
import java.util.Properties;

public class Urls {
    @Inject
    @PropertiesFromFile
    Properties props;
    public String getTrackerUrl(){
        String tracking_url= System.getenv("tracking_url");
        if(tracking_url == null){
            return props.getProperty("tracking_url");
        }
        return tracking_url;
    }
}
