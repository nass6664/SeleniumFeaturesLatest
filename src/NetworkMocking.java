import java.util.Optional;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v123.fetch.Fetch;




public class NetworkMocking {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
System.setProperty("webdriver.chrome.driver", "/Users/nasabousaleh/java/Github/Grid/chromedriver");
		
		ChromeDriver driver = new ChromeDriver();

		//this is the first - create a DevTool Object
		DevTools devTools = driver.getDevTools();
		devTools.createSession();

		//Fetch
		devTools.send(Fetch.enable(Optional.empty(), Optional.empty()));
		//your application is ready to send any request to backend
		devTools.addListener(Fetch.requestPaused(), request->
		{
			if(request.getRequest().getUrl().contains("shetty"))
			{
				String mockedUrl =request.getRequest().getUrl().replace("=shetty", "=BadGuy");
				
				System.out.println(mockedUrl);
				
				//used after the pause events called
				devTools.send(Fetch.continueRequest(request.getRequestId(), Optional.of(mockedUrl), Optional.of(request.getRequest().getMethod()),
						Optional.empty(), Optional.empty(),Optional.empty()));
			}
			else {
				
				devTools.send(Fetch.continueRequest(request.getRequestId(), Optional.of(request.getRequest().getUrl()), Optional.of(request.getRequest().getMethod()),
						Optional.empty(), Optional.empty(),Optional.empty()));
				
			}
			
		});
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector("button[routerlink*='library']")).click();
		Thread.sleep(3000);
		
		System.out.println(driver.findElement(By.cssSelector("p")).getText());
		
		
		
		
		
		
		
		
		
		
	}

}
