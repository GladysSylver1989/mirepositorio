package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FramesPage {
    private WebDriver driver;


    public FramesPage(WebDriver driver)
    {
        this.driver=driver;
    }

    public void clickLink(String getlink)
    {
        driver.findElement(By.linkText(getlink)).click();
    }


    public NestedFramesPage clickNestedFramesPage()
    {
        clickLink("Nested Frames");
        return new NestedFramesPage(driver);
    }


}
