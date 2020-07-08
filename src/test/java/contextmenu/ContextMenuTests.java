package contextmenu;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ContextMenuTests extends BaseTests {

    @Test

    public void testContextMenu()
    {
        var contextmenu=homePage.clickContextMenu();
        contextmenu.RightClick();
        String message=contextmenu.getPopUpText();
        contextmenu.acceptPopUp();
        assertEquals(message,"You selected a context menu","Popup message incorrect");

    }
}
