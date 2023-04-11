package browser_testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

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
public class MultiBrowserTest {

    static String browser = "Chrome";

    static String baseUrl = "https://demo.nopcommerce.com/login?returnUrl=%2F";

    static WebDriver driver;

    public static void main(String[] args) {

        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("FireFox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong Browser Name:");
        }

        //open the URL into the Browser
        driver.get(baseUrl);

        //maximize the Browser
        driver.manage().window().maximize();

        //we give implicit wait to the driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //get the Title of the page
        String title = driver.getTitle();
        System.out.println(title);

        //get the current URL
        System.out.println("Current URL: " + driver.getCurrentUrl());

        //get page source
        System.out.println("Page source: " + driver.getPageSource());

        //find the email field element
        WebElement emailField = driver.findElement(By.id("Email"));

        //type the email address to the email field element
        emailField.sendKeys("bhreina@gmail.com");

        //find the password field element, and type the password into password field
        driver.findElement(By.id("Password")).sendKeys("test123");

        //close the browser
        driver.close();
    }
}