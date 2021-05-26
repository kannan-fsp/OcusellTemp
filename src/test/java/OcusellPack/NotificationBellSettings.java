package OcusellPack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import cucumber.api.java.en.*;

public class NotificationBellSettings {
	
	WebDriver driver = LandingPage.driver;
	@Given("Click notification bell")
	public void click_notification_bell() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	    driver.findElement(By.xpath("//*[@id=\"navbarDropdown\"]/img")).click();
	    Thread.sleep(2000);
	}

	@When("Verify notification count on the dropdown")
	public void verify_notification_count_on_the_dropdown() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	    String expNotificationLabel = "Notifications";
		String actNotificationLabel = driver.findElement(By.xpath("//*[@class='notification-header']//*[text()='Notifications']")).getText();
	    Assert.assertEquals(actNotificationLabel, expNotificationLabel);
	    Thread.sleep(2000);
	}

	@Then("Click notification settings icon on the right side of the dropdown")
	public void click_notification_settings_icon_on_the_right_side_of_the_dropdown() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	    int NotificationCount = driver.findElements(By.xpath("//*[@class='notifications-ul']//child::li")).size();
	    System.out.println("Notification count on the dropdown is: " +NotificationCount/2);
	    Thread.sleep(2000);
	    
	    //Here i'm clicking settings button on the dropdown when clicking notification dropdown
	    driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[1]/div[2]/div/div[1]/a/img")).click();
	    Thread.sleep(2000);
	}

	@And("Verify enable disable notification")
	public void verify_enable_disable_notification() throws InterruptedException {
	    
		//Here I'm verifying page name
				String expNotName = "Notifications Settings";
				String actNotName = driver.findElement(By.xpath("//*[contains(text(),'Notifications Settings')]")).getText();
				Assert.assertEquals(actNotName, expNotName);
				Thread.sleep(2000);
				
				driver.findElement(By.cssSelector("li.tab-list-notification > a")).click();
				Thread.sleep(2000);
			    driver.findElement(By.cssSelector("span.slider.round")).click();
			    Thread.sleep(2000);
			    driver.findElement(By.linkText("Ok")).click();
			    Thread.sleep(2000);
			    driver.findElement(By.cssSelector("span.slider.round")).click();
			    Thread.sleep(2000);
			    driver.findElement(By.linkText("Ok")).click();
			    Thread.sleep(2000);
//				driver.findElement(By.cssSelector("span.slider.round")).click();
//				Thread.sleep(2000);
//			    driver.findElement(By.linkText("Ok")).click();
//			    Thread.sleep(2000);
	}

}
