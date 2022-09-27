import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class LoginStepsDefinition {
    WebDriver driver;
    String WebDriverType = "webdriver.chrome.driver";
    String WebDriverPath = "C:/melbarrak/Applications/intellijSeleniumJarAndDrivers/chromedriver_win32/chromedriver.exe";
    String sqliUrl = "https://app.sqli.com/Login/?LaPage=https://app.sqli.com";

    @Before
    public void prepareDriver(){
        System.setProperty("webdriver.chrome.driver", WebDriverPath);
        driver = new ChromeDriver();
        //driver.get(sqliUrl);
    }
    @Given("user is on homepage")
    public void userIsOnHomepage() {
        driver.get(sqliUrl);
    }

    @And("user navigates to {string} Page")
    public void userNavigatesToPage(String pageName) {
        driver.get("https://app.sqli.com/Login/?LaPage=https://app.sqli.com");
        System.out.println("user navigates to {string} Page: " + pageName);//user navigates to {string} Page: Login

        //if("login".equalsIgnoreCase(pageName)){
        //    driver.findElement(By.id("...")).click();
        //}
    }

    @When("^user fill username (.+) and password(.+)$")
    public void user_fill_username_and_password(String username, String password) throws Throwable {
        driver.findElement(By.id("input_NameCollab")).sendKeys(username);
        driver.findElement(By.id("input_PassCollab")).sendKeys(password);
        driver.findElement(By.id("button_submit")).click();
    }

    /*
    @Then("^Error message is displayed$")
    public void error_message_is_displayed() throws Throwable {
        driver.findElement(By.className("error-form-user")).isDisplayed();
    }

    @And("^user navigates to \"([^\"]*)\" Page$")
    public void user_navigates_to_something_page(String strArg1) throws Throwable {

    }

    @Then("success message is displayed")
    public void successMessageIsDisplayed() {
    }
    */

    @AfterTest
    public void terminateBrowser(){
        //driver.quit();
    }

    @Then("Error message is displayed")
    public void errorMessageIsDisplayed() {
    }

    @Then("^success message is displayed$")
    public void success_message_is_displayed() throws Throwable {
    }
}
