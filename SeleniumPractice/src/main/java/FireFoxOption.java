import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
//import org.openqa.selenium.firefox.FirefoxProfile;
//import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.firefox.ProfilesIni;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FireFoxOption {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
FirefoxOptions option = new FirefoxOptions();

option.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
//To Execute  the  browser  in  backend with out openeing GUI
//option.addArguments("--headleass");

//To Execute  the  browser in private Window
//option.addArguments("--private");

//This  option  is  for  to  load  all  the elements  in Normal
option.setPageLoadStrategy(PageLoadStrategy.NORMAL);

//To load  the  firefox option
//firefox.exe -p
ProfilesIni allprofile = new ProfilesIni();
  FirefoxProfile profile= allprofile.getProfile("DecProfile2023FF");
  //about:config
  profile.setPreference("dom.webnotifications.enabled", false);
  //To ignore certificate error
		profile.setAcceptUntrustedCertificates(true);
		profile.setAssumeUntrustedCertificateIssuer(false);
  option.setProfile(profile);

  WebDriverManager.firefoxdriver().setup();

WebDriver driver= new FirefoxDriver(option);
//driver.get("https://www.amazon.in/");
driver.get("https://www.axisbank.com/");


System.out.println(driver.getTitle());

	}

}
