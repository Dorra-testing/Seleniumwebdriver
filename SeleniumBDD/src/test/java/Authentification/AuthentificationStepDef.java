package Authentification;
import java.io.IOException;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utiles.CommonMethods;
import utiles.Setup;
import utiles.WaitMethods;
public class AuthentificationStepDef {
	// Declaration des variables
	public WebDriver driver;
	public AuthentificationPageObject authPageObject = new AuthentificationPageObject();
	public CommonMethods comm = new CommonMethods();
	public WaitMethods wait = new WaitMethods();
	// Declaration des constrecteur de la classe
	public AuthentificationStepDef() {
		driver = Setup.driver;
		PageFactory.initElements(driver, AuthentificationPageObject.class);
		//PageFactory.initElements(driver, authPageObject);=> if we will use it remove static from public static WebElement password_Field ;

	}// initialliser
	@Given("je me connecte sur l'application")
	//public void means the method can be called from anywhere and it doesn’t return any result — it just performs an action.
	public void je_me_connecte_sur_l_application() /*throws IOException*/ {
		// Write code here that turns the phrase above into concrete actions
		//comm.openURLWithConfigFile("urlTest");
		driver.get("https://demowebshop.tricentis.com/login");
	}
	@When("je saisis mon email {string}")
	public void je_saisis_mon_email(String email) {
		wait.explicitWaitUntilPresenceOfElementLocatedXpath(driver, authPageObject.Email_XPATH, 10);
		authPageObject.saisirMonEmail(email);
	}

	@When("je saisis le password {string}")
	public void je_saisis_le_password(String password) {
		wait.explicitWaitUntilPresenceOfElementLocatedXpath(driver, authPageObject.PASSWORD_XPATH, 10);
		authPageObject.saisirPassword(password);
	}

	@When("je clique sur le boutton login")
	public void je_clique_sur_le_boutton_login() {
		wait.explicitWaitUntilButtonIsClickableXpath(driver, authPageObject.Button_XPATH, 20);
		authPageObject.cliquerLogin();	
	}
	@Then("je me rederige vers la page accueill et {string} s affiche")
	public void je_me_rederige_vers_la_page_accueill_et_s_affiche(String resultatAttendu) {
		String resultatObtenu = authPageObject.getDashboard();
		Assert.assertEquals(resultatObtenu, resultatAttendu);
	}

}
