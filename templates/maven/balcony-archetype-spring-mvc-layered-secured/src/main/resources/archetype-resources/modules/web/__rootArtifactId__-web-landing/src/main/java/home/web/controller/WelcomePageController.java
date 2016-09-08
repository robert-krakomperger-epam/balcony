#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.home.web.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomePageController {

    @Value("${symbol_dollar}{welcomePageController.successView}")
    private String successView;

    @RequestMapping(value = "${symbol_dollar}{welcomePageController}")
    public String showWelcomePage() {
        return successView;
    }

}
