package ValidSearch;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ValidSearchPageObject {
	
	
	
	//Decalaration des selecteurs
		public final String SEARCH_FIELD ="//input[@id='search_product']";
		public final String SEARCH_BUTTON ="//button[@id='submit_search']";
		public final String SEARCHED_RESULT ="//div[@class='overlay-content']//p[contains(text(),'Premium Polo T-Shirts')]";
		
		//Anotation FindBy + Decalaration des elements
		@FindBy(how=How.XPATH,using=SEARCH_FIELD)
		public WebElement search_field;
		
		@FindBy(how=How.XPATH,using=SEARCH_BUTTON)
		public  WebElement search_button;
		
		@FindBy(how=How.XPATH,using=SEARCHED_RESULT)
		public  WebElement searched_result;
		
		public void saisirUsername (String username) {
			this.search_field.sendKeys( username);
		}
		
		public void clickSearchButton () {
			this.search_button.click();
		}
		
		public String getText(){
			return searched_result.getText();
		}

}
