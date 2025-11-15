package utiles;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtils {

    public static String takeScreenshot(WebDriver driver, String name) {

        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String path = "target/screenshots/" + name + ".png";
            FileHandler.copy(src, new File(path));
            return path;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
