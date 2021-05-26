package OcusellPack;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.*;

public class PaymentSettings {
	
	WebDriver driver = LandingPage.driver;

	@Given("Goto payment settings page")
	public void goto_payment_settings_page() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.partialLinkText("Payment")).click();
		Thread.sleep(2000);
	}

	@When("Verify current plan and verify cancel plan")
	public void verify_current_plan_and_verify_cancel_plan() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	    String planName = driver.findElement(By.xpath("//*[@id=\"user_plan_details\"]//h3")).getText();
	    System.out.println("Name of the plan is: " +planName);
	    String expName = "Single Agent";
	    if(planName.equals(expName))
	    {
	    	JavascriptExecutor js = (JavascriptExecutor) driver;
	    	js.executeScript("alert('You have' + ' '+'"+planName+"'+' account')");
	    	Thread.sleep(3000);
		    driver.switchTo().alert().accept();
		    Thread.sleep(2000);
	    }
	    else {
	    	JavascriptExecutor js = (JavascriptExecutor) driver;
	    	js.executeScript("alert('You dont have any active account')");
	    	Thread.sleep(3000);
		    driver.switchTo().alert().accept();
		    Thread.sleep(2000);
	    }
	}

	@Then("Verify change card")
	public void verify_change_card() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		//First checking the last four digit of the card added.
		String actCardNumber = driver.findElement(By.xpath("//*[@class='card-number']//span")).getText();
		String expCardNumber1 = "**** **** **** 4242";
		String expCardNumber2 = "**** **** **** 1111";
		if(actCardNumber.equals("**** **** **** 4242"))
		{
				
	    driver.findElement(By.linkText("Change")).click();
	    Thread.sleep(2000);
	    WebElement nameOnCard = driver.findElement(By.id("name_on_card"));
	    nameOnCard.sendKeys("Kannan");
	    Thread.sleep(2000);
	    WebElement cardNumber = driver.findElement(By.id("cc_number"));
	    cardNumber.sendKeys("4111");
	    Thread.sleep(2000);
	    cardNumber.sendKeys("1111");
	    Thread.sleep(2000);
	    cardNumber.sendKeys("1111");
	    Thread.sleep(2000);
	    cardNumber.sendKeys("1111");
	    Thread.sleep(2000);
	    WebElement exp = driver.findElement(By.id("cc_exp"));
	    exp.sendKeys("02");
	    exp.sendKeys("24");
	    driver.findElement(By.id("cc_cvc")).sendKeys("234");
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//*[@id=\"paymentForm\"]/div/div/button")).click();
	    Thread.sleep(3000);
		}
		else if(actCardNumber.equals("**** **** **** 1111"))
		{
			driver.findElement(By.linkText("Change")).click();
		    Thread.sleep(2000);
		    WebElement nameOnCard = driver.findElement(By.id("name_on_card"));
		    nameOnCard.sendKeys("Kannan");
		    Thread.sleep(2000);
		    WebElement cardNumber = driver.findElement(By.id("cc_number"));
		    cardNumber.sendKeys("4242");
		    Thread.sleep(2000);
		    cardNumber.sendKeys("4242");
		    Thread.sleep(2000);
		    cardNumber.sendKeys("4242");
		    Thread.sleep(2000);
		    cardNumber.sendKeys("4242");
		    Thread.sleep(2000);
		    WebElement exp = driver.findElement(By.id("cc_exp"));
		    exp.sendKeys("02");
		    exp.sendKeys("24");
		    driver.findElement(By.id("cc_cvc")).sendKeys("234");
		    Thread.sleep(2000);
		    driver.findElement(By.xpath("//*[@id=\"paymentForm\"]/div/div/button")).click();
		    Thread.sleep(3000);
		}
		else
		{
			System.out.println("No cards added...Cool!");
		}
	    
	}
}
