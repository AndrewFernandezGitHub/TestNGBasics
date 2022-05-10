package TestNgClass01;

import org.testng.annotations.Test;

public class DependsOn {

    @Test
    public void login(){
        System.out.println("This is login");
        //second test case is dependent on this test case,
        // if this test case fails, the second method wont work
    }
    @Test (dependsOnMethods = "login")
    public void verificationOfDashboard(){
        System.out.println("This is dashboard");
    }

}
