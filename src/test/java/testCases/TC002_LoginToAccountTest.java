package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginToAccountTest extends BaseClass{

	@Test(groups= {"Sanity, Master"})
	public void verify_Login() {
		
		try {
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clicLoginLink();
		
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(getProperties("email"));
		lp.setPassword(getProperties("password"));
		//lp.setPassword("suraj123");
		lp.clickLoginBtn();
		
		MyAccountPage mp=new MyAccountPage(driver);
		
		boolean status = mp.getMyAccountTextStatus();
		Assert.assertEquals(status, true);
		}catch(Exception e) {
			Assert.fail();
		}
	}
}
