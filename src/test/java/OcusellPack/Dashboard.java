package OcusellPack;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.*;

public class Dashboard {
	
	WebDriver driver = LandingPage.driver;
	@Given("Verify page title")
	public void verify_page_title() {
	    // Verifying page title of the dashboard
	    String actDash = driver.getTitle();
	    System.out.println("Actual title: " +actDash);
	    
	}

	@When("check active counts")
	public void check_active_counts() throws InterruptedException {
	    // Verifying active and archive counts
	    String actCount = driver.findElement(By.xpath("//*[@class=' active ']//span")).getText();
	    System.out.println("Active counts is: " +actCount);
	    
	    Thread.sleep(3000);
	    
	    String archived = driver.findElement(By.xpath("//*[@id=\"sidebar-wrapper\"]/div/div[2]/ul/li[2]/a/span")).getText();
	    System.out.println("Archived counts are: " +archived);
	    Thread.sleep(2000);
	    
	}

	@Then("total counts and confirm the user account")
	public void total_counts_and_confirm_the_user_account() throws InterruptedException {
	    // Here getting count from the bottom of the dashboard and checking if still I have a option to create listing
		
		
	    String acttotalCount = driver.findElement(By.xpath("//*[@id=\"page-content-wrapper\"]/div/div[2]/div/h5")).getText();
	    System.out.println("Actual created listing counts are: " +acttotalCount);
	    System.out.println(acttotalCount.charAt(17));
	    System.out.println(acttotalCount.charAt(19));
	    
	    JavascriptExecutor js = (JavascriptExecutor) driver;

	   // js.executeScript("alert('I am an alert box!')");
	    
	    
	    Thread.sleep(2000);
	    int min = acttotalCount.charAt(17);
	    int max = acttotalCount.charAt(19);
	    if (max>min)
	    {
	    	int count = max-min;
	    	js.executeScript("alert('Still you can create'+' '+'"+count+"'+' more listing(s)')");
	    	Thread.sleep(3000);
		    driver.switchTo().alert().accept();
		    Thread.sleep(2000);
	    	System.out.println("Still you can create " +count+ " listings");
	    }
	    else
	    {
	    	js.executeScript("alert('You've reached maximum limit')");
	    	System.out.println("You have reached maximum amount of listings");
	    }
	}

}
