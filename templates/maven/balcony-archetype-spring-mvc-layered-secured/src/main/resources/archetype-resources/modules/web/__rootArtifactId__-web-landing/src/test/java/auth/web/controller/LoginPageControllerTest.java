#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.auth.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.validation.BindingResult;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ${package}.auth.web.domain.LoginRequest;
import ${package}.context.web.domain.RequestContext;

public class LoginPageControllerTest {
    private LoginPageController underTest;

    @BeforeMethod
    public void setUp() {
        underTest = new LoginPageController();
    }

    @Test
    public void testHomepageShouldReturnHome() throws Throwable {
        // GIVEN
        HttpSession httpSession = null;
        BindingResult bindingResult = null;
        LoginRequest loginRequest = null;
        // WHEN
        String result = underTest.showLogin(new RequestContext(null, null), loginRequest, bindingResult, httpSession);
        // THEN
        Assert.assertEquals(result, "login");
    }
}
