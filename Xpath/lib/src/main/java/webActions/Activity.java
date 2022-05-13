package webActions;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Activity {

	WebDriver driver = null;

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
		driver.get("https://web-locators-static-site-qa.vercel.app/Web%20Table");
		// click on the subject topper tab
		driver.findElement(By.xpath("//span[contains(text(),'Subject Topper')]")).click();
		List<WebElement> studentNameCell = driver.findElements(By.xpath(String.format("//td[text()='%s']", name)));
		if (studentNameCell.size() == 0) {
			return ""; // returning blank string as the given name was not found
		}
		WebElement studentRollNumber = studentNameCell.get(0).findElement(By.xpath("following-sibling::td"));
		return studentRollNumber.getText();
	}

	// Given a Subject, Get the highest mark obtained on that subjec
	public static String snippet_3_2(String subject, WebDriver driver) {
		driver.get("https://web-locators-static-site-qa.vercel.app/Web%20Table");
		// click on the subject topper ta
		driver.findElement(By.xpath("//span[contains(text(),'Subject Topper')]")).click();
		List<WebElement> subjectCell = driver.findElements(By.xpath(String.format("//td[text()='%s']", subject)));
		if (subjectCell.size() == 0) {
			return ""; // returning blank string as the given subject was not foun
		}
		WebElement highestMark = subjectCell.get(0).findElement(By.xpath("following-sibling::td"));
		return highestMark.getText();
	}

	// Given a Student roll number, find which subject they have topped
	public static String snippet_3_3(String rollNumber, WebDriver driver) {
		driver.get("https://web-locators-static-site-qa.vercel.app/Web%20Table");
		// click on the subject topper tab
		driver.findElement(By.xpath("//span[contains(text(),'Subject Topper')]")).click();
		List<WebElement> rollNumberCell = driver.findElements(By.xpath(String.format("//td[text()='%s']", rollNumber)));
		if (rollNumberCell.size() == 0) {
			return ""; // returning blank string as the given roll number was not found
		}
		WebElement subject = rollNumberCell.get(0).findElement(By.xpath("preceding-sibling::td[3]"));
		return subject.getText();
	}

	public static Boolean snippet_3_4(WebDriver driver) throws InterruptedException {
		driver.get("https://crio-qkart-frontend-qa.vercel.app/");
		WebElement searchbox = driver.findElement(By.xpath("//input[@name='search']"));
		searchbox.sendKeys("shoes");
		Thread.sleep(3000);
		List<WebElement> results = driver.findElements(By.xpath("//div[contains(@class,'css-sycj1h')]"));
		return results.size() == 2;

	}

	public static Boolean snippet_3_5(WebDriver driver) throws InterruptedException {
		driver.get("https://crio-qkart-frontend-qa.vercel.app/");
		WebElement searchbox = driver.findElement(By.xpath("//input[@name='search']"));
		searchbox.sendKeys("shoes");
		Thread.sleep(3000);
		WebElement sizeChartLink = driver.findElement(By.xpath("//button[text()='Size chart']"));
		sizeChartLink.click();
		Thread.sleep(3000);
		List<WebElement> ukSizes = driver.findElements(By.xpath("//tbody[contains(@class,'css-1xnox0e')]//td[2]"));
		for (WebElement ukSize : ukSizes) {
			int UK = Integer.parseInt(ukSize.getText());
			WebElement EUSize = ukSize.findElement(By.xpath("//following-sibling::td"));
			int EU = Integer.parseInt(EUSize.getText());
			assert (EU - UK == 34);
		}
		return true;

	}

	public static Boolean snippet_3_6(WebDriver driver) throws InterruptedException {
		driver.get("https://crio-qkart-frontend-qa.vercel.app/");
		WebElement searchbox = driver.findElement(By.xpath("//input[@name='search']"));
		searchbox.sendKeys("Plastic Balls");
		Thread.sleep(3000);
		// for each filled star, the below array contains 2 items in the list
		List<WebElement> starsList = driver.findElements(
				By.xpath("//img[contains(@src,'balls')]//following-sibling::div//span[contains(@class,'iconFilled')]"));
		// assert of half of the array length equals the expected star count
		return starsList.size() / 2 == 3;
	}

	public static void main(String[] args) throws InterruptedException, MalformedURLException, ParseException {

		// Create the object of Xpath class
		Activity activity = new Activity();

		// Start the browser
		WebDriver driver = activity.startBrowser();

		// Uncomment for Milestone 3 Activity
		System.out.println(snippet_3_1("Krishna", driver));
		System.out.println(snippet_3_2("HTML", driver));
		System.out.println(snippet_3_3("DPS_Grade9_19", driver));

		System.out.println(snippet_3_4(driver));
		System.out.println(snippet_3_5(driver));
		System.out.println(snippet_3_6(driver));

	}

}
