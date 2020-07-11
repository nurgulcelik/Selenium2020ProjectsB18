package test.day6_testNG_dropdowns;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNGPractice {

    @Test
    public void test1(){
        System.out.println("Test1 running...");
        String actualTitle="Homepage";
        String expectedTitle="Homepage";
        Assert.assertEquals(actualTitle,expectedTitle);
      /*  if(actualTitle.equals(expectedTitle)){
            System.out.println("Title verification passed!");
        }else{
            System.out.println("Title verification failed!");
        }*/
    }
    @Ignore
    @Test
    public void test2(){
        System.out.println("Test2 running...");
        Assert.assertEquals("string1","string1","String verification on test2 failed");
    }
    @Test
    public void test3(){
        System.out.println("Test3 running...");
        String actualTitle="Amazon prime";
        String testString="asdfggh";
        String expectedTitle="prime";
       //if the boolean value is true, assertion pass
        Assert.assertTrue(actualTitle.contains(expectedTitle));//true passed
       // Assert.assertTrue(actualTitle.contains(testString));//failed
        System.out.println("Just checking this line is running");
        //after failing the others will not run
        //Assert.assertFalse(actualTitle.contains(testString));passed
    }
    @BeforeMethod
    public void setUp(){
        System.out.println("Before method is running...");
    }
    @AfterMethod
    public void tearDown(){
        System.out.println("After method is running...");
    }
    @BeforeClass
    public void before_class(){
        System.out.println("Before class is running*****");
    }
    @AfterClass
    public void after_class(){
        System.out.println("After class is running*****");
    }



}
