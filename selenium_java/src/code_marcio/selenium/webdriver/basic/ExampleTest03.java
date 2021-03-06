package code_marcio.selenium.webdriver.basic;



import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExampleTest03 {

	public static WebDriver driver = null;
			
	public static void main(String[] args) throws InterruptedException
	{	
		long setLoadingDelay = 2000L;
		TimerTask task = new TimerTask() {
			public void run() {
				driver.findElement(By.id("title-wrapper")).click();
				
				String title = driver.getTitle();
				if(title.equalsIgnoreCase("Deep Purple - Smoke on The Water - YouTube")) {

					System.out.println("The best song from 70'");
				}
			}
		};
		
		Timer timer = new Timer();
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.navigate().to("https://www.youtube.com/");
		
		driver.findElement(By.name("search_query")).sendKeys("Deep Purple - Smoke on The Water");
		driver.findElement(By.id("search-icon-legacy")).click();
		
		driver.manage().window().maximize();
		
		timer.schedule(task, setLoadingDelay);
		driver.close();
		
	}
}
