import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v123.network.Network;
import org.openqa.selenium.devtools.v123.network.model.ConnectionType;

import java.util.Optional;


public class NetworkSpeed {
//reduce network speed  - when scripts are fail;ng due the day of night
	//
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		//waits - 2-3 , 2
System.setProperty("webdriver.chrome.driver", "/Users/nasabousaleh/java/Github/Grid/chromedriver");
		
		ChromeDriver driver = new ChromeDriver();
		//log file ->
		
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		//Network.emulateNetworkConditions
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		//internet is online or offline
		devTools.send(Network.emulateNetworkConditions(false, 1000, 20000, 100000,
				Optional.of(ConnectionType.ETHERNET)));

		// offline is true then this will trigger, it wont tigger if it false
		devTools.addListener(Network.loadingFailed(), loadingFailed->  //we are pulling all the method of that object
		{
			System.out.println(loadingFailed.getErrorText());
			System.out.println(loadingFailed.getTimestamp());  // printer in MonotonicTime
		});
		long startTime = System.currentTimeMillis();
		driver.get("http://google.com");
		driver.findElement(By.name("q")).sendKeys("netflix",Keys.ENTER);
		Thread.sleep(2000);
		driver.findElements(By.cssSelector(".LC20lb")).get(0).click();
		String title =driver.findElement(By.cssSelector(".default-ltr-cache-jpuyb8")).getText();
		System.out.println(title);
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector("button[routerlink*='library']")).click();
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
		driver.close();
		//8476  253166
		
		
		
		
		
		
		
		
		
		
		
	}

}
