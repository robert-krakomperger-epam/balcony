#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.security.context.facade;

import ${package}.context.domain.UserContext;

public interface SecurityContextFacade {

    UserContext getUserContext();

}
