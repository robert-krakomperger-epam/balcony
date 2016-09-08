#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.security.spring.domain;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import ${package}.context.domain.UserContext;

public class CoreSpringSecurityContext implements UserDetails {
    private static final long serialVersionUID = 1L;
    private final UserDetails springUserDetails;
    private final UserContext userContext;

    public CoreSpringSecurityContext(UserDetails springUserDetails, UserContext userContext) {
        super();
        this.springUserDetails = springUserDetails;
        this.userContext = userContext;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return springUserDetails.getAuthorities();
    }

    @Override
    public String getPassword() {
        return springUserDetails.getPassword();
    }

    @Override
    public String getUsername() {
        return springUserDetails.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return springUserDetails.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return springUserDetails.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return springUserDetails.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return springUserDetails.isEnabled();
    }

    public UserContext getUserContext() {
        return userContext;
    }

}
