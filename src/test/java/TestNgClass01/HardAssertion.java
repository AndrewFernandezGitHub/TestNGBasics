package TestNgClass01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HardAssertion {
WebDriver driver;
    //go to syntax login
    //enter wrong credentials
    //verify the message is "Invalids  Credentials"

    @BeforeMethod
    public void OpenBrowser(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/");
    }
    @Test
    public void VerifyCredentials(){
        String expectedText="Invalid credentials";
        WebElement Username= driver.findElement(By.id("txtUsername"));
        Username.sendKeys("123456");
        driver.findElement(By.id("txtPassword")).sendKeys("123456");
        driver.findElement(By.id("btnLogin")).click();
        String text = driver.findElement(By.id("spanMessage")).getText();
        //first assertion compare the two strings
        //Assert.assertEquals(text,"Invalid credentials");
        Assert.assertEquals(text,expectedText);

        //assert if username textbox is displayed
        boolean displayed = Username.isDisplayed();
        //assertion if it is actually displayed or not
        System.out.println("helloworld");
        Assert.assertTrue(displayed);//if not displayed will be false


    }
    @AfterMethod
    public void CloseBrowser(){
        driver.quit();
    }
}
