package frames;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FramesTests extends BaseTests {

    @Test
    public void testWysiwyg() {
        var editorPage = homePage.clickWYSIWYGEditorPage();
        editorPage.clearTextArea();

        String text1 = "hello ";
        String text2 = "world";

        editorPage.setTextArea(text1);
        editorPage.DecreaseIndentButton();
        editorPage.setTextArea(text2);

        assertEquals(editorPage.getTextFromEditor(), text1 + text2, "Texts from editor is incorrect");
    }

    @Test
    public void testFrameText()
    {
      var nestedFramesPage=homePage.clickFramesPage().clickNestedFramesPage();
      assertEquals(nestedFramesPage.getLeftFrameText(),"LEFT", "Left frame text incorrect");
      assertEquals(nestedFramesPage.getBottonFrameText(),"BOTTOM", "Bottom frame text incorrect");
    }


}
