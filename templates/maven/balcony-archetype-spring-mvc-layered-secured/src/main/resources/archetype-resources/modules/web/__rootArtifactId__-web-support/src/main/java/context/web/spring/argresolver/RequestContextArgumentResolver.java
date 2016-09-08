#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.context.web.spring.argresolver;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebArgumentResolver;
import org.springframework.web.context.request.NativeWebRequest;

import ${package}.context.domain.UserContext;
import ${package}.context.web.domain.RequestContext;
import ${package}.security.context.facade.SecurityContextFacade;

public class RequestContextArgumentResolver implements WebArgumentResolver {
    private final SecurityContextFacade securityContextFacade;

    public RequestContextArgumentResolver(final SecurityContextFacade securityContextFacade) {
        super();
        this.securityContextFacade = securityContextFacade;
    }

    @Override
    public Object resolveArgument(final MethodParameter methodParameter, final NativeWebRequest webRequest) throws Exception {
        Object result;
        if (isArgumentResolvable(methodParameter)) {
            result = createRequestContext(webRequest);
        } else {
            result = UNRESOLVED;
        }
        return result;
    }

    private boolean isArgumentResolvable(final MethodParameter methodParameter) {
        return methodParameter.getParameterType().equals(RequestContext.class);
    }

    private RequestContext createRequestContext(final NativeWebRequest webRequest) {
        UserContext userContext = getUserContext();
        return new RequestContext(webRequest.getLocale(), userContext);
    }

    private UserContext getUserContext() {
        return securityContextFacade.getUserContext();
    }

}
