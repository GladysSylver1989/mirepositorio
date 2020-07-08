package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.security.Key;

public class DynamicLoadingPage {
    private WebDriver driver;
    private String linkXpath_Format=".//a[contains(text(), '%s')]";
    //private By link_example1=By.xpath("//a[contains(text(),'Example 1: Element on page that is hidden')]");
    private By link_Example1=By.xpath(String.format(linkXpath_Format, "Example 1"));
    private By link_Example2=By.xpath(String.format(linkXpath_Format, "Example 2"));

    public DynamicLoadingPage(WebDriver driver) {
        this.driver=driver;
    }

    public DynamicLoadingExample1Page clickExample1()
    {
        driver.findElement(link_Example1).click();
        return new DynamicLoadingExample1Page(driver);
    }

    public DynamicLoadingExample2Page clickExample2()
    {
        driver.findElement(link_Example2).click();
        return new DynamicLoadingExample2Page(driver);
    }

    public DynamicLoadingExample2Page rightClickOnexample2Link()
    {
        driver.findElement(link_Example2).sendKeys(Keys.CONTROL,Keys.RETURN);
        return new DynamicLoadingExample2Page(driver);
    }
}
