#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.context.domain.core;

import java.util.List;

import ${package}.context.domain.UserContext;
import ${package}.context.domain.security.User;
import ${package}.context.domain.security.UserRole;

public class DefaultUserContext implements UserContext {
    private final User user;
    private final List<UserRole> roles;
    private final boolean isAuthenticated;

    public DefaultUserContext(User user, List<UserRole> roles, boolean isAuthenticated) {
        super();
        this.user = user;
        this.roles = roles;
        this.isAuthenticated = isAuthenticated;
    }

    @Override
    public List<UserRole> getRoles() {
        return roles;
    }

    @Override
    public User getUser() {
        return user;
    }

    @Override
    public boolean isAuthenticated() {
        return isAuthenticated;
    }

}
