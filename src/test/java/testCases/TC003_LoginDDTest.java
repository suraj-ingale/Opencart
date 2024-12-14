package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDTest extends BaseClass {
	
	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class, groups="Datadriven")
	public void verify_Login(String email, String pass, String res) {
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clicLoginLink();
		
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(pass);
		lp.clickLoginBtn();
		
		MyAccountPage mp=new MyAccountPage(driver);
		
		boolean status = mp.getMyAccountTextStatus();
		if(res.equalsIgnoreCase("valid")) {
			if(status==true) {
				mp.clickLogoutLink();
				Assert.assertTrue(true);
			}else {
				Assert.assertTrue(false);
			}

		}
		if(res.equalsIgnoreCase("invalid")) {
			if(status==true) {
				mp.clickLogoutLink();
				Assert.assertFalse(false);
			}else {
				Assert.assertTrue(true);
			}
		}
	}
		
}
