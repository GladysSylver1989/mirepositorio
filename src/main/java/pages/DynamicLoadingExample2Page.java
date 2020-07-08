package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicLoadingExample2Page {
    private WebDriver driver;
    private By buttonStart=By.tagName("button");
    private By indicatorLoading=By.cssSelector("#loading");
    private By loadedText=By.id("finish");

    public DynamicLoadingExample2Page(WebDriver driver)
    {
        this.driver=driver;
    }


    public void clickOnButtonStart()
    {
        driver.findElement(buttonStart).click();
        WebDriverWait wait=new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.presenceOfElementLocated(loadedText));
    }

    public boolean isStartButtonDisplayed()
    {
        return driver.findElement(buttonStart).isDisplayed();
    }

    public String getLoadedText()
    {
        return driver.findElement(loadedText).getText();
    }



}
