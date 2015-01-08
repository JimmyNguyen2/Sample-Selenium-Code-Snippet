import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 
 * @author Jimmy Nguyen
 * This code snippet demos the use of action class to click on a link in the drop down menu.
 * The problem is the sub menu elements can't be selected until the drop down menu appears.
 * The sub menu needs to remain in focus in order to select from the submenu
 */
public class ActionsClass {

	public static void main(String[] args){
		
	
	WebDriver driver = new FirefoxDriver();
	driver.get("http://jimmynguyen2.github.io/index.html");
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	Actions actions = new Actions(driver);
	// move cursor over the drop down menu to see the list
	WebElement element = driver.findElement(By.xpath("//*[@id='top_nav']/ul/li[4]/a"));
	actions.moveToElement(element).build().perform();
	
	//wait for a maximum of 5 seconds for sub menu to appear
	WebDriverWait wait = new WebDriverWait(driver, 5);
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='top_nav']/ul/li[4]/ul/li[3]/a")));
	
	//Select Database link in the drop down menu
	WebElement menuOption = driver.findElement(By.xpath("//*[@id='top_nav']/ul/li[4]/ul/li[3]/a"));
	menuOption.click();
	
	//Verify the title of the page
	String title = driver.getTitle();
	if(title.contains("Database")){
		System.out.println("Navigate to Database successfully.");
	}
	else{
		System.out.println("Fail to navigate to Database.");
	}
	driver.close();

	}
}
