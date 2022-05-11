package TestNGClass02;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testing2 {
    @BeforeSuite
    public void beforesuite2() {
        System.out.println("I am before Suite method in another class");
    }
    @BeforeTest
    public void beforetest2() {
        System.out.println("I am before test in new class not original class");
    }
    @Test
    public void TestB() {
        System.out.println("I am ordering cava for dinner");
    }
    @Test
    public void TestA() {
        System.out.println("I am not ordering cava for dinner");
    }
}
