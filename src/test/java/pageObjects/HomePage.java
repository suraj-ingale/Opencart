package pageObjects;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement myAccount;
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement reglink;
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement loginlink;
	
	public void clickMyAccount() {
		myAccount.click();
	}
	
	public void clickRegLink() {
		reglink.click();
	}
	
	public void clicLoginLink() {
		loginlink.click();
	}
	
	public @Nullable String getTitleOfHomePage() {
		return driver.getTitle();
	}
	
	public String getUrlOfHomePage() {
		return driver.getCurrentUrl();
	}

}
