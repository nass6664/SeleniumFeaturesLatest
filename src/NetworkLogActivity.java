import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v123.network.Network;
import org.openqa.selenium.devtools.v123.network.model.Request;
import org.openqa.selenium.devtools.v123.network.model.Response;

import java.util.Optional;

//API and responses
public class NetworkLogActivity {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        System.setProperty("webdriver.chrome.driver", "/Users/nasabousaleh/java/Github/Grid/chromedriver");

        ChromeDriver driver = new ChromeDriver();
        //log file ->

        DevTools devTools = driver.getDevTools();
        devTools.createSession();

        //NetWork Domain  - need to enable it first
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

        //how to receive the response back, need a listen to all the events, so selenium weill be notify
        devTools.addListener(Network.requestWillBeSent(), request ->
        {
            Request req = request.getRequest();
            System.out.println(req.getUrl());
            //req.getHeaders()

        });

        //Event will get fired-
        devTools.addListener(Network.responseReceived(), response ->

        {
            Response res = response.getResponse();
            System.out.println(res.getUrl());
            System.out.println(res.getStatus());   //404 Url Issue
            if (res.getStatus().toString().startsWith("4")) {
                System.out.println(res.getUrl() + "is failing with status code" + res.getStatus());
            }
        });

        driver.get("https://rahulshettyacademy.com/angularAppdemo");
        driver.findElement(By.cssSelector("button[routerlink*='library']")).click();
    }

}
