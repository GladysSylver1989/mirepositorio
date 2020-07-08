package forgotpassword;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.EmailSentPage;
import pages.ForgotPasswordPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ForgotPasswordTests extends BaseTests {



    @Test
    public void testForgotPassword(){
        var forgetPasswordPage = homePage.clickForgotPassword();
        var emailSentPage = forgetPasswordPage.retrievePassword("tau@example.com");
        assertEquals(emailSentPage.getMessage(),"Your e-mail's been sent!",  "Message is incorrect");
    }



}
