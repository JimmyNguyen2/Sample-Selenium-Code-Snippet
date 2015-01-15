import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
/**
 * 
 * @author Jimmy Nguyen
 * This code snippet demonstrates the use of "switchTo().frame()".
 * Some website uses iframe or frame set so in order to write something to an element of the frame,
 * Selenium needs to switch to the frame first. Some website like "https://netbanking.hdfcbank.com/netbanking/"
 * does not allow right click, so use "System.out.println(driver.getPageSource()); to get the page source info
 * and find out which frame the customer id info is in.
 */

public class Frames {

	public static void main(String[] args){
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://netbanking.hdfcbank.com/netbanking/");
		// This site does not allow right click so need to print out the page source info to know the frame
		System.out.println(driver.getPageSource());		
		// from the page source, the customer id is located in frame 1
		driver.switchTo().frame(1);
		// enter customer ID
		driver.findElement(By.cssSelector("input[class='input_password']")).sendKeys("1234"); 
		driver.close();
	}
}
