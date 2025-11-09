package Authentification;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
public class AuthentificationPageObject {
	
	// Declaration des selecteurs 
	//Defines a constant value 
	public final static String Email_XPATH="//input[@id='Email']";
	public final static String PASSWORD_XPATH="//input[@id='Password']";
	public final static String Button_XPATH="//input[@value='Log in']";
	public final static String Dashboard_XPATH="//a[normalize-space()='Log out']";	
	
	// Declaration des elements web avec l'annotation find by 
	//@FindBy annotation to map your element
	@FindBy(how = How.XPATH, using = Email_XPATH)
	public static WebElement email_Field ;
	@FindBy(how = How.XPATH, using = PASSWORD_XPATH)
	public static WebElement password_Field ;
	@FindBy(how = How.XPATH, using = Button_XPATH)
	public static WebElement buttonLogin ;
	@FindBy(how = How.XPATH, using = Dashboard_XPATH)
	public static WebElement dashboard ;
	// Declaration des methodes
	//check if the method has an input = value will be written with send keys :this method to simulate typing into an element, which may set its value.
	//void signifie que la méthode ne retourne rien. Elle exécute une action, c’est tout.
	//Un type comme String signifie que la méthode retourne une valeur que tu peux utiliser ailleurs.
	// method tnajm ta5dh input si non traja3 retour donc lazem tkoun elvalue definie fel pararametre 
	
	public void saisirMonEmail(String email){
		this.email_Field.sendKeys(email);
	}	
	
	public void saisirPassword(String username){
		this.password_Field.sendKeys(username);
	}	
	
	public void cliquerLogin(){
		this.buttonLogin.click();
	}
	
	public String getDashboard(){
		return dashboard.getText();
	}
	

}
