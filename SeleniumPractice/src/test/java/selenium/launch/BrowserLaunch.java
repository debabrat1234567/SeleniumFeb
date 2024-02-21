package selenium.launch;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserLaunch 
{

	public static void main(String[] args) 
	{
		WebDriver driver;
		
		
		WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver", "C:/Users/ravi/Downloads/chromedriver-win64 (1)/chromedriver-win64/chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.get("https://www.amazon.in");
		
		//webdriver.gecko.driver
		WebDriverManager.firefoxdriver().setup();
		 driver = new FirefoxDriver();
		 driver.get("https://www.bestbuy.com");
		
		//webdriver.ie.driver
		WebDriverManager.iedriver().setup();
		 driver = new InternetExplorerDriver();
		 driver.get("https://www.flipkart.com");
	}

}
