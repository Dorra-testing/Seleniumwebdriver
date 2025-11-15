package utiles;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class ChromeDriverManager extends DriverManager {

    @Override
    public void createDriver() {
        ChromeOptions options = new ChromeOptions();

        // Optional: set to true for CI/CD headless, false for local debugging
        boolean headless = false; // <-- change to true for CI/CD
        options.setHeadless(headless);

        // Optional: start maximized
        options.addArguments("--start-maximized");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-popup-blocking");
        options.setAcceptInsecureCerts(true);

        // Path to chromedriver.exe (adjust if needed)
        System.setProperty("webdriver.chrome.driver",
                "src/test/resources/drivers/chromedriver.exe");

        // Assign to the inherited driver field
        driver = new ChromeDriver(options);
    }

    @Override
    public void startService() {
        // Not strictly needed with WebDriverManager, can implement if required
    }

    @Override
    public void stopService() {
        if (driver != null) {
            driver.quit();
        }
    }
}
