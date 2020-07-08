package base;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.EmailSentPage;
import pages.HomePage;
import utils.CookieManager;
import utils.EventReporter;
import utils.WindowManager;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BaseTests {


    private EventFiringWebDriver driver;
    protected HomePage homePage;


    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
       // System.setProperty("webdriver.chrome.driver", "C:\\Webdrivers\\Chrome\\chromedriver.exe");
        driver=new EventFiringWebDriver(new ChromeDriver(getChromeOptions()));
        //Alternately, this can be done as:
       //driver = new ChromeDriver(getChromeOptions());
        driver.register(new EventReporter());
        //driver.manage().timeouts().pageLoadTimeout(5,TimeUnit.SECONDS);
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        goHome();
        setCookie();



    }
        @BeforeMethod
        public void goHome()
        {
            driver.get("https://the-internet.herokuapp.com/");
            homePage=new HomePage(driver);
        }


        //driver.manage().window().fullscreen();
       // driver.manage().window().setSize(new Dimension(375,812));

        /*List<WebElement> links=driver.findElements(By.tagName("a"));
        System.out.println(links.size());

        WebElement inputsLink=driver.findElement(By.linkText("Inputs"));
        inputsLink.click();*/

       /* WebElement link1=driver.findElement(By.linkText("Shifting Content"));
        link1.click();

        WebElement menuelement=driver.findElement(By.xpath("//a[contains(text(),'Example 1: Menu Element')]"));
        menuelement.click();

         List<WebElement>linkenes=driver.findElements(By.tagName("li"));
         System.out.println("Number of menu items: " + linkenes.size());

        System.out.println(driver.getTitle());*/




            @AfterClass
            public  void tearDown()
            {
                driver.quit();
            }

            @AfterMethod
            public void recordFailure(ITestResult result)
            {
                if(ITestResult.FAILURE==result.getStatus()) {
                    var camera = (TakesScreenshot) driver;
                    File screenshot = camera.getScreenshotAs(OutputType.FILE);
                    //System.out.println("Screenshot taken: " + screenshot.getAbsolutePath());

                    try {
                        Files.move(screenshot, new File("src\\main\\resources\\screenshots\\" + result.getName() + ".png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }

            public WindowManager getWindowManager(){
                return new WindowManager(driver);
            }

            private ChromeOptions getChromeOptions()
            {
                ChromeOptions options=new ChromeOptions();
                options.addArguments("disable-infobars");
                //options.setHeadless(true);
                return options;
            }

            private void setCookie()
            {
                Cookie cookie=new Cookie.Builder("tau","123")
                        .domain("the-internet.herokuapp.com")
                        .build();
                driver.manage().addCookie(cookie);

            }

            public CookieManager getCookieManager()
            {
                return new CookieManager(driver);
            }

  /* public static void main(String args[]) {
       BaseTests test = new BaseTests();
       test.setUp();}*/





}
