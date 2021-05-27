package OcusellPack;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import cucumber.api.java.en.*;

public class Collaborate {

	WebDriver driver = LandingPage.driver;
	@Given("Search any user then click collaborate link")
	public void search_any_user_then_click_collaborate_link() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		
		driver.findElement(By.id("clear_all")).click();
		Thread.sleep(2000);
		WebElement CName = driver.findElement(By.id("contact_name"));
		CName.sendKeys("fsp kannan");
		
		Thread.sleep(2000);
		
		String collab = driver.findElement(By.linkText("Collaborate")).getText();
		System.out.println("collaborate name is" +collab);
		driver.findElement(By.xpath("//a[contains(text(),'Collaborate')]")).click();
		Thread.sleep(2000);
	}

	@When("Verify firstname and lastname on the popup")
	public void verify_firstname_and_lastname_on_the_popup() {
	    // Here I'm verifying fname and lnam of the user on the collaborate popup and I'm going to assign listing if it's available
		
		String actName = driver.findElement(By.xpath("//*[@class='collaborate-profile-details']//h3")).getText();
		String expName = "fsp kannan";
		Assert.assertEquals(actName, expName);
		System.out.println("Name of the user is: " +actName);
	    
	}

	@Then("Assign listing if there")
	public void assign_listing_if_there() throws InterruptedException, AWTException {
	    // Write code here that turns the phrase above into concrete actions
	    String assign = driver.findElement(By.xpath("//*[@class='assigned-listing']//*[text()='Assign Listing']")).getText();
	    System.out.println("Verify text: " +assign);
	    
	    
//	    driver.findElement(By.cssSelector("input.chosen-search-input.default")).click();
//	    Thread.sleep(2000);
//	    driver.findElement(By.id("add_listings")).submit();
//	    Thread.sleep(2000);
//	    driver.findElement(By.cssSelector("#add_listings > div.btn-sec > a.btn.light-green-color")).click();
//	    Thread.sleep(2000);
	    
	    //Here I'm getting list of items in the assign listing
	    driver.findElement(By.className("chosen-choices")).click();
	    Thread.sleep(2000);
	    List<WebElement>assignList = driver.findElements(By.xpath("//*[@class='chosen-results']//child::li"));
	    System.out.println("Assignlist count is: "+assignList.size());
	    for(int i=0;i<assignList.size();i++)
	    {
	    	String elementList = assignList.get(i).getText();
	    	String elementListAttrib = assignList.get(i).getAttribute("class");
	    	System.out.println("Attribute names are : "+elementListAttrib);
	    	System.out.println("Element list is as follows: " +elementList);
	    	Thread.sleep(5000);
	    	if(elementListAttrib.equals("active-result highlighted"))
	    	{
	    		Thread.sleep(2000);
	    		driver.findElement(By.xpath("//li[contains(@class,'active-result highlighted')]")).click();
	    		Thread.sleep(2000);
	    		driver.findElement(By.xpath("//*[@id=\"add_listings\"]/div[5]/a")).click();
	    		Thread.sleep(2000);
	    	}
	    	else
	    	{
	    		System.out.println("There was no listing to assign");
	    	}
	    }
	    
	    driver.findElement(By.cssSelector("#newCollaborate > div.modal-dialog.modal-dialog-centered > div.modal-content > button.close > span")).click();
	    Thread.sleep(2000);
	}

	@And("Verify assigned listing is displayed on My collaborators page")
	public void verify_assigned_listing_is_displayed_on_My_collaborators_page() {
	    //Need to implement more
		
		System.out.println("Verified it's assigned");
	}
}
