package Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDef {
	WebDriver driver = new ChromeDriver();
	WebDriverWait wait = new WebDriverWait(driver,2);
	public LoginPageObject LoginPO = new LoginPageObject();
		
	public LoginStepDef() {
		PageFactory.initElements(driver,LoginPO);
				/*→ cela initialise tous les éléments Web définis avec @FindBy dans LoginPO 
		        This means the WebDriver already knows about these elements from the start.
		        If we don’t initialize them beforehand, the WebDriver has to search for the elements every time, which                                                                                    
				can cause delays or errors.Using PageFactory makes everything smoother and more efficient when interacting with the page elements.*/
	}
	
	@Given("I open the application")
	public void I_open_the_application() {
	    // Write code here that turns the phrase above into concrete actions
		driver.get("https://demowebshop.tricentis.com/login");
	}

	@When("I enter the email {string}")
	public void I_enter_the_email(String email) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LoginPO.EMAIL_XPATH)));
		LoginPO.saisirEmail(email);
	}

	@When("I enter the password {string}")
	public void I_enter_the_password(String password) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LoginPO.PASSWORD_XPATH)));
		LoginPO.saisirPassword(password);
	}
	
	@When("je_clique_sur_le_boutton_login")
	public void je_clique_sur_le_boutton_login() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LoginPO.LOGIN_BUTTON_XPATH)));
		LoginPO.clickLoginButton();
	}

	@Then("I should be redirected to the URL {string}")
	public void I_should_be_redirected_to_the_url(String URL) {
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = LoginPO.EXPECTED_URL;

	    // Compare with the expected URL
	    if (!actualUrl.equals(expectedUrl)) {
	        throw new AssertionError("Expected URL: " + expectedUrl + " but was: " + actualUrl);
	    }

	    // Optional: print to console
	    System.out.println("Successfully redirected to URL: " + actualUrl);
	}

}
