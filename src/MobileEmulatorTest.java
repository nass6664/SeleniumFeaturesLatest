import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v123.emulation.Emulation;

import java.util.Optional;


public class MobileEmulatorTest {

	public static void main(String[] args) throws InterruptedException  {
		// TODO Auto-generated method stub
		//Maven: org.seleniumhq.selenium:selenium-chromium-driver:4.18.12
		System.setProperty("webdriver.chrome.driver", "/Users/nasabousaleh/java/Github/Grid/chromedriver");

		ChromeDriver driver = new ChromeDriver();

		DevTools devTools = driver.getDevTools();
		
		devTools.createSession();
		
		//send command to CDP Methods-> CDP Methods will invoke and get access to chrome dev tools
		devTools.send(Emulation.setDeviceMetricsOverride(600, 1000, 50, true, Optional.empty(), Optional.empty(),
				Optional.empty(), Optional.empty(), Optional.empty(),
				Optional.empty(), Optional.empty(),
				Optional.empty(), Optional.empty(),Optional.empty()));
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		
		driver.findElement(By.cssSelector(".navbar-toggler")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.linkText("Library")).click();
		driver.close();
		//Network.getRequestPostData
		
	
		
		

		
	
		
		
	}

}
