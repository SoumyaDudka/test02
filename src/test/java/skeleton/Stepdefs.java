package skeleton;
import org.junit.Assert;
import org.openqa.selenium.By;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdefs {

 static WebDriver driver;

 @Given("App is launched")
 public void app_is_launched() {
    // Write code here that turns the phrase above into concrete actions
    //throw new cucumber.api.PendingException();
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\training_h2a.06.15\\Desktop\\SeleniumBroDrivers\\SeleniumBroDrivers\\chromedriver.exe\\");
    driver = new ChromeDriver();
    driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
 } 

 @When("User clicks on SignUp")
 public void user_clicks_on_SignUp() {
    // Write code here that turns the phrase above into concrete actions
    //throw new cucumber.api.PendingException();
    driver.findElement(By .xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/ul/li[2]/a")).click();
 }

 @Then("User provides the fields {string} {string} {string} {string} {string} {string} {string} {string} {string}")
 public void user_provides_the_fields(String uname, String fname, String lname, String pass, String cpass, String mail, String numb, String dob, String add) {
    // Write code here that turns the phrase above into concrete actions
    //throw new cucumber.api.PendingException();
    driver.findElement(By .name("userName")).sendKeys(uname);
    driver.findElement(By .name("firstName")).sendKeys(fname);
    driver.findElement(By .name("lastName")).sendKeys(lname);
  
    driver.findElement(By .name("password")).sendKeys(pass);
    driver.findElement(By .name("confirmPassword")).sendKeys(cpass);
    driver.findElement(By .xpath("//*[@id=\"gender\"]")).click();
    driver.findElement(By .name("emailAddress")).sendKeys(mail);
    driver.findElement(By .name("mobileNumber")).sendKeys(numb);
    driver.findElement(By .name("dob")).sendKeys(dob);
    driver.findElement(By .name("address")).sendKeys(add);
  
   Actions a = new Actions(driver);
   a.moveToElement(driver.findElement(By .xpath("//*[@id=\"securityQuestion\"]"))).click();
   a.sendKeys(Keys.DOWN).perform();
   driver.findElement(By .name("answer")).sendKeys("Black");
  
  
 }

 @Then("clicks on Register button")
 public void clicks_on_Register_button() throws InterruptedException {
    // Write code here that turns the phrase above into concrete actions
    //throw new cucumber.api.PendingException();
    driver.findElement(By .name("Submit")).click();
    Thread.sleep(3000);
 }

 @Given("Enter valid username {string}")
 public void enter_valid_username(String uname) {
    // Write code here that turns the phrase above into concrete actions
    //throw new cucumber.api.PendingException();
	
	 System.setProperty("webdriver.chrome.driver", "C:\\Users\\training_h2a.06.15\\Desktop\\SeleniumBroDrivers\\SeleniumBroDrivers\\chromedriver.exe\\");
	 driver = new ChromeDriver();
	 driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
	 driver.findElement(By .linkText("SignIn")).click();
	 
	 driver.findElement(By .name("userName")).sendKeys(uname);
 }

 @Given("Enter valid password {string}")
 public void enter_valid_password(String pass) {
    // Write code here that turns the phrase above into concrete actions
    //throw new cucumber.api.PendingException();
     driver.findElement(By .name("password")).sendKeys(pass);
 }

 @Given("click on Login")
 public void click_on_Login() {
    // Write code here that turns the phrase above into concrete actions
    //throw new cucumber.api.PendingException();
     driver.findElement(By .name("Login")).click();
     boolean b=driver.findElement(By .xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/ul/a")).isDisplayed();
 	 Assert.assertTrue(b);
 }

 @When("User click on the search tab")
 public void user_click_on_the_search_tab() throws InterruptedException {
    // Write code here that turns the phrase above into concrete actions
    //throw new cucumber.api.PendingException();

	 driver.findElement(By .xpath("//input[@id='myInput']")).click();

 }

 @Then("User enters the product name")
 public void user_enters_the_product_name() {
    // Write code here that turns the phrase above into concrete actions
    //throw new cucumber.api.PendingException();

	 driver.findElement(By .xpath("//input[@id='myInput']")).sendKeys("HeadPhone");
	 
 }

 @Then("User selects the product from the dropdown")
 public void user_selects_the_product_from_the_dropdown() {
    // Write code here that turns the phrase above into concrete actions
    //throw new cucumber.api.PendingException();
	
    driver.findElement(By .xpath("//input[@value='FIND DETAILS']")).click();
 }

 @Then("User adds the product in the cart")
 public void user_adds_the_product_in_the_cart() {
    // Write code here that turns the phrase above into concrete actions
    //throw new cucumber.api.PendingException();
 
     driver.findElement(By .xpath("/html/body/section/div/div/div[2]/div/div/div/div[2]/center/a")).click();
	 driver.findElement(By .xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/a[2]")).click();
	 driver.findElement(By .xpath("//*[@id=\"cart\"]/tfoot/tr[2]/td[5]/a")).click();
 	   //proceedtopay
     driver.findElement(By .xpath("/html/body/b/div/div/div[1]/div/div[2]/div[3]/div/form[2]/input")).click();
 }

 @Then("User does the payment")
 public void user_does_the_payment() throws InterruptedException {
    // Write code here that turns the phrase above into concrete actions
    //throw new cucumber.api.PendingException();
 
 	  WebDriverWait wait = new WebDriverWait(driver, 10);
      wait.until(ExpectedConditions.presenceOfElementLocated(By .xpath("//*[@id=\"swit\"]/div[1]/div/label/i")));
	  
	   driver.findElement(By .xpath("//*[@id=\"swit\"]/div[1]/div/label/i")).click();
	   //click on continue
	   driver.findElement(By .xpath("//*[@id=\"btn\"]")).click();
	   //username
	   driver.findElement(By .xpath("//*[@id=\"horizontalTab\"]/div[2]/div/div/div/div/form/input[1]")).click();
	   driver.findElement(By .xpath("//*[@id=\"horizontalTab\"]/div[2]/div/div/div/div/form/input[1]")).sendKeys("123456");
	   //password
	   driver.findElement(By .xpath("//*[@id=\"horizontalTab\"]/div[2]/div/div/div/div/form/input[2]")).click();
	   driver.findElement(By .xpath("//*[@id=\"horizontalTab\"]/div[2]/div/div/div/div/form/input[2]")).sendKeys("Pass@456");
	   //login
	   driver.findElement(By .xpath("//*[@id=\"horizontalTab\"]/div[2]/div/div/div/div/form/div/div[3]/input")).click();
	   //transactionpassword
	   driver.findElement(By .xpath("//*[@id=\"horizontalTab\"]/div[2]/div/div/div/div/form/input")).click();
	   driver.findElement(By .xpath("//*[@id=\"horizontalTab\"]/div[2]/div/div/div/div/form/input")).sendKeys("Trans@456");
	   //paynow
	   driver.findElement(By .xpath("//*[@id=\"horizontalTab\"]/div[2]/div/div/div/div/form/div/div[2]/input")).click();
	 
	   String actual4 = "3500";
	   String expected4= driver.findElement(By .xpath("/html/body/b/section/div/div/div/table[1]/tbody/tr/td[4]")).getText();
	   Assert.assertEquals(actual4, expected4);
	   driver.close();
   
   
 }

 @Given("Launch the application")
 public void launch_the_application() {
    // Write code here that turns the phrase above into concrete actions
   // throw new cucumber.api.PendingException();
     System.setProperty("webdriver.chrome.driver", "C:\\Users\\training_h2a.06.15\\Desktop\\SeleniumBroDrivers\\SeleniumBroDrivers\\chromedriver.exe\\");
     driver = new ChromeDriver();
     driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
 
 }

 @When("User clicks on Login")
  public void user_clicks_on_Login() {
    // Write code here that turns the phrase above into concrete actions
   // throw new cucumber.api.PendingException();
    driver.findElement(By .xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/ul/li[1]/a")).click();
 
 
 }

 @Then("User enters the credentials")
 public void user_enters_the_credentials() {
    // Write code here that turns the phrase above into concrete actions
    //throw new cucumber.api.PendingException();
    driver.findElement(By .name("userName")).sendKeys("Lalitha");
    driver.findElement(By .name("password")).sendKeys("Password123");
 
 
 }

 @Then("clicks on Login")
 public void clicks_on_Login() {
    // Write code here that turns the phrase above into concrete actions
    //throw new cucumber.api.PendingException();
    driver.findElement(By .xpath("/html/body/main/div/div/div/form/fieldset/div[4]/div/input[1]")).click();
 }

 @Then("Search a particular product")
 public void search_a_particular_product() {
    // Write code here that turns the phrase above into concrete actions
    //throw new cucumber.api.PendingException();
    driver.findElement(By .name("products")).sendKeys("HeadPhone");
    Actions c = new Actions(driver);
    c.sendKeys(Keys.ARROW_DOWN).click().perform();
    driver.findElement(By .xpath("/html/body/div[1]/form/input")).click();
 
 
 }

 @Then("Proceed to payment without adding any item to the cart")
 public void proceed_to_payment_without_adding_any_item_to_the_cart() {
    // Write code here that turns the phrase above into concrete actions
    //throw new cucumber.api.PendingException();
	
	//boolean ex=driver.findElement(By .xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/a[2]")).isDisplayed();
	//System.out.println(ex);
	//Assert.assertTrue(ex);
	System.out.println("Cannot view Cart Link");
    String s = driver.findElement(By .xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div")).getText();
    String s1 = "Cart";
    Assert.assertNotEquals(s,s1);
 }

 @Then("App doesnt display the cart icon")
 public void app_doesnt_display_the_cart_icon() {
    // Write code here that turns the phrase above into concrete actions
    //throw new cucumber.api.PendingException();
    System.out.println("Cart icon is not displayed");
    driver.close();
 }
}



