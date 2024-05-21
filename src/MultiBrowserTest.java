import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MultiBrowserTest {
    /**
     1. Setup chrome browser.
     2. Open URL.
     3. Print the title of the page.
     4. Print the current url.
     5. Print the page source.
     6. Navigate to Url.
     7. Print the current url.
     8. Navigate back to the home page.
     9. Navigate to the login page.
     10. Print the current url.
     11. Refresh the page.
     12. Enter the email to email field.
     13. Enter the password to password field.
     14. Click on Login Button.
     15. Close the browser.*/

    static String browser = "Chrome";

    static String baseurl = "https://demo.nopcommerce.com/"; //I want to open this url

    static WebDriver driver;

    public static void main(String[] args) {
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("FF")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else System.out.println("wrong browser name");

        //Open the url into browser
        driver.get(baseurl);//or use directly the given url

        //To get the title of a website
        String title = driver.getTitle();
        System.out.println(" The title of the page " + title);

        //Get current url eg. login
        String currenturl = driver.getCurrentUrl();
        System.out.println("The current url : " + currenturl);

        //Get page source
        System.out.println("The source :" + driver.getPageSource());

        //Store the login url in a loginUrl string-Navigate
        String loginUrl="https://demo.nopcommerce.com/login?returnUrl=%2F";
        driver.navigate().to(loginUrl);

        //print the current url back
        System.out.println("Get current url :" + driver.getCurrentUrl());

        //Navigate back
        driver.navigate().back();
        System.out.println("Get current url :" + driver.getCurrentUrl());

        //navigate to a login page
        driver.navigate().to(loginUrl);

        //print the current url back
        System.out.println("Get current url :" + driver.getCurrentUrl());

        //Refresh the page
        driver.navigate().refresh();

        //Enter the email to email field
        WebElement email=driver.findElement(By.id("Email"));
        email.clear();;
        email.sendKeys("vb123@gmail.com");

        //Enter the password in a password field
        WebElement password=driver.findElement(By.id("Password"));
        password.clear();
        password.sendKeys("abc123");

        // Assuming the login button has the name 'login'
        driver.findElement(By.className("login-button")).click();

        //Close the browser
        driver.quit();
    }
}
