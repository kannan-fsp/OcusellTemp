package OcusellPack;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.*;

public class ViewCollaborate {
	
	WebDriver driver = LandingPage.driver;

	@Given("Goto view collaborate screen")
	public void goto_view_collaborate_screen() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		
		driver.findElement(By.id("clear_all")).click();
		Thread.sleep(2000);
		WebElement CName = driver.findElement(By.id("contact_name"));
		CName.sendKeys("fsp kannan");
		Thread.sleep(3000);
		
		String actViewText = driver.findElement(By.linkText("View")).getText();
	    String expViewText = "View";
	    assertEquals(actViewText, expViewText);
	    
	    WebElement view = driver.findElement(By.linkText("View"));
	    view.click();
	    
	    Thread.sleep(3000);
	}

	@When("Verify firstname and lastname of the user")
	public void verify_firstname_and_lastname_of_the_user() {
	    // Here I'm verifying firstname and lastname of the user
		
		String actFirstname = driver.findElement(By.xpath("//td[text()='fsp']")).getText();
		String expFirstname = "fsp";
		assertEquals(actFirstname, expFirstname);
		String actLastname = driver.findElement(By.xpath("//td[text()='kannan']")).getText();
		String expLastname = "kannan";
		assertEquals(actLastname, expLastname);
		
		System.out.println("Compare " +actLastname+ " and " +expLastname+ " : " +actLastname.compareTo(expLastname));
	    
	}

	@And("Verify listing assigned for that user")
	public void verify_listing_assigned_for_that_user() {
	    // Verifying assinged listings counts
		
		String actAssignedListing = driver.findElement(By.xpath("//*[@class='assigned-listing']//h4")).getText();
		String expAssignedListing = "Assigned Listing";
		if (actAssignedListing.equals("Assigned Listing"))
		{
			int len = driver.findElements(By.xpath("//*[@class='assigned-listing']//child::li")).size();
			System.out.println("Number of assigned listings for this user are: " +len);
		}
	}

	@Then("Close the window")
	public void close_the_window() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	    driver.findElement(By.xpath("//*[@id=\"viewCollaborate\"]/div/div/button/span")).click();
	    Thread.sleep(2000);
	}
}
