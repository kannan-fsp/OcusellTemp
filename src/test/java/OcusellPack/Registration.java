package OcusellPack;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import cucumber.api.java.en.*;

public class Registration {
	
	WebDriver driver = LandingPage.driver;

	@Given("^Goto firststep and fill everything$")
	public void goto_firststep_and_fill_everything() throws Throwable {
	    // Here I'm going to fill all the fields in step1 of registration
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/div/a[2]")).click();
		Thread.sleep(2000);
		String pageTitle = driver.getTitle();
		System.out.println("Registration page title is: " +pageTitle);
		Random ran = new Random();
		int i = ran.nextInt(1000);
		driver.findElement(By.id("first_name")).sendKeys("Kannan");
		driver.findElement(By.id("last_name")).sendKeys("QA"+i);
		driver.findElement(By.id("email")).sendKeys("fspkannan"+i+"@mailinator.com");
		driver.findElement(By.id("address")).sendKeys(i+" cross avenue");
		driver.findElement(By.id("city")).sendKeys("Chicago");
		driver.findElement(By.id("state")).sendKeys("IL");
		driver.findElement(By.id("zip")).sendKeys("5"+i);
		driver.findElement(By.id("nrds")).sendKeys("124345"+i);
		driver.findElement(By.id("brokerage")).sendKeys("cool"+i);
		driver.findElement(By.id("password")).sendKeys("test1234");
		driver.findElement(By.id("confirm_password")).sendKeys("test1234");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		
		WebElement conti = driver.findElement(By.xpath("//*[@id=\"regForm\"]/div/button"));
		js.executeScript("window.scrollBy(0,1000)");
		js.executeScript("arguments[0].scrollIntoView();", conti);
		Thread.sleep(2000);
		conti.click();
		Thread.sleep(2000);
	}

	@When("^Choose pricing$")
	public void choose_pricing() throws Throwable {
	    // Here I'm going to choose price
		String actPlanName = driver.findElement(By.xpath("//*[@class='pricing-head']//h4")).getText();
		String expPlanName = "SINGLE AGENT";
		Assert.assertEquals(actPlanName, expPlanName);
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement plan = driver.findElement(By.xpath("//*[@id=\"single_plan\"]/div/button"));
		js.executeScript("window.scrollBy(0,1000)");
		js.executeScript("arguments[0].scrollIntoView();", plan);
		Thread.sleep(2000);
		plan.click();
		Thread.sleep(2000);
	}

	@Then("^Enter card info then submit$")
	public void enter_card_info_then_submit() throws Throwable {
	    // Here filling my card info then submitting the form
		driver.findElement(By.id("name_on_card")).sendKeys("kannan");
		WebElement cardNum = driver.findElement(By.id("cc_number"));
		cardNum.sendKeys("4242");
		Thread.sleep(2000);
		cardNum.sendKeys("4242");
		Thread.sleep(2000);
		cardNum.sendKeys("4242");
		Thread.sleep(2000);
		cardNum.sendKeys("4242");
		Thread.sleep(2000);
		WebElement exp = driver.findElement(By.id("cc_exp"));
		exp.sendKeys("12");
		Thread.sleep(2000);
		exp.sendKeys("24");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		driver.findElement(By.id("cc_cvc")).sendKeys("123");
		WebElement confirm = driver.findElement(By.xpath("//*[@id=\"paymentForm\"]/div/div/button"));
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,1000)");
		js.executeScript("arguments[0].scrollIntoView();", confirm);
		Thread.sleep(2000);
		//we must remove this quite statement, if we want to write more scripts.
		//driver.quit();
	    
	}
}
