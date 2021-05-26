package OcusellPack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import cucumber.api.java.en.*;

public class EditCollaborate {
	
	WebDriver driver = LandingPage.driver;

	@Given("Goto view collaborate page")
	public void goto_view_collaborate_page() throws InterruptedException {
	    // Here I'm opening view popup from my collaborate screen
		driver.findElement(By.id("clear_all")).click();
		Thread.sleep(2000);
		WebElement CName = driver.findElement(By.id("contact_name"));
		CName.sendKeys("fsp kannan");
		
		Thread.sleep(2000);
		
		driver.findElement(By.linkText("View")).click();
		Thread.sleep(3000);
	}

	@When("Edit contact and update")
	public void edit_contact_and_update() throws InterruptedException {
	    // Clicking edit contact button and updating info
		//*[@id="my-collaborate-view"]/div[5]/a[1]
		driver.findElement(By.xpath("//*[contains(text(),'Edit Contact')]")).click();
		Thread.sleep(2000);
		WebElement firstName = driver.findElement(By.id("edit_first_name"));
		firstName.clear();
		Thread.sleep(2000);
		
	    firstName.sendKeys("fsp-edit");
	    Thread.sleep(2000);
	    
	    driver.findElement(By.id("edit_invite-btn")).click();
	    Thread.sleep(2000);
	    
	    driver.findElement(By.id("edit_close")).click();
	    Thread.sleep(3000);
	    
	    WebElement CName = driver.findElement(By.id("contact_name"));
	    CName.clear();
	    Thread.sleep(2000);
	    
	    CName.sendKeys("fsp-edit kannan");
	    Thread.sleep(2000);
	    String expName = "fsp-edit kannan";
	    String actName = driver.findElement(By.xpath("//*[@id=\"collaborate-table\"]/tbody/tr[1]/td[1]")).getText();
	    Assert.assertEquals(actName.toLowerCase(), expName);
	  
	}

	@When("Verify details are updated on the my collaborate page")
	public void verify_details_are_updated_on_the_my_collaborate_page() throws InterruptedException {
	    // Here I'm verifying things are updated
		
		Thread.sleep(2000);
		
		driver.findElement(By.linkText("View")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[contains(text(),'Edit Contact')]")).click();
		Thread.sleep(2000);
		WebElement firstName = driver.findElement(By.id("edit_first_name"));
		firstName.clear();
		Thread.sleep(2000);
		
		firstName.sendKeys("fsp");
	    Thread.sleep(2000);
	    
	    driver.findElement(By.id("edit_invite-btn")).click();
	    Thread.sleep(2000);
	    
	    driver.findElement(By.id("edit_close")).click();
	    Thread.sleep(2000);
	    WebElement CName = driver.findElement(By.id("contact_name"));
	    CName.clear();
	    Thread.sleep(2000);
	    CName.sendKeys("fsp kannan");
	    Thread.sleep(2000);
	    
	    String expName = "fsp kannan";
	    String actName = driver.findElement(By.xpath("//*[@id=\"collaborate-table\"]/tbody/tr[1]/td[1]")).getText();
	    Assert.assertEquals(actName.toLowerCase(), expName);
	    System.out.println("Compare " +actName.toLowerCase()+ " and " +" : " +expName+ " " +actName.compareTo(expName));
	}
}
