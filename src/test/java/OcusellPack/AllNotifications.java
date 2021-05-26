package OcusellPack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import cucumber.api.java.en.*;

public class AllNotifications {

	WebDriver driver = LandingPage.driver;
	@Given("Goto notification bell settings")
	public void goto_notification_bell_settings() throws InterruptedException {
	    // Here I'm clicking notification bell to see all notification in the dropdown
		
		driver.findElement(By.xpath("//*[@id=\"navbarDropdown\"]/img")).click();
		String notification = driver.findElement(By.xpath("//*[@class='notification-header']//h3")).getText();
		System.out.println("Notification name: " +notification);
	    Thread.sleep(2000);
	}

	@When("Click All notification from dropdown")
	public void click_All_notification_from_dropdown() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	    driver.findElement(By.partialLinkText("Notifications")).click();
	    Thread.sleep(2000);
	}

	@Then("Verify older and latest notifications")
	public void verify_older_and_latest_notifications() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		String actOlder = driver.findElement(By.id("older_lbl")).getText();
		System.out.println("actual older name is : " +actOlder);
		String expOlder = "Older";
		Assert.assertEquals(actOlder, expOlder);
		Thread.sleep(2000);
	}
	
	@When("^Click logout$")
	public void Click_logout() throws Throwable {
	    // Here I'm going to click logout
		driver.findElement(By.xpath("//*[@id=\"navbarDropdown\"]/span[2]")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//*[@id=\"sidebar-wrapper\"]/div/div[1]/div/a[2]/span[2]")).click();
	    Thread.sleep(2000);
	}

}
