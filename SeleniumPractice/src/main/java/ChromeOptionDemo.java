import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeOptionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      ChromeOptions option = new ChromeOptions();
      option.addArguments("--ignore-certificate-errors");
      option.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
      option.addArguments("--user-data-dir=C:\\Users\\91998\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 2");
      WebDriverManager.chromedriver().setup();
      WebDriver driver= new ChromeDriver(option);
      driver.get("https://expired.badssl.com/");
      
	}

}
