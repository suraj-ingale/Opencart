package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import testBase.BaseClass;

public class TC004_HomePageTitleAndUrlTest extends BaseClass{

	@Test(groups= {"Regression, Master"})
	public void verifyHomepageTitleAndUrl() {
		try {
			
			HomePage hp=new HomePage(driver);
			
			if(hp.getTitleOfHomePage().equals("Your Store") && hp.getUrlOfHomePage().equals("https://tutorialsninja.com/demo/")) {
				Assert.assertTrue(true);
			}else {
				Assert.assertTrue(false);
			}
			
		}
		catch(Exception e) {
			Assert.fail();
		}
	}
}
