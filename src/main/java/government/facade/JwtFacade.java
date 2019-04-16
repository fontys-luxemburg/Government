package government.facade;

import government.annotation.PropertiesFromFile;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Date;
import java.util.Properties;

@ApplicationScoped
public class JwtFacade {

//    @Inject
//    @PropertiesFromFile
//    Properties props;

    private Algorithm algorithm;

    @Inject
    @ConfigProperty(name = "mp.jwt.verify.issuer")
    private String ISSUER;

    @Inject
    @ConfigProperty(name = "mp.jwt.verify.publickey")
    private String SECRET_KEY;

    @PostConstruct
    public void initialize() {
        algorithm = Algorithm.HMAC256(SECRET_KEY);
    }

    public String issueToken(String email) {
        String[] groups = {"user", "admin"};

        return JWT.create()
                .withIssuer(ISSUER)
                .withSubject(email)
                .withArrayClaim("groups", groups)
                .withExpiresAt(new Date(System.currentTimeMillis() + 100000000))
                .sign(algorithm);
    }

    public String validateToken(String token) {
        try {
            JWTVerifier verifier = JWT.require(algorithm).withIssuer(ISSUER).build();
            DecodedJWT jwt = verifier.verify(token);
            return jwt.getSubject();
        } catch (JWTVerificationException e) {
            return null;
        }
    }
}
