package OcusellPack;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.*;

public class LandingPage {

	public static WebDriver driver;
	
	@Given("^Launch browser and load dev server URL$")
	public void launch_browser_and_load_dev_server_URL() throws Throwable 
	
	{
		
		System.setProperty("webdriver.gecko.driver", "C:/Users/FE13264/Documents/Softwares/geckodriver-v0.28.0-win64/geckodriver.exe");
	    // Here Launching Firefox browser and url of the application
		driver = new FirefoxDriver();
		driver.get("http://dev:graPB7E4@dev.ocusell.com.farshore.net/");
		
	}
	
	public void headerscroll() throws InterruptedException
	
	{
		//Here I'm going back to header section
		
		WebElement head = driver.findElement(By.className("header"));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", head); 
		Thread.sleep(2000);
	}

	@When("^Verify links are working$")
	public void verify_links_are_working() throws Throwable 
	
	{
	    //Here I'm verifying the landing page links are working
		Thread.sleep(3000);
		String actTitle = driver.getTitle();
		String expTitle = "Home Page | Ocusell | Ocusell";
		assertEquals(actTitle, expTitle);
		
		driver.findElement(By.xpath("//a[@href='#how-it-works-sec']")).click();
		Thread.sleep(2000);
		
		//LandingPage land = new LandingPage();
		//land.headerscroll();		
		headerscroll();
				
		driver.findElement(By.xpath("//a[@href='#price_sec']")).click();
		
		Thread.sleep(2000);
		//Here verifying single account price values
		String actSingle = driver.findElement(By.xpath("//*[@class='pricing-head']//*[text()='Single Agent']")).getText();
		String expSingle = "SINGLE AGENT";
		assertEquals(actSingle, expSingle);
		
		//Verifying price values in single agent account
		//*[@id=\"price_sec\"]/div/div/div/div/ul/li[1]/div[2]/div[1]/h3
			String actPrice = driver.findElement(By.xpath("//*[@class='price-body-blk']//h3")).getText();
			String expPrice = "$85/mo";
			assertEquals(actPrice, expPrice);
			System.out.println("Comparing actual price and expected price: " +actPrice+ " " + expPrice);
			
			//Here I'm clicking contact menu from the header.
			//driver.findElement(By.xpath("//a[@href='mailto:test@gmail.com?subject=Contact from the Ocusell app']")).click();
	}
	//*[@id="price_sec"]/div/div/div/div/div/label/span
	@Then("^Verify yearly price$")
	public void Verify_yearly_price() throws Throwable {
	    // Here I'm verifying yearly price for Single Agent
		driver.findElement(By.xpath("//*[@id=\"price_sec\"]/div/div/div/div/div/label")).click();
		Thread.sleep(2000);
		String actPrice = driver.findElement(By.xpath("//*[@class='price-body-blk']//h3")).getText();
		String expPrice = "$765.00/an";
		assertEquals(actPrice, expPrice);
		System.out.println("Verify year price for actual and expected: " +actPrice+ " " +expPrice);
		headerscroll();
		Thread.sleep(2000);
	}
}
