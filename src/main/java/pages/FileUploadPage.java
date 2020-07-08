package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploadPage {
    private WebDriver driver;
    private By inputField=By.id("file-upload");
    private By UploadButton= By.id("file-submit");
    private By UploadFiles=By.id("uploaded-files");



    public FileUploadPage(WebDriver driver)
    {
        this.driver=driver;
    }

    public void clickUploadButton()
    {
        driver.findElement(UploadButton).click();
    }


    public void uploadFile(String absolutePathOfFile)
    {

        driver.findElement(inputField).sendKeys(absolutePathOfFile);
        clickUploadButton();
    }

    public String getUploadedFiles()
    {
        return driver.findElement(UploadFiles).getText();
    }


}
