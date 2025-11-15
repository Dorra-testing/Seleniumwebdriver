package utiles;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.ByteArrayOutputStream;
import java.io.File;

public class Setup {

    public static WebDriver driver; //driver هنا static يعني كائن واحد يتشارك بين كل الكلاسات.
    static DriverManager driverManager;

    @Before
    public void setup() {
        // Initialize Chrome driver using your DriverManagerFactory
        driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
        driver = driverManager.getDriver();
    }

    @After
    public void embedScreenshot(Scenario scenario) {

        try {
            // Wait until page body is visible
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));

            // Take full-page screenshot using AShot
            Screenshot screenshot = new AShot()
                    .shootingStrategy(ShootingStrategies.viewportPasting(100))
                    .takeScreenshot(driver);

            // Save screenshot locally
            File destFile = new File("screenshots/" + scenario.getName() + ".png");
            destFile.getParentFile().mkdirs(); // create folder if not exists
            ImageIO.write(screenshot.getImage(), "PNG", destFile);

            // Attach screenshot to Cucumber report
            scenario.attach(screenshotToByteArray(screenshot), "image/png", scenario.getName());

            System.out.println("✅ Screenshot saved: " + destFile.getAbsolutePath());

        } catch (Exception e) {
            System.out.println("⚠️ Unable to capture screenshot: " + e.getMessage());
        } finally {
            // Quit browser
            if (driver != null) {
                driver.quit();
            }
        }
    }

    // Helper method to convert AShot Screenshot to byte[]
    private byte[] screenshotToByteArray(Screenshot screenshot) throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(screenshot.getImage(), "PNG", baos);
        return baos.toByteArray();
    }
}