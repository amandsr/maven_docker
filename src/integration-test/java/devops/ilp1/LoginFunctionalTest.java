package devops.ilp1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.openqa.selenium.firefox.FirefoxOptions;

import devops.ilp1.IntegrationTest;

import org.junit.*;
import static org.junit.Assert.*;

import java.io.File;

import org.junit.experimental.categories.Category;

@Category(IntegrationTest.class)
public class LoginFunctionalTest {

	static WebDriver driver;

	@BeforeClass
	public static void setup() {
	//	driver = new ChromeDriver();
		// new FirefoxDriver();
				FirefoxBinary firefoxBinary = new FirefoxBinary();
        firefoxBinary.addCommandLineOptions("--headless");
        System.setProperty("webdriver.gecko.driver", "/usr/bin/geckodriver");
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setBinary(firefoxBinary);
        
        driver = new FirefoxDriver(firefoxOptions);
	}

	@AfterClass
	public static void cleanUp() {
		driver.quit();
	}

	@Test
	public void loginSuccess() {
        driver.get("http://localhost:6080/ILP_Fancystore");
        WebElement email = driver.findElement(By.name("email"));
        WebElement pass = driver.findElement(By.name("password"));
        WebElement button = driver.findElement(By.xpath("/html/body/form/div/button"));         
        email.sendKeys("a.p@devops.com");
        pass.sendKeys("1234");
        button.click();
        assertTrue(driver.getPageSource().contains("SuccessPage"));
	}
	
	//@Test
	public void loginFail() {
        driver.get("http://localhost:6080/ILP_Fancystore");
        WebElement email = driver.findElement(By.name("email"));
        WebElement pass = driver.findElement(By.name("password"));
        WebElement button = driver.findElement(By.xpath("/html/body/form/div/button"));         
        email.sendKeys("a.p@devops.com");
        pass.sendKeys("1234566666666");
        button.click();
        assertTrue(driver.getPageSource().contains("Invalid username or password, Please try again with valid"));
	}
	
	@Test
	public void registrationSuccess() {
        driver.get("http://localhost:6080/ILP_Fancystore/register.jsp");
        WebElement firstname = driver.findElement(By.name("firstname"));
        WebElement lastname = driver.findElement(By.name("lastname"));
        WebElement confirmpass = driver.findElement(By.name("confirmpass"));
        WebElement email = driver.findElement(By.name("email"));
        WebElement pass = driver.findElement(By.name("pass"));
        WebElement button = driver.findElement(By.xpath("/html/body/form/div/button"));      
        firstname.sendKeys("fname");
        lastname.sendKeys("lname");
        pass.sendKeys("1234");
        confirmpass.sendKeys("1234");
        email.sendKeys("aa@devops.com");
        button.click();
        assertTrue(driver.getPageSource().contains("Fancy Store"));
	}
	
	@Test
	public void forgotPasswordSuccess() {
        driver.get("http://localhost:6080/ILP_Fancystore/forgotpassword.jsp");      
        WebElement confirmpass = driver.findElement(By.name("confirmpassword"));
        WebElement email = driver.findElement(By.name("email"));
        WebElement pass = driver.findElement(By.name("newpassword"));
        WebElement button = driver.findElement(By.xpath("/html/body/form/div/button"));      
        pass.sendKeys("1234");
        confirmpass.sendKeys("1234");
        email.sendKeys("a.p@devops.com");
        button.click();
        assertTrue(driver.getPageSource().contains("Fancy Store"));
	}
}
