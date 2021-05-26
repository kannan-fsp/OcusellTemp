package OcusellPack;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//import com.sun.xml.ws.api.server.Adapter.Toolkit;

import cucumber.api.java.en.*;

public class ChangePhoto {
	
	WebDriver driver = LandingPage.driver;
	
	@Given("Open Account settings screen")
	public void Open_Account_settings_screen() throws InterruptedException, AWTException {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("opening local folder");
	    WebElement upload = driver.findElement(By.partialLinkText("Photo"));
	 // //  upload.click();//need to remove this commenting
	    Thread.sleep(2000);
	   // //uploadFile("/Ocusell-Tests/src/main/java/photo2squaresmall.jpg");//need to remove this commenting
	    Thread.sleep(2000);
	    //String filepath = System.getProperty("user.dir") + "/Ocusell-Tests/src/main/java/photo2squaresmall.jpg";
	    ///Ocusell-Tests/src/main/java/photo2squaresmall.jpg
	    //upload.sendKeys(filepath);
	    
	    
	}
	/**
     * This method will set any parameter string to the system's clipboard.
     */
	public static void setClipboardData(String string) {
		//StringSelection is a class that can be used for copy and paste operations.
		   StringSelection stringSelection = new StringSelection(string);
		   Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		}
	
	public static void uploadFile(String fileLocation) {
        try {
        	//Setting clipboard with file location
            setClipboardData(fileLocation);
            //native key strokes for CTRL, V and ENTER keys
            Robot robot = new Robot();
	
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            Thread.sleep(2000);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            Thread.sleep(2000);
        } catch (Exception exp) {
        	exp.printStackTrace();
        }
    }

	@When("Click change photo button")
	public void click_change_photo_button() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("select any photo");
		
	}

	@Then("Upload photo")
	public void upload_photo() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("upload photo");
	}

}
