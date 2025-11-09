package DemoPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Exercice {

    public static void main(String[] args) {

        // Définir manuellement le chemin vers ChromeDriver
        //System.setProperty("webdriver.chrome.driver", "C:\\Automation\\drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.orangehrm.com/");

        System.out.println("Titre de la page : " + driver.getTitle());

        //driver.quit();
    }
}
