package ValidSearch;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ValidSearchStepDef {
	
	WebDriver driver = new ChromeDriver();
	WebDriverWait wait = new WebDriverWait(driver,2);
	public ValidSearchPageObject PO = new ValidSearchPageObject();
		
	public ValidSearchStepDef() {
		PageFactory.initElements(driver,PO);

	}
	
	
	@Given("I visit the automation exercise page")
	public void i_visit_the_automation_exercise_page() {
		driver.get("https://automationexercise.com/products");
	}

	@When("I enter my Search store {string}")
	public void i_enter_my_search_store(String SearchedComponent) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PO.SEARCH_FIELD)));
		PO.saisirUsername(SearchedComponent);
	    
	}

	@And("I click on the button Search")
	public void i_click_on_the_button_search() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PO.SEARCH_BUTTON))); 
		PO.clickSearchButton();


	}

	
	@Then("I see {string}")
	public void I_see(String ExpectedResult) {
		String ResultatObtenu = PO.getText();
		Assert.assertEquals(ResultatObtenu, ExpectedResult);
	}

}
