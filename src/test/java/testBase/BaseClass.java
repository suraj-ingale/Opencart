package testBase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	public static WebDriver driver;
	public Logger logger;
	public Properties prop;
	
	@BeforeClass(groups= {"Sanity", "Regression", "Master"})
	@Parameters({"os", "browser"})
	public void setUp(String os, String br) {
		
		logger=LogManager.getLogger(this.getClass());
		
		if(getProperties("execution_env").equalsIgnoreCase("remote")) {
			
			DesiredCapabilities cap=new DesiredCapabilities();
			
			//for os
			if(os.equalsIgnoreCase("windows")) {
				cap.setPlatform(Platform.WIN10);
			}
			else if(os.equalsIgnoreCase("mac")) {
				cap.setPlatform(Platform.MAC);
			}
			else if(os.equalsIgnoreCase("linux")) {
				cap.setPlatform(Platform.LINUX);
			}
			else {
				System.out.println("No matching os..");
				return;
			}
			
			//for browser
			switch(br) {
			case "chrome": cap.setBrowserName("chrome");break;
			case "edge": cap.setBrowserName("MicrosoftEdge");break;
			case "firefox": cap.setBrowserName("firefox");break;
			default : System.out.println("No matching browser..");return;
			}
			
			try {
				URI uri=new URI("http://192.168.45.154:4444/wd/hub");
				driver=new RemoteWebDriver(uri.toURL(), cap);
			} catch (MalformedURLException | URISyntaxException e) {
				e.printStackTrace();
			}
		}
		
		if(getProperties("execution_env").equalsIgnoreCase("local")) {
		
		switch(br.toLowerCase()) {
		case "chrome": driver=new ChromeDriver(); break;
		case "edge": driver=new EdgeDriver(); break;
		case "firefox": driver=new FirefoxDriver(); break;
		default: System.out.println("invlid browser.."); return;
		}
		
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		
		driver.get(getProperties("appurl_2"));
	}
	
	@AfterClass(groups= {"Sanity", "Regression", "Master"})
	public void tearDown() {
		driver.quit();
	}
	
	public String getProperties(String name)  {
		try {
			FileReader reader=new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
			prop=new Properties();
			prop.load(reader);
			return prop.getProperty(name);
		} catch (IOException e) {
			
			return e.getMessage();
		}
		
	}
	
	public String randomString(int length) {
		String randomstring = RandomStringUtils.secure().nextAlphabetic(length);
		
		return randomstring;
	}
	
	public String randomNumber(int length) {
		String randomnumber = RandomStringUtils.secure().nextNumeric(length);
		return randomnumber;
	}
	
	public String randomAlphaNumeric(int length) {
		String random_alphanumeric = RandomStringUtils.secure().nextAlphanumeric(length);
		return random_alphanumeric+"@";
	}
	
	public String CaptureScreen(String testname) throws IOException{
		String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		
		String targetfilepath=System.getProperty("user.dir")+"\\screenshots\\"+testname+"_"+timeStamp+".png";
		File targetFile = new File(targetfilepath);
		
		sourceFile.renameTo(targetFile);
		
		return targetfilepath;
	}
	

}
