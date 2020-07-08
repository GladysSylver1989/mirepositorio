package window;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class WindowsTest extends BaseTests {

    @Test

    public void testWindowTabs()
    {
        var buttonPage=homePage.clickDynamicLoading().rightClickOnexample2Link();
        getWindowManager().switchToNewTab();
        assertTrue(buttonPage.isStartButtonDisplayed(),"Start button is not displayed");
    }
}
