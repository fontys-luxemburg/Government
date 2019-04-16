package government.controller;

import org.eclipse.microprofile.auth.LoginConfig;

import javax.annotation.security.DeclareRoles;
import javax.ws.rs.ApplicationPath;

@ApplicationPath("/api")
@LoginConfig(authMethod = "MP-JWT")
@DeclareRoles({"user", "admin"})
public class Application extends javax.ws.rs.core.Application {

//    public Application() {
//        register(JacksonFeature.class);
//        packages("government");
//    }

}