
/*🔹 When to use cssSelector:

✅ When elements don’t have unique IDs or names
✅ When you want precise targeting
✅ When xpath becomes too long or complicated*/


package DemoPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class CSSLocators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		WebDriver driver=new ChromeDriver();
		//WebDriver driver=new FirefoxDriver();
		//open URL 
		driver.navigate().to("https://demo.nopcommerce.com/electronics");
		driver.manage().window().maximize(); // window=methode ; manage().window().maximize()=> 3methodes 
		
		// tag#id => 2 methodes
		//driver.findElement(By.cssSelector("input#small-searchterms")).sendKeys("Mac");
		//driver.findElement(By.cssSelector("#small-searchterms")).sendKeys("Mac");
		
		
		//tag.classname
		//driver.findElement(By.cssSelector("input.search-box-text")).sendKeys("Mac");
		driver.findElement(By.cssSelector(".search-box-text")).sendKeys("Mac");
		
	
	}
	
	
	
	

}
