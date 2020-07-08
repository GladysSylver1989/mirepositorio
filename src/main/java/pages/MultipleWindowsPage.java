package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MultipleWindowsPage {

    private WebDriver driver;
    private By clickHereLink=By.linkText("Click Here");


    public MultipleWindowsPage(WebDriver driver)
    {
        this.driver=driver;
    }

    public void LinkClickHere()
    {
        //driver.findElement(By.linkText("Click Here")).click();
        driver.findElement(clickHereLink).click();

    }
}
