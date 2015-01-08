/**
 * 
 * @author Jimmy Nguyen
 *This snippet demos the selection of radio button, drop down menu, selecting date,
 * verify label name on Southwest airline flight schedule site.
 */

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class WebGui {

	public static void main(String[] args){
		
		WebDriver driver = new FirefoxDriver();
		
		//go to Southwest airline flight schedule
		driver.get("https://www.southwest.com/flight/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		driver.findElement(By.xpath("//*[@id='roundTrip']")).click();
		
		//select departure airport and returning airport
		driver.findElement(By.xpath("//*[@id='originAirport_displayed']")).sendKeys("Burbank, CA - BUR");
		driver.findElement(By.xpath("//*[@id='destinationAirport_displayed']")).sendKeys("Sacramento, CA - SMF");
		
		//select departure date and time
		driver.findElement(By.xpath("//*[@id='outboundDate']")).clear();
		driver.findElement(By.xpath("//*[@id='outboundDate']")).sendKeys("01/08/2015");
		driver.findElement(By.xpath("//*[@id='outboundTimeOfDay']")).sendKeys("BEFORE_NOON");
		
		//select returning date and time
		driver.findElement(By.xpath("//*[@id='returnDate']")).clear();
		driver.findElement(By.xpath("//*[@id='returnDate']")).sendKeys("02/11/2015");
		driver.findElement(By.xpath("//*[@id='returnTimeOfDay']")).sendKeys("AFTER_6PM");
		
		//select number of passengers and click search button.
		WebElement passengers = driver.findElement(By.xpath("//*[@id='adultPassengerCount']"));
		Select select = new Select(passengers);
		select.selectByVisibleText("1 Adult Age 2+");
		
		//directly select the number of senior passengers using "sendKeys"
		driver.findElement(By.xpath("//*[@id='seniorPassengerCount']")).sendKeys("4");
		
		//Click Points radio button for "Show Fares in"
		driver.findElement(By.xpath("//*[@id='dollars']")).click();
		//Verify Dollars radio button is selected for "Show Fares in"
		System.out.println(driver.findElement(By.xpath("//*[@id='dollars']")).isSelected());
		//print the Dollar label of the radio button
		System.out.println(driver.findElement(By.xpath("//*[@id='dollarsLink']")).getText());
		
		
		driver.findElement(By.xpath("//*[@id='submitButton']")).click();
		
		driver.close();
	}
}
