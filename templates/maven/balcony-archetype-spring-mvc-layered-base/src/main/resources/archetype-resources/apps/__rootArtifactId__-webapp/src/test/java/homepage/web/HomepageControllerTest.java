#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.homepage.web;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomepageControllerTest {
    private HomepageController underTest;

    @BeforeMethod
    public void setUp() {
        underTest = new HomepageController();
    }

    @Test
    public void testHomepageShouldReturnHome() {
        // GIVEN in setup
        // WHEN
        String result = underTest.homepage();
        // THEN
        Assert.assertEquals(result, "home");
    }
}
