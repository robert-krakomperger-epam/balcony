#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.auth.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import ${package}.auth.web.domain.LoginRequest;
import ${package}.context.web.domain.RequestContext;

@Controller
public class LoginPageController {

    @Value("${symbol_dollar}{loginPageController.successView}")
    private String successView;
    @Value("${symbol_dollar}{loginPageController.authenticatedView}")
    private String authenticatedView;

    @RequestMapping(value = "${symbol_dollar}{loginPageController}")
    public String showLogin(RequestContext requestContext, final LoginRequest loginRequest, final BindingResult bindingResult, final HttpSession httpSession)
            throws Throwable {
        String result;
        if (requestContext.getUserContext().isAuthenticated()) {
            result = authenticatedView;
        } else {
            try {
                handleAuthException(httpSession);
            } catch (AuthenticationException e) {
                bindingResult.reject("", "Bad credentials");
            }
            result = successView;
        }
        return result;
    }

    private void handleAuthException(final HttpSession httpSession) throws Throwable {
        Throwable authException = (Throwable) httpSession.getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
        if (authException != null) {
            httpSession.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
            throw authException;
        }
    }

}
