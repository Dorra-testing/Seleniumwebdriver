
package Authentification;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AuthentificationPageObject {
	
	// Declaration des selecteurs 
	
	public final String USERNAME_XPATH="//input[@placeholder='Username']";
	public final String PASSWORD_XPATH="//input[@placeholder='Password']";
	public final String Button_XPATH="//button[normalize-space()='Login']";
	public final String Dashboard_XPATH="//h6[normalize-space()='Dashboard']";
		
	// Declaration des elements web avec l'annotation find by
	
	@FindBy(how = How.XPATH, using = USERNAME_XPATH)
	public WebElement username ;
	
	@FindBy(how = How.XPATH, using = PASSWORD_XPATH)
	public WebElement password ;
	
	@FindBy(how = How.XPATH, using = Button_XPATH)
	public WebElement buttonLogin ;
	
	@FindBy(how = How.XPATH, using = Dashboard_XPATH)
	public WebElement dashboard ;
	
	// Declaration des methodes
	
	public void saisirUsername(String username){
		this.username.sendKeys(username);
	}	
	
	public void saisirPassword(String password){
		this.password.sendKeys(password);
	}	
	
	public void cliquerLogin(){
		this.buttonLogin.click();
	}
	
	public String getDashboard(){
		return dashboard.getText();
	}
	
}
