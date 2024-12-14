package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegestrationPage extends BasePage{

	public RegestrationPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txt_firstname;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txt_lastname;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txt_email;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txt_telephone;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txt_password;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement txt_confirm_pass;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement chbox_agree;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btn_continue;
	
	@FindBy(xpath="//div[@id='content']//h1")
	WebElement confirmation_msg;
	
	public void setFirstname(String firstname) {
		txt_firstname.sendKeys(firstname);
	}
	
	public void setLastname(String lastname) {
		txt_lastname.sendKeys(lastname);
	}
	
	public void setEmail(String email) {
		txt_email.sendKeys(email);
	}
	
	public void setTelephone(String phone) {
		txt_telephone.sendKeys(phone);
	}
	
	public void setPassword(String password) {
		txt_password.sendKeys(password);
	}
	
	public void setConfirmPass(String confirmpass) {
		txt_confirm_pass.sendKeys(confirmpass);
	}
	
	public void clickOnAgreeCheckBox() {
		chbox_agree.click();
	}
	
	public void clickOnContinueBtn() {
		btn_continue.click();
	}
	
	public String getConfirmationMsg() {
		try{
			return confirmation_msg.getText();
		}catch(Exception e) {
			return e.getMessage();
		}
	}
	



}
