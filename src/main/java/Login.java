import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Login {

    WebDriver driver;
    String exp = "Google Search";

    @BeforeClass
    public void before(){
        ChromeOptions chrome_options = new ChromeOptions();
        chrome_options.addArguments("--disable-features=BlockThirdPartyCookies");
        chrome_options.addArguments("--no-sandbox");
        chrome_options.addArguments("--disable-dev-shm-usage");
        chrome_options.addArguments("--disable-notifications");
        chrome_options.addArguments("--disable-popup-blocking");
        driver = new ChromeDriver(chrome_options);
    }

    @Test
    public void test_Login(){

        driver.get("https://google.com/");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try{
            WebElement cookieButton = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.xpath("//div[text()='Accept all']")
                    ));
            cookieButton.click();
        }catch(Exception e){
            System.out.println("No cookie pop up found");
        }

        WebElement search =driver.findElement(By.name("q"));
        search.sendKeys("Newcastle upon Tyne");
        search.sendKeys(Keys.ENTER);

        String title = driver.getTitle();
        Assert.assertEquals(title, exp);

    }

    @AfterClass
    public void tearDown(){
        driver.close();
        driver.quit();
    }

}

