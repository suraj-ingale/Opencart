package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegestrationPage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass{
	
	
	@Test(groups= {"Regression, Master"})
	public void verify_AccountRegistration() {
		
		try {
			
			logger.info("--- execution is started ---");
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("clicking on myAccount link..");
		hp.clickRegLink();
		logger.info("clicking on registration link..");
		
		RegestrationPage rp=new RegestrationPage(driver);
		
		logger.info("Providing the customer information..");
		rp.setFirstname(randomString(5));
		rp.setLastname(randomString(7));
		rp.setEmail(randomString(6)+"@gmail.com");
		rp.setTelephone(randomNumber(10));
		String password = randomAlphaNumeric(8);
		rp.setPassword(password);
		rp.setConfirmPass(password);
		rp.clickOnAgreeCheckBox();
		rp.clickOnContinueBtn();
		
		logger.info("validating the confiramtion messege..");
		String confirmationMsg = rp.getConfirmationMsg();
		if(confirmationMsg.equals("Your Account Has Been Created!")) {
			Assert.assertTrue(true);
		}else {
			logger.error("Test is failed..");
			logger.debug("Debug logs..");
			Assert.assertTrue(false);
		}
		
		//String confirmationMsg = rp.getConfirmationMsg();
		//Assert.assertEquals(confirmationMsg, "Your Account Has Been Created!");
		}
		catch(Exception e) {
			Assert.fail();
		}
		
		logger.info("--- execution is completed ---");
		
	}
	
	
	

}
