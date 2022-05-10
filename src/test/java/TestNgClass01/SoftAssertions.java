package TestNgClass01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertions {

    WebDriver driver;
    //go to syntax login
    //enter wrong credentials
    //verify the message is "Invalids  Credentials"

    @BeforeMethod
    public void OpenBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/");
    }
//SoftAssertion will continue to the assertions even if one assertion fails, unlike HardAssertions
    @Test
    public void VerifyCredentials() {
        SoftAssert soft=new SoftAssert();
        String expectedText = "Invalid credentials 101";
        WebElement Username = driver.findElement(By.id("txtUsername"));
        boolean displayed= Username.isDisplayed();
        Username.sendKeys("123456");
        driver.findElement(By.id("txtPassword")).sendKeys("123456");
        driver.findElement(By.id("btnLogin")).click();
        String text = driver.findElement(By.id("spanMessage")).getText();
        //assertion to make sure that the message is correct
        soft.assertEquals(text,expectedText);

        //validate the display is true or not
        System.out.println("hello world");
        soft.assertTrue(displayed);

        //check all assertions
        soft.assertAll();

    }
    @AfterMethod
    public void CloseBrowser(){
        driver.quit();
    }
}