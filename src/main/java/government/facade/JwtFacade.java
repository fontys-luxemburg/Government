package government.facade;

import government.annotation.PropertiesFromFile;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Properties;

@ApplicationScoped
public class JwtFacade {

    @Inject
    @PropertiesFromFile
    Properties props;

    private Algorithm algorithm;
    private String ISSUER;

    @PostConstruct
    public void initialize() {
        algorithm = Algorithm.HMAC256(props.getProperty("secret_key"));
        ISSUER = "government_api";
    }

    public String issueToken(String email) {
        return JWT.create()
                .withIssuer(ISSUER)
                .withSubject(email)
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
