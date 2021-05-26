package OcusellPack;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.*;

public class SendNewInvite {

	WebDriver driver = LandingPage.driver;
	@Given("Goto send invite page")
	public void goto_send_invite_page() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	    driver.findElement(By.xpath("//*[@id=\"page-content-wrapper\"]/div/div[1]/div[1]/a")).click();
	    Thread.sleep(3000);
	}

	@When("Fill all the required fields")
	public void fill_all_the_required_fields() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		Random random = new Random();
		int x = random.nextInt(1000);
	    driver.findElement(By.id("first_name")).sendKeys("Cool"+x);
	    Thread.sleep(1000);
	    driver.findElement(By.id("last_name")).sendKeys("Kannan");
	    Thread.sleep(2000);
	    driver.findElement(By.id("email")).sendKeys("fspkannan"+x+"@mailinator.com");
	    Thread.sleep(1000);
	    Select categ = new Select(driver.findElement(By.id("category")));
	    categ.selectByVisibleText("Agents");
	    Thread.sleep(2000);
	}

	@And("Verify listing is there to assign")
	public void verify_listing_is_there_to_assign() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions //*[@id="listing_id_chosen"]/ul
	    //driver.findElement(By.xpath("//*[@id=\"listing_id_chosen\"]/ul/li")).sendKeys("Downtown Cincinnati, Cincinnati, OH, USA");	    
		driver.findElement(By.cssSelector("ul.chosen-choices")).click();
	    driver.findElement(By.xpath("//div[@id='listing_id_chosen']/div/ul/li[2]")).click();
	    
	}

	@Then("Submit the form and close the window")
	public void submit_the_form_and_close_the_window() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("invite-btn")).click();
	    Thread.sleep(3000);
	    
	    driver.findElement(By.id("close")).click();
	    Thread.sleep(2000);
	    
	}
}
