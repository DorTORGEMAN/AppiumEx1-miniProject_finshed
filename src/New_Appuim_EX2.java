import com.aventstack.extentreports.MediaEntityBuilder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.android.AndroidDriver;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;

import com.aventstack.extentreports.MediaEntityModelProvider;

public class New_Appuim_EX2 {
    static AndroidDriver driver;
    public static ExtentReports extent;
    public static ExtentTest myTests;
    private static String reportFilePath="C:/Users/power play/IdeaProjects/AppiumEx1/testReport.html";
    public static DesiredCapabilities capabilities=new DesiredCapabilities();


    @BeforeClass
    public static void setup_Appuim() throws IOException {
        extent =new ExtentReports(reportFilePath);
        myTests=extent.startTest("test calculator");
        Information_Report.APP_Appuim("calculator");
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub/"), capabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }




    ////////Tests//////
    @Test
    public void Test1_Search(){

        WebElement ENTER= driver.findElement(By.id("com.android.chrome:id/signin_fre_continue_button"));
        ENTER.click();
        driver.findElement(By.className("android.widget.Button")).click();
        driver.findElement(By.id("com.android.chrome:id/negative_button")).click();
        WebElement Search=driver.findElement(By.id("com.android.chrome:id/search_box_text"));
        Search.click();
        WebElement Search1=driver.findElement(By.id("com.android.chrome:id/url_bar"));
        Search1.sendKeys("GOOGLE");
        driver.findElement(By.id("com.android.chrome:id/line_1")).click();
        driver.findElement(By.xpath("//android.view.View[@index='1'][@text='Google']")).click();
    }
    @Test
    public void Test2_calculator_miniProject() throws Exception {
        myTests = extent.startTest("Test 2:calculator_miniProject ");
     myTests.log(LogStatus.INFO, "Test started", "Details: Test 2:calculator_miniProject");
     String formFileNine=Information_Report.DataFromFiles("nine"); /// take number from file
     // int Nine=Integer.parseInt(formFileNine); /// change string to int
     String formFileSeven=Information_Report.DataFromFiles("seven"); /// take number from file
     //int Seven=Integer.parseInt(formFileSeven);// change string to int
     WebElement Editor_Formula= driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_edt_formula"));
     // Editor_Formula.sendKeys(Seven+""+Nine);/// FOR CHECK IF Number in File working and check if them send to calculator
     WebElement sumButton= driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_equal"));
     Editor_Formula.sendKeys(formFileNine);// send 9 from file
     Information_Report.calculator_FORMULA("plus");//click on Formula equations
     Information_Report.NUMBER_FORMULA("seven");//click on 7 in calculator
     /// Editor_Formula.sendKeys(formFileSeven);// send 7 from file
     // Editor_Formula.sendKeys(String.valueOf(Seven));// send value of int
     Information_Report.Assert_RESULTED("plus");///Assert check if result is right \\Assert_RESULTED must be match to calculator_FORMULA//
    sumButton.click();//click on sum
     myTests.log(LogStatus.INFO, MediaEntityBuilder.createScreenCaptureFromPath(Information_Report.takeScreenshot
             ("C:/Users/power play/IdeaProjects/AppiumEx1/ScreenShotTEST/"+System.currentTimeMillis())).build().toString());

    }




    @AfterClass
    public static void tearDown()throws InterruptedException,IOException,IllegalArgumentException{
    Thread.sleep(2000);
    driver.quit();
    extent.flush();
    extent.endTest(myTests);
    }


}
