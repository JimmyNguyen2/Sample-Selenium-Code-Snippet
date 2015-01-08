/**
 * 
 * @author Jimmy Nguyen
 *This code snippet demos how to use CSS selector to sign in to gmail.
 *UsingUsing css selector is a lot faster than xpath when identify an element on the web page.
 */
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class cssSelector {

	public static void main(String[] args){
		String userEmail = "Jpnd80@gmail.com";
		String password = "234_Thr*?";// not the actual password
		WebDriver driver = new FirefoxDriver();
		driver.get("https://gmail.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.cssSelector("#Email")).sendKeys(userEmail);//use id since it is unique.
		// use css customized xpath. It has this format: tagname[attribute ='value'].
		driver.findElement(By.cssSelector("input[id='Passwd']")).sendKeys(password);
		driver.findElement(By.cssSelector("#signIn")).click();//use id
		driver.close();
	}
}