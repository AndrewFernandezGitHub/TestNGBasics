package TestNgClass01;

import org.testng.annotations.Test;

public class EnableAndDisable {
//default state for test is enabled true
    @Test(enabled=false)
    public void FirstTest(){
        System.out.println("1st");
    }
    @Test(enabled=true)
    public void SecondTest(){
        System.out.println("2nd");
    }
    @Test(enabled = true)
    public void ThirdTest(){
        System.out.println("3rd");
    }
}
