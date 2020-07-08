package alert;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AlertsTests extends BaseTests {

    @Test

    public void testAcceptAlert()
    {
        var alertsPage=homePage.clickJavaScriptAlerts();
        alertsPage.triggerAlert();
        alertsPage.alert_clickToacceptAlert();
        assertEquals(alertsPage.getResult(),"You successfuly clicked an alert","Results text is incorrect");
    }

    @Test
    public void testGetTextFromAlert(){
        var alertsPage= homePage.clickJavaScriptAlerts();
        alertsPage.triggerConfirm();
        String text=alertsPage.alert_getText();
        alertsPage.alert_clickToDismiss();
        assertEquals(text,"I am a JS Confirm","Alert text incorrect");
    }

    @Test
    public void testSetInputInAlert()
    {
        var alertsPage=homePage.clickJavaScriptAlerts();
        alertsPage.TriggerPromptButton();
        String text= "TAU rocks!";
        alertsPage.alert_setInput(text);
        alertsPage.alert_clickToacceptAlert();
        assertEquals(alertsPage.getResult(),"You entered: " + text,"Results text incorrect");
    }
}
