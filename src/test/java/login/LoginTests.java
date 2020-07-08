package login;

import base.BaseTests;
import org.testng.Assert.*;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SecureAreaPage;

import static org.testng.Assert.assertTrue;

public class LoginTests extends BaseTests {

    @Test
    public void testSuccessfulLogin(){
        LoginPage loginPage=homePage.clickFormAuthentication();
        loginPage.setUsernam("tomsmith");
        loginPage.setPasswordd("SuperSecretPassword!");
        SecureAreaPage secureAreaPage=loginPage.clickLoginButton();
        //Assert.assertEquals(secureAreaPage.getAlertText(),"You logged into a secure area! x","Alert text is incorrect");
        assertTrue(secureAreaPage.getAlertText()
                .contains("You logged into a secure area!"),
                "Alert text is incorrect");
    }

}
