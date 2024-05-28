package testsuite;
/**
 * 1. userSholdLoginSuccessfullyWithValidCredentials
 * * Enter “tomsmith” username
 * * Enter “SuperSecretPassword!” password
 * * Click on ‘LOGIN’ button
 * * Verify the text “Secure Area”
 * 2. verifyTheUsernameErrorMessage
 * * Enter “tomsmith1” username
 * * Enter “SuperSecretPassword!” password
 * * Click on ‘LOGIN’ button
 * * Verify the error message “Your username
 * is invalid!”
 *
 * 3. verifyThePasswordErrorMessage
 * * Enter “tomsmith” username
 * * Enter “SuperSecretPassword” password
 * * Click on ‘LOGIN’ button
 * * Verify the error message “Your password
 * is invalid!”
 */

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    //Use @before junit method for open a browser for method
    public void setup() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        //username element
        WebElement usernameField=driver.findElement(By.xpath("//input[@id='username']"));
        usernameField.sendKeys("tomsmith");

        //Password element
        WebElement PasswordField=driver.findElement(By.xpath("//input[@id='password']"));
        PasswordField.sendKeys("SuperSecretPassword!");

        //Login element
        WebElement LoginField=driver.findElement(By.xpath("//i[contains(text(),'Login')]"));
        LoginField.click();

        //actual result
        WebElement actualresult=driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/h2[1]"));
        String actualmsg=actualresult.getText();

        //expectedresult
        String expectedmsg="Secure Area";

        //match actual and expected result
        Assert.assertEquals(actualmsg,expectedmsg);
    }
    @Test
    public void verifyTheUsernameErrorMessage() {
        //username element
        WebElement usernameField = driver.findElement(By.xpath("//input[@id='username']"));
        usernameField.sendKeys("tomsmith1");

        //Password element
        WebElement PasswordField = driver.findElement(By.xpath("//input[@id='password']"));
        PasswordField.sendKeys("SuperSecretPassword!");

        //Login element
        WebElement LoginField = driver.findElement(By.xpath("//i[contains(text(),'Login')]"));
        LoginField.click();

        //actual result
        WebElement actualResult=driver.findElement(By.id("flash"));
        String actualMsg=actualResult.getText();
        //System.out.println(actualMsg);

        //expected result
        String expectedResult="Your username is invalid!\n" +
                "×";

        //match actual and expected result
        Assert.assertEquals("Invalid input",actualMsg,expectedResult);
    }
    @Test
    public void verifyThePasswordErrorMessage(){
        //username element
        WebElement usernameField = driver.findElement(By.xpath("//input[@id='username']"));
        usernameField.sendKeys("tomsmith1");

        //Password element
        WebElement PasswordField = driver.findElement(By.xpath("//input[@id='password']"));
        PasswordField.sendKeys("SuperSecretPassword");

        //Login element
        WebElement LoginField = driver.findElement(By.xpath("//i[contains(text(),'Login')]"));
        LoginField.click();

        //actual result
        WebElement actualResult=driver.findElement(By.id("flash"));
        String actualMsg=actualResult.getText();
        System.out.println(actualMsg);

        //expected result
        String expectedMsg="Your username is invalid!\n" +
                "×";

        //match actual and expected result
        Assert.assertEquals("Invalid password",actualMsg,expectedMsg);

    }
    @After
    //Here After method for close the browser
    public void tearDown() {
        closeBrowser();
    }
}