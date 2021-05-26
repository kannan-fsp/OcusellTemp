package OcusellPack;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.*;


public class MyCollaboratePage {
	
	WebDriver driver = LandingPage.driver;

	@Given("Verify search is working good")
	public void verify_search_is_working_good() throws InterruptedException {
	    // Here I'm verifying search is good
	    //I'm going into my collaborate page
		
		//driver.findElement(By.xpath("//a[@href='https://dev.ocusell.com.farshore.net/collaborate']")).click();
		driver.findElement(By.xpath("//*[contains(text(),'Collaborate')]")).click();
		Thread.sleep(3000);
		
		WebElement CName = driver.findElement(By.id("contact_name"));
		
		Select Category = new Select(driver.findElement(By.id("categories")));
		Category.selectByValue("CLIENT");
		
		Select listing = new Select(driver.findElement(By.id("assigned_ur_listings")));
		listing.selectByValue("Downtown Cincinnati, Cincinnati, OH, USA");
		
		Thread.sleep(3000);
		
		String CountAfterSearch = driver.findElement(By.id("collaborate-table_info")).getText();
		System.out.println("Number of user matching after search: " +CountAfterSearch);
		
		Thread.sleep(2000);
		
		WebElement clear = driver.findElement(By.id("clear_all"));
		clear.click();
		
		Thread.sleep(2000);
		
		CName.sendKeys("fsp kannan");
		
		String CoolAfterSearch = driver.findElement(By.id("collaborate-table_info")).getText();
		System.out.println("Number of user matching after name search: " +CoolAfterSearch);
		
		Thread.sleep(3000);
		
		clear.click();
		
	}

	@When("Verify View and Collaborate link is there")
	public void verify_View_and_Collaborate_link_is_there() throws InterruptedException {
	    // Here I'm verifying View and collaborate texts are available on the screen
		
		WebElement CName = driver.findElement(By.id("contact_name"));
		CName.sendKeys("fsp kannan");
		
		Thread.sleep(3000);
		
	    String actViewText = driver.findElement(By.linkText("View")).getText();
	    String expViewText = "View";
	    assertEquals(actViewText, expViewText);
	    
	    String actCollaText = driver.findElement(By.linkText("Collaborate")).getText();
	    String expCollaText = "Collaborate";
	    assertEquals(actCollaText, expCollaText);
	    
	    driver.findElement(By.id("clear_all")).click();
	    
	    Thread.sleep(3000);
	}

	@Then("Verify search filter counts are showing correctly")
	public void verify_search_filter_counts_are_showing_correctly() throws InterruptedException {
	    // Here getting total counts for the table
		
		Select listing = new Select(driver.findElement(By.id("assigned_ur_listings")));
		listing.selectByValue("Downtown Cincinnati, Cincinnati, OH, USA");
		
		Thread.sleep(3000);
		
		String CoolAfterSearch = driver.findElement(By.id("collaborate-table_info")).getText();
		System.out.println("Number of user matching after search: " +CoolAfterSearch);
		System.out.println(CoolAfterSearch.charAt(31)+""+CoolAfterSearch.charAt(32));
		int i = CoolAfterSearch.length();
		System.out.println(i);
	
		Thread.sleep(3000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement next = driver.findElement(By.xpath("//*[contains(text(),'Next')]"));
		js.executeScript("arguments[0].scrollIntoView();", next);
		
		Thread.sleep(2000);
		
		String dataTable = driver.findElement(By.xpath("//*[@id=\"collaborate-table_info\"]")).getText();
		System.out.println("Data table count after next is clicked: " +dataTable);
		
		
	}
}
