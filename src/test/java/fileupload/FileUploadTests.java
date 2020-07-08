package fileupload;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FileUploadTests extends BaseTests {

    @Test

    public void testFileUpload()
    {
        var uploadPage=homePage.clickFileUpload();
        uploadPage.uploadFile("C:\\Users\\Usuario\\Downloads\\chromedriver.exe");
        assertEquals(uploadPage.getUploadedFiles(),"chromedriver.exe","Upload file is incorrect");
    }


}
