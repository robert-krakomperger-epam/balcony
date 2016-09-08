#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.context.web.domain;

import java.util.Locale;

import ${package}.context.domain.UserContext;

public class RequestContext {
    private final Locale locale;
    private final UserContext userContext;

    public RequestContext(Locale locale, UserContext userContext) {
        super();
        this.locale = locale;
        this.userContext = userContext;
    }

    public Locale getLocale() {
        return locale;
    }

    public UserContext getUserContext() {
        return userContext;
    }

}
