package Authentification;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utiles.WaitMethods;
import utiles.Setup;
public class AuthentificationStepDef {
	
	
	
	// Declaration des variables 
	public WebDriver driver ;
	public  AuthentificationPageObject  AuthPageObject = new AuthentificationPageObject();
	public WaitMethods wait = new  WaitMethods();

	//Declaration des constrecteur de la classe
	public AuthentificationStepDef () {
		driver = Setup.driver;                             // hné nasta3mlou le driver li initialize fi Setup
		PageFactory.initElements(driver, AuthPageObject);	
	}
	
	@Given("je me connecte sur l'application")
	public void je_me_connecte_sur_l_application() {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	@When("je saisis le username {string}")
	public void je_saisis_le_username(String username) {
		wait.explicitWaitUntilPresenceOfElementLocatedXpath(driver, AuthPageObject.USERNAME_XPATH,20);
		AuthPageObject.saisirUsername(username);
	}

	@When("je saisis le password {string}")
	public void je_saisis_le_password(String password) {
		wait.explicitWaitUntilPresenceOfElementLocatedXpath(driver, AuthPageObject.PASSWORD_XPATH,10);
		AuthPageObject.saisirPassword(password);
	}

	@When("je clique sur le boutton login")
	public void je_clique_sur_le_boutton_login() {
		wait.explicitWaitUntilButtonIsClickableXpath(driver, AuthPageObject.Button_XPATH,10);
		AuthPageObject.cliquerLogin();
	}

	@Then("je me rederige vers la page accueill et {string} s affiche")
	public void je_me_rederige_vers_la_page_accueill_et_s_affiche(String resultatAttendu) {
		wait.explicitWaitUntilButtonIsClickableXpath(driver, AuthPageObject.Dashboard_XPATH,10);
		String resultatObtenu = AuthPageObject.getDashboard();
		Assert.assertEquals(resultatObtenu, resultatAttendu);

	}
}
