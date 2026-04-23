package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageUsingFindBy {

    WebDriver driver;

    // ------------------------
    // WebElements using @FindBy
    // ------------------------
    @FindBy(id = "user-name")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-button")
    private WebElement loginBtn;

    @FindBy(css = "h3[data-test='error']")
    private WebElement errorMsg;

    // ------------------------
    // Constructor
    // ------------------------
    public LoginPageUsingFindBy(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // Initialize @FindBy elements
    }

    // ------------------------
    // Actions / Methods
    // ------------------------
    public void enterUsername(String uname) {
        username.sendKeys(uname);
    }

    public void enterPassword(String pwd) {
        password.sendKeys(pwd);
    }

    public void clickLogin() {
        loginBtn.click();
    }

    public boolean isErrorDisplayed() {
        return errorMsg.isDisplayed();
    }

    // Optional: Combine login action for test readability
    public void login(String uname, String pwd) {
        enterUsername(uname);
        enterPassword(pwd);
        clickLogin();
    }
}