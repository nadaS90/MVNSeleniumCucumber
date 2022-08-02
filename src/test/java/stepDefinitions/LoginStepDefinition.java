package stepDefinitions;

import pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class LoginStepDefinition {

    WebDriver driver = null;
    LoginPage login;

    @Given("user open browser")
    public void user_open_browser() throws InterruptedException {
        String chromePath = System.getProperty("user.dir") + "\\src\\browsers\\chromedriver.exe";
        System.out.println(chromePath);
        System.setProperty("webdriver.chrome.driver",chromePath);

        driver = new ChromeDriver();

        driver.manage().window().maximize();
        Thread.sleep(3000);

        // Create new objects
        login = new LoginPage(driver);
    }

    @And("user navigates to login page")
    public void user_navigate()
    {
        driver.navigate().to("https://the-internet.herokuapp.com/login");


    }

    @When("user enter valid username and password")
    public void valid_data()
    {
        login.LoginSteps("tomsmith","SuperSecretPassword!");


    }

    @And("user click on login button")
    public void login_brn() throws InterruptedException {
        login.passwordPOM().sendKeys(Keys.ENTER);
        Thread.sleep(3000);


    }

    @Then("user could login successfully")
    public void sucess_msg()
    {
        String expectedResult = "You logged into a secure area!";
        String actualResult = driver.findElement(login.flashPOM()).getText();

        //Assert with Junit
        Assert.assertTrue(actualResult.contains(expectedResult));
        Assert.assertEquals(actualResult.contains(expectedResult), true);


    }

    @And("user go to home page")
    public void home_page()
    {
        Assert.assertEquals("https://the-internet.herokuapp.com/secure", driver.getCurrentUrl());


    }

}
