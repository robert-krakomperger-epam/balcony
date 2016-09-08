#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.security.spring.authentication;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import ${package}.context.domain.core.DefaultUserContext;
import ${package}.context.domain.security.User;
import ${package}.context.domain.security.UserRole;
import ${package}.security.spring.domain.CoreSpringSecurityContext;

public class DummyUserDetailsService implements UserDetailsService {
    private static final String USERNAME = "user";
    private static final String PASSWORD = "user";
    private static final List<SimpleGrantedAuthority> ROLES = Arrays.asList(new SimpleGrantedAuthority("ROLE"));

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails result;
        if (USERNAME.equals(username)) {
            result = createDummyUserDetails();
        } else {
            throw new UsernameNotFoundException("Bad credentials");
        }
        return result;
    }

    private UserDetails createDummyUserDetails() {
        UserDetails springUserDetails = createSpringUserDetails();
        return new CoreSpringSecurityContext(springUserDetails, new DefaultUserContext(createUser(springUserDetails), createRoles(springUserDetails), true));

    }

    private List<UserRole> createRoles(UserDetails springUserDetails) {
        return Arrays.asList(UserRole.ROLE_USER);
    }

    private User createUser(UserDetails springUserDetails) {
        return new User(springUserDetails.getUsername(), springUserDetails.getPassword());
    }

    private UserDetails createSpringUserDetails() {
        return new UserDetails() {
            private static final long serialVersionUID = 1L;

            @Override
            public boolean isEnabled() {
                return true;
            }

            @Override
            public boolean isCredentialsNonExpired() {
                return true;
            }

            @Override
            public boolean isAccountNonLocked() {
                return true;
            }

            @Override
            public boolean isAccountNonExpired() {
                return true;
            }

            @Override
            public String getUsername() {
                return USERNAME;
            }

            @Override
            public String getPassword() {
                return PASSWORD;
            }

            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                return ROLES;
            }
        };
    }

}
