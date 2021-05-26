package OcusellPack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import cucumber.api.java.en.*;

public class ChangePassword {

	WebDriver driver = LandingPage.driver;
	
	@Given("Goto Account settings page and open check password popup")
	public void goto_Account_settings_page_and_open_check_password_popup() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("Here change password function will come");
	    driver.findElement(By.partialLinkText("Password")).click();
	    Thread.sleep(2000);
	    String actResetpass = driver.findElement(By.xpath("//*[@class='modal-container reset-password']//h3")).getText();
	    String expResetpass = "Reset Password";
	    Assert.assertEquals(actResetpass, expResetpass);
	}

	@When("Enter the password field")
	public void enter_the_password_field() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("Here filling password field");
	    driver.findElement(By.id("current_pass")).sendKeys("test1234");
	    Thread.sleep(2000);
	    driver.findElement(By.id("password")).sendKeys("Test1234");
	    Thread.sleep(2000);
	    driver.findElement(By.id("password_confirmation")).sendKeys("Test1234");
	    Thread.sleep(2000);
	    driver.findElement(By.id("pwd_submit")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.id("close")).click();
	    Thread.sleep(2000);
	}

	@Then("Verify password updated are working correctly")
	public void verify_password_updated_are_working_correctly() throws InterruptedException {
	    // Here I'm Verifying updated password works fine
	    
	    
	    //Here I'm clicking user name from sidebar to logout the user
	    driver.findElement(By.xpath("//*[@id=\"navbarDropdown\"]/span[2]")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//*[@id=\"sidebar-wrapper\"]/div/div[1]/div/a[2]/span[2]")).click();
	    Thread.sleep(2000);
	    //Click login button from home screen
	    driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/div/a[1]")).click();
	    Thread.sleep(2000);
	    //Below options are on login page
	    driver.findElement(By.id("email")).sendKeys("fspkannan@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Test1234");
		driver.findElement(By.xpath("//*[@id=\"loginform\"]/div[2]/button")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//div[@id='sidebar-wrapper']/div/a[4]/span[2]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.partialLinkText("Password")).click();
	    Thread.sleep(2000);
	    
	    driver.findElement(By.id("current_pass")).sendKeys("Test1234");
	    Thread.sleep(2000);
	    driver.findElement(By.id("password")).sendKeys("test1234");
	    Thread.sleep(2000);
	    driver.findElement(By.id("password_confirmation")).sendKeys("test1234");
	    Thread.sleep(2000);
	    driver.findElement(By.id("pwd_submit")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.id("close")).click();
	    Thread.sleep(2000);
	    
	}
}
