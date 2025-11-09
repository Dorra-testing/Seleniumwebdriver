package Login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPageObject {
	
	public final String EMAIL_XPATH ="//input[@id='Email']";
	public final  String PASSWORD_XPATH ="//input[@id='Password']";
	public final  String LOGIN_BUTTON_XPATH ="//input[@value='Log in']";
	public final  String EXPECTED_URL ="https://demowebshop.tricentis.com/";
	
	//*********************************************************************************
	@FindBy(how=How.XPATH,using=EMAIL_XPATH)
	public  WebElement email_field;
	
	@FindBy(how=How.XPATH,using=PASSWORD_XPATH)
	public  WebElement password_field;
	
	@FindBy(how=How.XPATH,using=LOGIN_BUTTON_XPATH)
	public   WebElement login_button;
	
	public void saisirEmail (String email) {
		this.email_field.sendKeys( email);
	}
	
	public void saisirPassword (String password) {
		this.password_field.sendKeys(password);
	}
	
	public void clickLoginButton () {
		this.login_button.click();
	}
	
	public String getUrl(){
		return EXPECTED_URL;
	}

}
