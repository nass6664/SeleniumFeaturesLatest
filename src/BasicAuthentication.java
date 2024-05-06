import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.chrome.ChromeDriver;
import java.net.URI;
import java.util.function.Predicate;

public class BasicAuthentication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//Window popup
		
		System.setProperty("webdriver.chrome.driver", "/Users/nasabousaleh/java/Github/Grid/chromedriver");
		
		ChromeDriver driver = new ChromeDriver();
		//predicate, consumer  - it consume the data and do nothing - mean no return
		Predicate<URI> uriPredicate =uri ->  uri.getHost().contains("httpbin.org");
		//HasAuthentication  - selluim
		//if we don't cast the driver with has authentication, then the doese not nay anyinformtion
		((HasAuthentication)driver).register(uriPredicate,UsernameAndPassword.of("foo", "bar"));
		driver.get("http://httpbin.org/basic-auth/foo/bar");  //http:host/resource/parameters
		
		   
		
	}

}
