package DemoPackage;

import org.openqa.selenium.By;
//org.openqa.selenium : The main package of Selenium.
import org.openqa.selenium.WebDriver; //lets you use Selenium’s WebDriver interface to automate browsers.
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;//Go inside the org.openqa.selenium package → then inside its chrome subpackage → and use the class ChromeDriver
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//ChromeDriver : The main class that launches and controls the Chrome browser.
//Implicit Waits - An implicit wait tells WebDriver to poll/TO CHECK the DOM for a certain amount of time when trying to find any element (or elements) not immediately available. 
//Explicit Waits - Explicit wait allows you to wait for a certain condition to be met before proceeding with the next steps

public class practice {

	public static void main(String[] args) {
		
		 // create the driver 

		WebDriver driver = new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/login");
		driver.manage().window().maximize();
		String title = driver.getTitle();
		System.out.println("The page Title is: "+ title);
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement email_field,password_field,button;
		
		email_field = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Email")));
		email_field.sendKeys("dorra@gmail.com");//2️_ Use the variable to perform actions (click, type, etc.)
		
		password_field = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#Password")));
		password_field.sendKeys("dorra123");//2️_ Use the variable to perform actions (click, type, etc.)
		
		button = wait.until(ExpectedConditions.elementToBeClickable(By.className("login-button")));
		button.click();
	
		
		
	}

}
