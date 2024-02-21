package selenium.launch;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonFunction {
	public static WebDriver driver;
	public static String projectpath=System.getProperty("user.dir");
	public static  Properties p;
	public static  Properties mainProp;
	public static Properties childProp;
	public static FileInputStream fis;
	
	
	public static  void  init() throws IOException{
		 fis = new FileInputStream(projectpath+"\\src\\test\\resources\\browserdata.properties");

		// fis = new FileInputStream("C:\\Users\\SeleniumProject\\SeleniumPractice\\src\\test\\resources\\browserdata.properties");
		 p = new Properties();
		p.load(fis);
	//	String browser =p.getProperty("amazonurl");
//System.out.println(browser);

fis = new FileInputStream(projectpath+"\\src\\test\\resources\\env.properties");
mainProp=new Properties();
//fis = new FileInputStream("C:\\Users\\SeleniumProject\\SeleniumPractice\\src\\test\\resources\\env.properties");
mainProp.load(fis);

String e=mainProp.getProperty("env");
System.out.println(e);

fis = new FileInputStream(projectpath+"\\src\\test\\resources\\"+e+".properties");
childProp = new Properties();
childProp.load(fis);
System.out.println(childProp.getProperty("amazonurl"));


	}
	
	
	public  static void launch(String  browser) throws IOException{
		//p.load(fis);
		if( p.getProperty(browser).equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(p.getProperty(browser).equals( "firefoxbrowser")){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if(p.getProperty(browser).equals("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
	}
	public static void navigateUrl(String url) {
		driver.get(p.getProperty(url));
		//driver.get("https://www.amazon.in");
	}
	
	
}
