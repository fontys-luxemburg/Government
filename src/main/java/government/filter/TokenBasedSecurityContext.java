package government.filter;

import government.model.User;

import javax.ws.rs.core.SecurityContext;
import java.security.Principal;

public class TokenBasedSecurityContext implements SecurityContext {
    private final UserPrincipal userPrincipal;
    private final boolean isSecure;

    public TokenBasedSecurityContext(UserPrincipal userPrincipal, boolean isSecure) {
        this.userPrincipal = userPrincipal;
        this.isSecure = isSecure;
    }

    @Override
    public Principal getUserPrincipal() {
        return userPrincipal;
    }

    @Override
    public boolean isUserInRole(String role) {
        return false;
    }

    @Override
    public boolean isSecure() {
        return isSecure;
    }

    @Override
    public String getAuthenticationScheme() {
        return null;
    }
}

