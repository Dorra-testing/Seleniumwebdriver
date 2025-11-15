package Testlogin;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utiles.Setup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestloginStepDef {
	WebDriver driver = new ChromeDriver();
	WebDriverWait wait = new WebDriverWait(driver, 2);
	public TestloginPageObject LoginPO = new TestloginPageObject();

	public TestloginStepDef() {
		driver = Setup.driver;
		PageFactory.initElements(driver, LoginPO);

	}

	@Given("I visit the login page")
	public void I_visit_the_login_page() {
		driver.get("https://practicetestautomation.com/practice-test-login/");
	}

	@When("I enter my Username {string}")
	public void I_enter_my_username(String username) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(LoginPO.USERNAME_ID)));
		LoginPO.saisirUsername(username);
	}

	@When("I enter my Password {string}")
	public void I_enter_my_password(String password) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(LoginPO.PASSWORD_NAME)));
		LoginPO.saisirPassword(password);
	}

	@When("I click on the button Submit")
	public void I_click_on_the_button_submit() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(LoginPO.SUBMITBUTTON_XPATH)));
		LoginPO.clickLoginButton();
	}

	@Then("I will be redirected to HOME page and {string} s affiche")
	public void i_will_be_redirected_to_home_page_and_s_affiche(String resultatAttendu) {
		String resultatObtenu = LoginPO.getText();
		Assert.assertEquals(resultatObtenu, resultatAttendu);
	}

	@Then("I will receive the following message {string} s affiche")
	public void i_will_receive_the_following_message_s_affiche(String ExpectedMessage) {
		String ActualMessage = LoginPO.geterrormsg();
		switch (ExpectedMessage) {
		case "Your password is invalid!":

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LoginPO.ERROR_MESSAGE)));
			Assert.assertEquals(ExpectedMessage, ActualMessage);

			break;

		case "Your username is invalid!":
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LoginPO.ERROR_MESSAGE)));
			Assert.assertEquals(ExpectedMessage, ActualMessage);

			break;
		}

	}
}
