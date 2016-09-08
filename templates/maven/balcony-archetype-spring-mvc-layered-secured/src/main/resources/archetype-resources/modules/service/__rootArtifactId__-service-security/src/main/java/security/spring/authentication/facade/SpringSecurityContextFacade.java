#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.security.spring.authentication.facade;

import java.util.Collections;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import ${package}.context.domain.UserContext;
import ${package}.context.domain.core.DefaultUserContext;
import ${package}.security.context.facade.SecurityContextFacade;
import ${package}.security.spring.domain.CoreSpringSecurityContext;

@Component("securityContextFacade")
public class SpringSecurityContextFacade implements SecurityContextFacade {

    @Override
    public UserContext getUserContext() {
        UserContext result = null;
        if (isUserAuthenticated()) {
            CoreSpringSecurityContext principal = getPrincipal();
            if (principal != null) {
                result = principal.getUserContext();
            }
        } else {
            result = new DefaultUserContext(null, Collections.emptyList(), false);
        }

        return result;
    }

    private boolean isUserAuthenticated() {
        Authentication authentication = getAuthentication();
        return authentication != null && authentication.isAuthenticated()
                && !authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ANONYMOUS"));
    }

    private Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    private CoreSpringSecurityContext getPrincipal() {
        CoreSpringSecurityContext principal = (CoreSpringSecurityContext) getAuthentication().getPrincipal();
        return principal;
    }

}
