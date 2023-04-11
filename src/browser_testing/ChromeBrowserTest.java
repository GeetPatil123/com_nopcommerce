package browser_testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

/**
 * Project-1 - Project Name: com-nopcommerce
 * BaseUrl = https://demo.nopcommerce.com/login?returnUrl=%2F
 * 1. Setup chrome browser
 * 2. Open URL
 * 3. Print the title of the page
 * 4. Print the current url
 * 5. Print the page source
 * 6. Enter the email to email field
 * 7. Enter the password to password field
 * 8. Close the browser
 */
public class ChromeBrowserTest {

    public static void main(String[] args) {

        String baseUrl = "https://demo.nopcommerce.com/login?returnUrl=%2F";
        WebDriver driver = new ChromeDriver();//launch the Chrome Browser
        driver.get(baseUrl);//open the URL into the browser

        driver.manage().window().maximize();//maximise the Browser

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));//we give implicit wait to Driver

        //get the Title of the page
        String title = driver.getTitle();
        System.out.println(title);

        //get the current URL
        System.out.println("Current URL: " + driver.getCurrentUrl());

        //get the page source
        System.out.println("Page source: " + driver.getPageSource());

        //find the email field element
        WebElement emailField = driver.findElement(By.id("Email"));

        //type the email address to the email field
        emailField.sendKeys("Bhreina@gamil.com");

        //find the password field element, and type the password into password field
        driver.findElement(By.id("Password")).sendKeys("Test123");

        //closing the Browser
        driver.close();


    }
}
