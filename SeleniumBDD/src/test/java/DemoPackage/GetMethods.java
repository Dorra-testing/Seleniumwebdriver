package DemoPackage;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GetMethods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// launch new driver 
		WebDriver driver=new ChromeDriver();
		driver.get("https://practice.expandtesting.com/login#google_vignette");
		
	
		//driver.getTitle(); // will return string ; each web page has a title => inspect <title>OrangeHRM<title>
		//String Title = driver.getTitle();
		//System.out.println(Title); // or System.out.println(driver.getTitle());
		
		
		//System.out.println(driver.getCurrentUrl()); //each web page has url => https://opensource-demo.orangehrmlive.com/web/index.php/auth/login 
		
		
		//System.out.println(driver.getPageSource()); // page source
		
		
		//String windowID = driver.getWindowHandle(); // will return browser ID that will be variable each launch or refresh 
		//System.out.println(" windowID is : "+ windowID );  // 1.windowID is : 7dbbb73a-212e-4c38-91a4-adf248cd5bd9 // 2. windowID is : 8133b0da-bd7d-491c-ba30-c1fb2569bcaa
	
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		//WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("OrangeHRM, Inc")));

		
		driver.findElement(By.linkText("Buy us a coffee")).click();
		boolean linkText = driver.findElement(By.linkText("Buy us a coffee")).isDisplayed();
		System.out.println(linkText);
		
	
		Set<String> WindowIDs = driver.getWindowHandles();// set colloction not allowed duplicate and each ID has it's own value 
		System.out.println(WindowIDs);
		
		
		
		
		// window ID allowed to switch from browser to an other 
		// close browser based on our chose capture the ID and close the particualre window ID 
		//driver.quit(); //close all the opned browser 
		//driver.close(); //close the 1 browser window was opned


	}

	

}
