import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * 
 * @author Jimmy Nguyen
 *This snippet shows how to count 
 * Count total number of links on Ebay.com.
 * Count number of links in the footer section of Ebay.com only.
 * List the links in the second column of the footer section.
 * Click on the "Affiliates" link in the second column of the footer and verify the title of the new page.
 */

public class Links {

	public static void main(String[] args){
		
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.ebay.com");
		
		System.out.println("Number of links on www.ebay.com:");
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		System.out.println("Number of links in the footer section of www.ebay.com:");
		WebElement footer = driver.findElement(By.xpath(".//*[@id='glbfooter']"));		
		System.out.println(footer.findElements(By.tagName("a")).size());
		
		System.out.println("Nubmer of links in the 2nd column of the footer section:");
		WebElement column = driver.findElement(By.xpath(".//*[@id='gf-BIG']/table/tbody/tr/td[2]/ul"));
		System.out.println(column.findElements(By.tagName("a")).size());
		int count = column.findElements(By.tagName("a")).size();
		System.out.println("Links in second column of the footer");
		for(int i = 0; i < count; i++){
			System.out.println(column.findElements(By.tagName("a")).get(i).getText());
		}
		
		//Click on "Affiliates" link and verify the title
		for(int i = 0; i < count; i++){
			//use this techniques if the link is dynamic, it can be in any location of this column
			if(column.findElements(By.tagName("a")).get(i).getText().contains("Affiliates")){
				column.findElements(By.tagName("a")).get(i).click();
				break;
			}
		}
		String title = driver.getTitle();
		System.out.println(title);
		if(title.contains("eBay Partner Network")){
			System.out.println("Successfuly navigating to eBay Partner Network site.");
		}else
			System.out.println("Wrong location. Check the link.");
		
		driver.close();
	}
}
