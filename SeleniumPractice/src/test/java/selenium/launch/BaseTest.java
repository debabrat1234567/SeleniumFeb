//package selenium.launch;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest 
{
	public static WebDriver driver;
	public static String projectpath = System.getProperty("user.dir");
	public static FileInputStream fis;
	//public static Properties p;
	/*public static Properties mainProp;
	public static Properties childProp;
	//public static Properties orProp;
	public static Properties orProp;
	*/
	/*
	public static void init() throws Exception
	{
		fis = new FileInputStream(projectpath+"\\src\\test\\resources\\data.properties");
		//FileInputStream fis = new FileInputStream("D:\\April2022WD\\December2023_6AMSeleniumBatch\\src\\test\\resources\\data.properties");
		p = new Properties();
		p.load(fis);
		//String val = p.getProperty("chromebrowser");
		//System.out.println(val);
		
		fis = new FileInputStream(projectpath+"\\src\\test\\resources\\environment.properties");
		mainProp = new Properties();
		mainProp.load(fis);
		String e = mainProp.getProperty("env");
		System.out.println(e);
		
		fis = new FileInputStream(projectpath+"\\src\\test\\resources\\"+e+".properties");
		childProp = new Properties();
		childProp.load(fis);
		String url = childProp.getProperty("amazonurl");
		System.out.println(url);
		
		fis = new FileInputStream(projectpath+"\\src\\test\\resources\\or.properties");
		orProp = new Properties();
		orProp.load(fis);
		
		
		fis = new FileInputStream(projectpath+"\\src\\test\\resources\\or.properties");
		orProp=new Properties();
		orProp.load(fis);
	}
	*/
	
	
	public static  void init() throws Exception{
	
	FileInputStream fis = new FileInputStream("C:\\Users\\SeleniumProject\\SeleniumPractice\\src\\test\\resources\\browserdata.properties");
	Properties prop= new Properties();
	prop.
	

	
	}
	public static void launch(String browser)
	{
		if(p.getProperty(browser).equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(p.getProperty(browser).equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if(p.getProperty(browser).equals("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
	}
	
	public static void navigateUrl(String url)
	{
		driver.get(childProp.getProperty(url));
	}
	/*
	public static void clickElement(String locatorKey) 
	{
		//driver.findElement(By.xpath(orProp.getProperty(locatorKey))).click();
		getElement(locatorKey).click();
	}

	public static void typeText(String locatorKey, String text) 
	{
		//driver.findElement(By.id(orProp.getProperty(locatorKey))).sendKeys(text);
		getElement(locatorKey).sendKeys(text);
	}

	public static void selectOption(String locatorKey, String option) 
	{
		//driver.findElement(By.id(orProp.getProperty(locatorKey))).sendKeys(option);
		getElement(locatorKey).sendKeys(option);
	}
	*/
	
public static void selectOption(String locatorKey,String option) {
		//driver.findElement(By.id(locator)).sendKeys(option);
	     getlocatorKey(locatorKey).sendKeys(option);
	
	//driver.findElement(By.id(orProp.getProperty(locatorKey))).sendKeys(option);
	}
	
public static void typeText(String locatorKey,String text) {
		//driver.findElement(By.name(locator)).sendKeys(text);
	//driver.findElement(By.id(orProp.getProperty(locatorKey))).sendKeys(text);
	getlocatorKey(locatorKey).sendKeys(text);
	}
	
	public static void clickElement(String locatorKey) {
		//driver.findElement(By.xpath(locator)).click();;
		
		//driver.findElement(By.xpath(orProp.getProperty(locatorKey))).click();
		getlocatorKey(locatorKey).click();
	}
	
 public static WebElement getlocatorKey(String locatorKey) {
	 WebElement element = null;
	 //Checking for  the Condtion  isElementFound
	 
	 if(!isElememtFound(locatorKey)) {
		 System.out.println("Elememt NotFound");
	 }
	 element= driver.findElement(getLocatorname(locatorKey));
	/* 
	 if(locatorKey.endsWith("_id")) {
		 element= driver.findElement(By.id(orProp.getProperty(locatorKey)));
	 }else if(locatorKey.endsWith("_name")){
		 element= driver.findElement(By.name(orProp.getProperty(locatorKey)));
	 }else if(locatorKey.endsWith("_className")){
		 element=driver.findElement(By.className(orProp.getProperty(locatorKey)));
	 }else if(locatorKey.endsWith("_cssSelector")){
		 element= driver.findElement(By.cssSelector(orProp.getProperty(locatorKey)));
	 }else if(locatorKey.endsWith("_linkText")){
		 element=driver.findElement(By.linkText(orProp.getProperty(locatorKey)));
	 }else if(locatorKey.endsWith("_partialLinkText")) {
		 element= driver.findElement(By.partialLinkText(orProp.getProperty(locatorKey)));
	 }else if(locatorKey.endsWith("_tagName")) {
		 element=driver.findElement(By.tagName(orProp.getProperty(locatorKey)));
	 }else if(locatorKey.endsWith("_xpath")) {
		 element=driver.findElement(By.xpath(orProp.getProperty(locatorKey)));
	 }else {
		 System.out.println("No Element Found");
	 }
	 */
	
	return element;
	 
 }
	
	public static boolean isElememtFound(String locatorKey) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		//wait.until(ExpectedConditions.presenceOfElementLocated(getLocatorname(locatorKey)));
		
		if(locatorKey.endsWith("_id")) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id(orProp.getProperty(locatorKey))));
		}else if(locatorKey.endsWith("_name")) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.name(orProp.getProperty(locatorKey))));
			
		}else if(locatorKey.endsWith("_className")) {
			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.className(orProp.getProperty(locatorKey))));
		}else if(locatorKey.endsWith("_xpath")) {
			//by=By.className(orProp.getProperty(locatorKey));
			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(orProp.getProperty(locatorKey))));
		}else if(locatorKey.endsWith("_css")) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(orProp.getProperty(locatorKey))));		
			}else if(locatorKey.endsWith("_linkText")) {
			//by=By.className(orProp.getProperty(locatorKey));
				wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(orProp.getProperty(locatorKey))));		

		}else if(locatorKey.endsWith("_partialLinkText")) {
			//by=By.className(orProp.getProperty(locatorKey));
			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText(orProp.getProperty(locatorKey))));		

			
			
		}else if(locatorKey.endsWith("_tagName")) {
			//by=By.className(orProp.getProperty(locatorKey));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName(orProp.getProperty(locatorKey))));		

		}
		
		//wait.until(ExpectedConditions.presenceOfElementLocated(locatorKey))
		return true;
	}
	
	public static By getLocatorname(String locatorKey) {
	
		By by= null;
		if(locatorKey.endsWith("_id")) {
			by=By.id(orProp.getProperty(locatorKey));
		}else if(locatorKey.endsWith("_name")) {
			by=By.name(orProp.getProperty(locatorKey));
		}else if(locatorKey.endsWith("_className")) {
			by=By.className(orProp.getProperty(locatorKey));
		}else if(locatorKey.endsWith("_xpath")) {
			by=By.className(orProp.getProperty(locatorKey));
		}else if(locatorKey.endsWith("_css")) {
			by=By.className(orProp.getProperty(locatorKey));
		}else if(locatorKey.endsWith("_linkText")) {
			by=By.className(orProp.getProperty(locatorKey));
		}else if(locatorKey.endsWith("_partialLinkText")) {
			by=By.className(orProp.getProperty(locatorKey));
		}else if(locatorKey.endsWith("_tagName")) {
			by=By.className(orProp.getProperty(locatorKey));
		}
		
		return by;
	}
	
	

	
	public static WebElement getElement(String locatorKey) 
	{
		WebElement element = null;
		
		//check for element Present
		if(!isElementPresent(locatorKey))
			//report as failure
			System.out.println("Element is not present : " + locatorKey );
		
		element = driver.findElement(getLocator(locatorKey));
		
		/*if(locatorKey.endsWith("_id")) {
			element = driver.findElement(By.id(orProp.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_name")) {
			element = driver.findElement(By.name(orProp.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_classname")) {
			element = driver.findElement(By.className(orProp.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_xpath")) {
			element = driver.findElement(By.xpath(orProp.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_css")) {
			element = driver.findElement(By.cssSelector(orProp.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_linktext")) {
			element = driver.findElement(By.linkText(orProp.getProperty(locatorKey)));
		}else if(locatorKey.endsWith("_partiallinktext")) {
			element = driver.findElement(By.partialLinkText(orProp.getProperty(locatorKey)));
		}*/
		return element;
	}


	public static boolean isElementPresent(String locatorKey) 
	{
		System.out.println("Checking for Element presence : " + locatorKey);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.presenceOfElementLocated(getLocator(locatorKey)));
		
		/*if(locatorKey.endsWith("_id")) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id(orProp.getProperty(locatorKey))));
		}else if(locatorKey.endsWith("_name")) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.name(orProp.getProperty(locatorKey))));
		}else if(locatorKey.endsWith("_classname")) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.className(orProp.getProperty(locatorKey))));
		}else if(locatorKey.endsWith("_xpath")) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(orProp.getProperty(locatorKey))));
		}else if(locatorKey.endsWith("_css")) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(orProp.getProperty(locatorKey))));
		}else if(locatorKey.endsWith("_linktext")) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(orProp.getProperty(locatorKey))));
		}else if(locatorKey.endsWith("_partiallinktext")) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText(orProp.getProperty(locatorKey))));
		}*/
		return true;
	}
	
	public static By getLocator(String locatorKey)
	{
		By by = null;
		
		if(locatorKey.endsWith("_id")) {
			by = By.id(orProp.getProperty(locatorKey));
		}else if(locatorKey.endsWith("_name")) {
			by = By.name(orProp.getProperty(locatorKey));
		}else if(locatorKey.endsWith("_classname")) {
			by = By.className(orProp.getProperty(locatorKey));
		}else if(locatorKey.endsWith("_xpath")) {
			by = By.xpath(orProp.getProperty(locatorKey));
		}else if(locatorKey.endsWith("_css")) {
			by = By.cssSelector(orProp.getProperty(locatorKey));
		}else if(locatorKey.endsWith("_linktext")) {
			by = By.linkText(orProp.getProperty(locatorKey));
		}else if(locatorKey.endsWith("_partiallinktext")) {
			by = By.partialLinkText(orProp.getProperty(locatorKey));
		}
		
		return by;
	}

}
