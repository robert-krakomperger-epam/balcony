#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.context.domain;

import java.util.List;

import ${package}.context.domain.security.User;
import ${package}.context.domain.security.UserRole;

public interface UserContext {

    boolean isAuthenticated();

    User getUser();

    List<UserRole> getRoles();

}
