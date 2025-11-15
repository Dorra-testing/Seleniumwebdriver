package DemoPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class BBC_SETUP {

	public static void main(String[] args) {//This is the entry point of every Java application — it’s where the program starts running.
		// TODO Auto-generated method stub
		
		WebDriver driver=new ChromeDriver();
		//WebDriver driver = new EdgeDriver();
		//open URL 
		driver.get("https://www.bbc.com/arabic/topics/cv2xyrnr8dnt");

		String act_title = driver.getTitle();
		
		if (act_title.equals("أخبار - BBC News عربي"))
			
		{
			System.out.println("Test Passed");
		}
		else
		{
			System.out.println("Test Failed");
		}
		
		
		

	}
}