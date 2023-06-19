package webActions;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Driver;
import java.text.ParseException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity {

	WebDriver driver = null;



	public static void lunchUrl(WebDriver driver){
		driver.manage().window().maximize();
		driver.get("https://web-locators-static-site-qa.vercel.app/Web%20Table");
		driver.findElement(By.xpath("//*[text()='Static Table - Subject Topper']")).click();
	    new WebDriverWait(driver,15).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Subject Topper']")));
	}

	/**
	 * use this method to initialize the browser.
	 */
	public WebDriver startBrowser() throws MalformedURLException {
		// Code to Launch Browser using Zalenium in Crio workspace
		final DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setBrowserName(BrowserType.CHROME);
		driver = new RemoteWebDriver(new URL("http://localhost:8082/wd/hub"), capabilities);

		return driver;
	}

	// Given a student name , find their roll number
	public static String snippet_3_1(String name, WebDriver driver) {
	 lunchUrl(driver);
     String rollNumber=driver.findElement(By.xpath(String.format("//td[text()='%s']//following-sibling::td", name))).getText();
	 return rollNumber;
	}

	// Given a Subject, Get the highest mark obtained on that subjec
	public static String snippet_3_2(String subject, WebDriver driver) {
		String higestMrak= null;
		lunchUrl(driver);
		higestMrak=driver.findElement(By.xpath(String.format("//td[text()='%s']//following-sibling::td[1]", subject))).getText();
        return higestMrak;
	}

	// Given a Student roll number, find which subject they have topped
	public static String snippet_3_3(String rollNumber, WebDriver driver) {
		String subjectName=null;
        lunchUrl(driver);
		subjectName=driver.findElement(By.xpath(String.format("//td[text()='%s']//preceding-sibling::td[3]", rollNumber))).getText();
        
     return subjectName;
	}

	public static Boolean snippet_3_4(WebDriver driver) throws InterruptedException {
		boolean flag = false ;
		try{
			driver.manage().window().maximize();
			driver.navigate().to("https://crio-qkart-frontend-qa.vercel.app/");
			WebElement searchBox=driver.findElement(By.xpath("//*[@name='search'][1]"));
			searchBox.clear();
			searchBox.sendKeys("shoes");
			WebDriverWait wdw = new WebDriverWait(driver, 30);
			wdw.until(ExpectedConditions.numberOfElementsToBe(By.className("css-yg30e6"), 2));
			List<WebElement> list = driver.findElements(By.className("css-yg30e6"));
			if(list.size()==2){
				flag=true;
			}
			else {
				flag=false;
			}
		}catch(Exception e){
			System.out.println("Error at the time of seraching for product "+e.getMessage());
			return false;
		}
        try{
          WebElement sizeChartLink= driver.findElement(By.xpath("//button[text()='Size chart']"));
		  sizeChartLink.click();
		  WebDriverWait wdw = new WebDriverWait(driver, 15);
		  wdw.until(ExpectedConditions.textToBe(By.xpath("//*[contains(text(),'Size Chart')]"), "Shoe's Size Chart"));  
          List<WebElement> indiaSize =  driver.findElements(By.xpath("//tbody//tr//td[2]"));
		  List<WebElement> ukSize =  driver.findElements(By.xpath("//tbody//tr//td[3]"));
          for (int i=0 ;i<indiaSize.size();i++){
			int size1=Integer.parseInt(ukSize.get(i).getText());
			int size3=Integer.parseInt(indiaSize.get(i).getText());
			if((size1-size3)==34){
				flag=true;
			}
			else {
                 flag=false;
			}

		  }
		}catch(Exception e){
			System.out.println("Error Occur while validating size chart link"+e.getMessage());
			return false;
		}

         return flag;
	}

	public static Boolean snippet_3_5(WebDriver driver) throws InterruptedException {
		boolean flag=false;
		try{
			driver.manage().window().maximize();
			driver.navigate().to("https://crio-qkart-frontend-qa.vercel.app/");
			WebElement searchBox=driver.findElement(By.xpath("//*[@name='search'][1]"));
			searchBox.clear();
			searchBox.sendKeys("shoes");
			WebDriverWait wdw = new WebDriverWait(driver, 30);
			wdw.until(ExpectedConditions.numberOfElementsToBe(By.className("css-yg30e6"), 2));
			List<WebElement> list = driver.findElements(By.className("css-yg30e6"));
			if(list.size()==2){
				flag=true;
			}
			else {
				flag=false;
			}
		}catch(Exception e){
			System.out.println("Error at the time of seraching for product "+e.getMessage());
			return false;
		}
      return flag;
	}

	public static Boolean snippet_3_6(WebDriver driver) throws InterruptedException {
		boolean flag= false;
		try{
			driver.manage().window().maximize();
			driver.navigate().to("https://crio-qkart-frontend-qa.vercel.app/");
			WebElement searchBox=driver.findElement(By.xpath("//*[@name='search'][1]"));
			searchBox.clear();
			searchBox.sendKeys("Plastic Balls");
			WebDriverWait wdw = new WebDriverWait(driver, 30);
			wdw.until(ExpectedConditions.numberOfElementsToBe(By.className("css-yg30e6"), 1));
			String star = driver.findElement(By.className("css-1fwwzvr")).getAttribute("aria-label");
			if(star.startsWith("3")){
				flag=true;
			}
			else {
				flag=false;
			}
		}catch(Exception e){
			System.out.println("Error at the time of seraching for product "+e.getMessage());
			return false;
		}

return flag;
	}

	public static void main(String[] args) throws InterruptedException, MalformedURLException, ParseException {

		// Create the object of Xpath class
		Activity activity = new Activity();

		// Start the browser
		WebDriver driver = activity.startBrowser();

		// Uncomment for Milestone 3 Activity
		System.out.println(String.format("%s's RollNumber is -> %s", "Krishna", snippet_3_1("Krishna", driver)));
		System.out.println(String.format("Higest Mark of %s subject is -> %s", "HTML", snippet_3_2("HTML", driver)));
		System.out.println(String.format("RollNumber %s top in -> %s", "DPS_Grade9_19", snippet_3_3("DPS_Grade9_19", driver)));
		

		 System.out.println(snippet_3_4(driver));
		 System.out.println(snippet_3_5(driver));
		 System.out.println(snippet_3_6(driver));

	}

}
