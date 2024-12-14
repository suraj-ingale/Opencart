package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//div[@id='content']//h2[text()='My Account']")
	WebElement myAccount_text;
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement link_logout;
	
	public boolean getMyAccountTextStatus() {
		return myAccount_text.isDisplayed();
	}
	
	public void clickLogoutLink() {
		link_logout.click();
	}

}
