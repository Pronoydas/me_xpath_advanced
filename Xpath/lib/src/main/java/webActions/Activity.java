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
	
	}

	// Given a Subject, Get the highest mark obtained on that subjec
	public static String snippet_3_2(String subject, WebDriver driver) {
	
	}

	// Given a Student roll number, find which subject they have topped
	public static String snippet_3_3(String rollNumber, WebDriver driver) {

	}

	public static Boolean snippet_3_4(WebDriver driver) throws InterruptedException {

	}

	public static Boolean snippet_3_5(WebDriver driver) throws InterruptedException {

	}

	public static Boolean snippet_3_6(WebDriver driver) throws InterruptedException {

	}

	public static void main(String[] args) throws InterruptedException, MalformedURLException, ParseException {

		// Create the object of Xpath class
		Activity activity = new Activity();

		// Start the browser
		WebDriver driver = activity.startBrowser();

		// Uncomment for Milestone 3 Activity
		// System.out.println(snippet_3_1("Krishna", driver));
		// System.out.println(snippet_3_2("HTML", driver));
		// System.out.println(snippet_3_3("DPS_Grade9_19", driver));

		// System.out.println(snippet_3_4(driver));
		// System.out.println(snippet_3_5(driver));
		// System.out.println(snippet_3_6(driver));

	}

}
