package OcusellPack;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.*;


public class Login {

	WebDriver driver = LandingPage.driver;
	@Given("Launch login page")
	public void launch_login_page() 
	
	{
	    
	    //Goto login screen
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/div/a[1]")).click();
		String actTitle = driver.getTitle();
		String expTitle = "Login Page | Ocusell | Ocusell";
		assertEquals(actTitle, expTitle);
		
		//trying to compare different string into sysout statement using equals method
		System.out.println("comparing " +actTitle+ " and " +expTitle+ " : " +actTitle.equals(expTitle));
		
		//Using stringcompare method comparing values
		//System.out.println("comparing" +actTitle+ "and" +expTitle+ " : " + stringCompare(actTitle, expTitle));
		
	}

	@When("Verify failure message with incorrect details")
	public void verify_failure_message_with_incorrect_details() throws InterruptedException 
	
	{
	    // Here I'm checking for incorrect user credentials
		driver.findElement(By.id("email")).sendKeys("fspkannan@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//*[@id=\"loginform\"]/div[2]/button")).click();
		Thread.sleep(2000);
	    String actErrorMsg = driver.findElement(By.xpath("//*[@id=\"loginform\"]/div[1]")).getText();
//	    String expErrorMsg = "×\r\n"
//	    		+ "Incorrect Username / Password.";
//	    System.out.println("Compare " +actErrorMsg+ " and " +expErrorMsg+ " : " +actErrorMsg.equals(expErrorMsg));
//	    assertEquals(actErrorMsg, expErrorMsg);
	    System.out.println("Actual error message for incorrect login details: " +actErrorMsg);
	    Thread.sleep(3000);
	    
	}

	@When("Verify login page with correct details")
	public void verify_login_page_with_correct_details() throws InterruptedException 
	
	{
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
	    //driver.findElement(By.id("email")).sendKeys("fspkannan@gmail.com");
		driver.findElement(By.id("password")).sendKeys("test1234");
		
	}

	
	@Then("Verify success message")
	public void verify_success_message() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	    //Here I'm verifying user is redirected to dashboard screen
		driver.findElement(By.xpath("//*[@id=\"loginform\"]/div[1]/button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"loginform\"]/div[2]/button")).click();
		//*[@id="loginform"]/div[3]/button
		Thread.sleep(2000);
	}

}
