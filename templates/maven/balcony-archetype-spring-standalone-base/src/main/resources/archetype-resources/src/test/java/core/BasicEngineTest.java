#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.core;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BasicEngineTest {

    private BasicEngine underTest;

    @BeforeMethod
    public void beforeMethod() {
        underTest = new BasicEngine();
    }

    @Test
    public void runShould() {
        // GIVEN
        // WHEN
        underTest.run();
        // THEN
    }

}
