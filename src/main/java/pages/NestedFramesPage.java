package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NestedFramesPage {
    private WebDriver driver;
    private String topFrame="frame-top";
    private String leftFrame="frame-left";
    private String bottonFrame="frame-bottom";
    private By body=By.tagName("body");


    public NestedFramesPage(WebDriver driver) {
        this.driver=driver;
    }


    public String getFrameText()
    {
        return  driver.findElement(body).getText();
    }

    public String getLeftFrameText()
    {
        driver.switchTo().frame(topFrame);
        driver.switchTo().frame(leftFrame);
        String text=getFrameText();
        driver.switchTo().parentFrame();
        driver.switchTo().parentFrame();
        return text;
    }

    public String getBottonFrameText()
    {
        driver.switchTo().frame(bottonFrame);
        String text=getFrameText();
        driver.switchTo().parentFrame();
        return text;
    }

}
