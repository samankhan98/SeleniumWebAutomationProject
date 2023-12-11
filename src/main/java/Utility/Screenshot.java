package Utility;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Screenshot {

   String fileName = new SimpleDateFormat("MM-dd-yyyy-[HH-mm-ss]'.txt'").format(new Date());
    String FilePath= System.getProperty("user.dir")+"/Screenshot/img_"+fileName+".png";
    public void takeScreenshot(WebDriver driver) {

        try {
        TakesScreenshot scrShot =((TakesScreenshot)driver);

        //Call getScreenshotAs method to create image file

        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

        //Move image file to new destination

        File DestFile=new File(FilePath);

        //Copy file at destination
            FileUtils.copyFile(SrcFile, DestFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
