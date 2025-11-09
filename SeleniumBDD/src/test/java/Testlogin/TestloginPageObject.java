package Testlogin;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class TestloginPageObject {
	
	//Decalaration des selecteurs
	public final String USERNAME_ID ="username";
	public final String PASSWORD_NAME ="password";
	public final String SUBMITBUTTON_XPATH ="//button[@id='submit']";
	public final String HOME_XPATH ="//a[normalize-space()='Home']";
	
	//Anotation FindBy + Decalaration des elements
	@FindBy(how=How.ID,using=USERNAME_ID)
	public  WebElement username_field;
	
	@FindBy(how=How.NAME,using=PASSWORD_NAME)
	public  WebElement password_field;
	
	@FindBy(how=How.XPATH,using=SUBMITBUTTON_XPATH)
	public  WebElement login_button;
	
	@FindBy(how=How.XPATH,using=HOME_XPATH)
	public  WebElement Home_element;
	
	//Decalaration des méthodes
	public void saisirUsername (String username) {
		this.username_field.sendKeys( username);
	}
	
	public void saisirPassword (String password) {
		this.password_field.sendKeys( password);
	}
	
	public void clickLoginButton () {
		this.login_button.click();
	}
	
	public String getText(){
		return Home_element.getText();
	}

}
