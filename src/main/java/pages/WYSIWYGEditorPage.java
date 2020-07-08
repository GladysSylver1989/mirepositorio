package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WYSIWYGEditorPage {
    private WebDriver driver;
    private String editorIframeId="mce_0_ifr";
    private By textArea=By.id("tinymce");
    private By decreaseIndentButton=By.xpath("//i[@class='mce-ico mce-i-indent']");

    public WYSIWYGEditorPage(WebDriver driver) {
        this.driver=driver;
    }

    public void clearTextArea()
    {
       switchtoEditArea();
       driver.findElement(textArea).clear();
       switchToMainArea();

    }

    public void setTextArea(String text)
    {
        switchtoEditArea();
        driver.findElement(textArea).sendKeys(text);
        switchToMainArea();
    }

    public void switchtoEditArea()
    {
        driver.switchTo().frame(editorIframeId);
    }

    public void switchToMainArea()
    {
        driver.switchTo().parentFrame();
    }

    public String getTextFromEditor()
    {
        switchtoEditArea();
        String text=driver.findElement(textArea).getText();
        switchToMainArea();
        return text;
    }

    public void DecreaseIndentButton()
    {
        driver.findElement(decreaseIndentButton).click();
    }
}
