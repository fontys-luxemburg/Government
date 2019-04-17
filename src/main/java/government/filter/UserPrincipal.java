package government.filter;

import government.model.User;

import java.security.Principal;

public class UserPrincipal implements Principal {
    private final User user;

    public UserPrincipal(User user) {
        this.user = user;
    }

    @Override
    public String getName() {
        return user.getName();
    }
}
