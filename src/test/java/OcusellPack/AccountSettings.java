package OcusellPack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import cucumber.api.java.en.*;

public class AccountSettings {
	
	WebDriver driver = LandingPage.driver;

	@Given("Update field")
	public void update_field() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.className("tab-list-account")).click();
		Thread.sleep(3000);
	    String expLabel = "Account Settings";
	    String actLabel = driver.findElement(By.xpath("//*[@class='admin-tab-container']//h1")).getText();
	    Assert.assertEquals(actLabel, expLabel);
	    Thread.sleep(2000);
	}

	@When("Click update button")
	public void click_update_button() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	    WebElement phone = driver.findElement(By.id("phone"));
	    phone.clear();
	    Thread.sleep(2000);
	    phone.sendKeys("1234567890");
	    Thread.sleep(2000);
	    driver.findElement(By.id("save_changes")).click();
	    Thread.sleep(2000);
	}

	@Then("Verify field is updated with recent data")
	public void verify_field_is_updated_with_recent_data() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	    String Phone = driver.findElement(By.id("phone")).getText();
	    System.out.println("Phone number is: " +Phone);
	    Thread.sleep(2000);
	}
}
