package OcusellPack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import cucumber.api.java.en.*;



public class Settings {
	
	WebDriver driver = LandingPage.driver;
			
	
	@Given("Goto settings page and verify title")
	public void goto_settings_page_and_verify_title() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//div[@id='sidebar-wrapper']/div/a[4]/span[2]")).click();
		Thread.sleep(2000);
		String SettingsTitle = driver.getTitle();
		System.out.println("THe page title is: " +SettingsTitle);
		Thread.sleep(2000);
	}

	@When("verify list of options")
	public void verify_list_of_options() {
	    // Write code here that turns the phrase above into concrete actions
		//admin-tab-menus
	    int sizeoflist = driver.findElements(By.xpath("//*[@class='admin-tab-menus']//child::li")).size();
		//*[@id="page-content-wrapper"]/div/div[1]/div/div[1]/ul
	    System.out.println("The lists of different settings counts are: " +sizeoflist);
	}

	@Then("Verify all links are working")
	public void verify_all_links_are_working() throws InterruptedException {
	    // Verifying notification settings link
	    
		driver.findElement(By.partialLinkText("Notification")).click();
		Thread.sleep(3000);
		//Here I'm verifying page name
		String expNotName = "Notifications Settings";
		String actNotName = driver.findElement(By.xpath("//*[contains(text(),'Notifications Settings')]")).getText();
		Assert.assertEquals(actNotName, expNotName);
		
		//Verifying Payment settings link
		driver.findElement(By.partialLinkText("Payment")).click();
		
		Thread.sleep(2000);
		
		//here I'm verifying payment page name to make sure we're standing on the right page
		String expPayName = "Payment Settings";
		String actPayName = driver.findElement(By.xpath("//*[contains(text(),'Payment Settings')]")).getText();
		Assert.assertEquals(actPayName, expPayName);
		
		Thread.sleep(3000);
	}

}
