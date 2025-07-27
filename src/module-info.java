module Gitcode {
	
	import java.time.Duration;
	import java.util.Arrays;

	import java.util.List;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;

	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.support.ui.WebDriverWait;

	import java.util.concurrent.TimeUnit;
	public class Assignmentwait {

		public static void main(String[] args) throws InterruptedException {
			// TODO Auto-generated method stub
			System.setProperty("webdriver.chrome.driver","C:\\Users\\PK\\Documents\\chromedriver.exe");
			//invoking browser
			//Chrome - ChromeDriver ->Methods
					WebDriver driver = new ChromeDriver();
					//System.setProperty("webdriver.gecko.driver",Path_of_Firefox_Driver"); // Setting system properties of FirefoxDriver
							//WebDriver driver = new FirefoxDriver();
					driver.manage().window().maximize();
					driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
					driver.get("https://rahulshettyacademy.com/loginpagePractise/");
					
					driver.findElement(By.cssSelector("input#username")).sendKeys("rahulshettyacademy");
					driver.findElement(By.cssSelector("input#password")).sendKeys("learning");
					driver.findElement(By.xpath("//label[@class='customradio'][2]")).click();
					WebDriverWait w = new WebDriverWait(driver,5);
					w.until(ExpectedConditions.elementToBeClickable(By.id("okayBtn")));
					driver.findElement(By.id("okayBtn")).click();
					WebElement staticDropdown = driver.findElement(By.xpath("//*[@data-style='btn-info']"));
					Select dropdown = new Select(staticDropdown);
					dropdown.selectByIndex(2);
					driver.findElement(By.id("terms")).click();
					driver.findElement(By.id("signInBtn")).click();
					String[] itemsneeded = {"Samsung Note 8"};
					addItem(driver,itemsneeded);
					driver.findElement(By.xpath("//*[@class='nav-link btn btn-primary']")).click();
		}
	public static void addItem(WebDriver driver,String[] itemsneeded) {
		
		List<WebElement> products = driver.findElements(By.cssSelector("h4.card-title"));
		for(int i=0;i<products.size();i++)
		{
			String name=products.get(i).getText();
			List itemsNeededList = Arrays.asList(itemsneeded);
			
			if(itemsNeededList.contains(name))
			{
				List<WebElement> product = driver.findElements(By.xpath("//div[@class='card-footer']/button"));
				product.get(i).click();	
			}
		}
	}
	

}