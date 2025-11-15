package DemoPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.*;
import utiles.ExtentManager;
import utiles.ScreenshotUtils;

public class BBC {

    public static void main(String[] args) {

        // Start Extent report
        ExtentReports extent = ExtentManager.getInstance();
        ExtentTest test = extent.createTest("BBC Title Check");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.bbc.com/arabic/topics/cv2xyrnr8dnt");

        String act_title = driver.getTitle();

        if (act_title.equals("أخبار - BBC New عربي")) {
            test.pass("Title is correct");
        } else {
            test.fail("Title incorrect");

            String screenshotPath = ScreenshotUtils.takeScreenshot(driver, "BBC_Fail");
            test.addScreenCaptureFromPath(screenshotPath);
        }

        driver.quit();
        extent.flush(); // generate the report
    }
}
