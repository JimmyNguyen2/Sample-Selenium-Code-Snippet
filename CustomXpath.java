/**
 * 
 * @author Jimmy Nguyen
 * This snippet demos the use of custom Xpath for dynamic ID on Facebook
 * The "Login" button on Facebook login page has dynamic ID so using the regular Xpath  
 * from Firepath does not work. Here is the regular Xpath for the login button: //*[@id='u_0_n']".
 * It will change the next time you open Facebook.
 */
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CustomXpath {

	public static void main(String[] args){
		String username = "Jimmy38_98@yahoo.com";
		String password = "te_23?dfg";//this is not actual password.
		
		WebDriver driver = new FirefoxDriver();
		driver.get("http://facebook.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//using regular xpath to enter user name
		driver.findElement(By.xpath("//*[@id='email']")).clear();// clear the field before entering data.
	
	    driver.findElement(By.xpath("//*[@id='email']")).sendKeys(username);
	    
	    //using regular xpath to enter password.
	    driver.findElement(By.xpath("//*[@id='pass']")).clear();
	    driver.findElement(By.xpath("//*[@id='pass']")).sendKeys(password);
	    
		//using Firebug to get info for Facebook Login button:
		//<input id="u_0_n" type="submit" tabindex="4" value="Log In"/>
		//Firepath shows:"//*[@id='u_0_n']". Since the ID is dynamic, can't use regular xpath.  
		// using the custom Xpath format: "//tagname[@attribute='value']. Where "tagname" is the "//input"
		//"@attribute" is "value", and "value" = "'Log In'"
		driver.findElement(By.xpath("//input[@value='Log In']")).click();
		 
	    driver.close();
		
	}
}
