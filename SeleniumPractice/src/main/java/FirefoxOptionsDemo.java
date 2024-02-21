

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirefoxOptionsDemo 
{

	public static void main(String[] args) 
	{
		FirefoxOptions option = new FirefoxOptions();
		option.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
		//option.addArguments("--headless");
		//option.addArguments("--private");
		option.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		
		//firefox.exe p
		ProfilesIni allprofile = new ProfilesIni();
		FirefoxProfile profile = allprofile.getProfile("DecProfile2023FF");
		
		//about:config
		
		//Webnotification handling
		profile.setPreference("dom.webnotifications.enabled", false);
	
		//To ignore certificate error
		profile.setAcceptUntrustedCertificates(true);
		profile.setAssumeUntrustedCertificateIssuer(false);
		
		//Working with Proxy Settings
		//profile.setPreference("network.proxy.type", 1);
		//profile.setPreference("network.proxy.socks", "192.168.10.1");
		//profile.setPreference("network.proxy.socks_port", 1744);
		
		option.setProfile(profile);
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver(option);
		//driver.get("https://www.amazon.in");
		driver.get("https://www.axisbank.com/");
		//driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());
		
	}

}
