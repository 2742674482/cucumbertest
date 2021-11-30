package hu.unideb.inf;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import java.util.List;
import java.util.Optional;

public class HomePage {

    private static final String PAGE_URL = "http://automationpractice.com/";

    private static final By LOGIN_ERROR = By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li");
    private static final By CONTACT_ERROR = By.cssSelector("#center_column > div > ol > li");

    private static final By REGISTER_ERROR=By.xpath("//*[@id=\"create_account_error\"]/ol/li");
    private static final By SEARCH_WARING=By.xpath("///*[@id=\"center_column\"]/p");

    private static final By LETTER_ERROR=By.xpath("//*[@id=\"columns\"]/p");

    private static final By Cart_WARING=By.xpath("//*[@id=\"center_column\"]/p");

    private static final By PASSWORD_WARING=By.xpath("//*[@id=\"center_column\"]/div/div");

    private static final By PASSWORD_RIGHT=By.xpath(" //*[@id=\"center_column\"]/div/p");

    @FindBy(className = "login")
    private WebElement signInButton;

    @FindBy(id = "SubmitLogin")
    private WebElement submitSignInButton;

    @FindBy(xpath = "//*[@id=\"SubmitCreate\"]/span")
    private WebElement CreateAnAccountButton;

    @FindBy(xpath = "//*[@id=\"searchbox\"]/button")
    private WebElement searchButton;

    @FindBy(xpath = "//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a")
    private WebElement cartButton;

    @FindBy(xpath = "//*[@id=\"homefeatured\"]/li[1]/div/div[1]/div/a[1]/img")
    private WebElement shortSleeveShirtImage;

    @FindBy(xpath = "//*[@id=\"add_to_cart\"]/button/span")
    private WebElement addToCartButton;

    @FindBy(xpath = "//*[@id=\"login_form\"]/div/p[1]/a")
    private WebElement ForgetPassword;

    @FindBy(xpath = "//*[@id=\"form_forgotpassword\"]/fieldset/p/button/span")
    private WebElement RetrievePasswordButton;


    @FindBy(xpath = "//*[@id=\"newsletter_block_left\"]/div/form/div/button")
    private WebElement Clickenter;




    @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a")
    private WebElement proceedToCheckOutButton;



    private WebDriver webDriver;

    public HomePage(WebDriver driver) {
        this.webDriver = driver;
    }

    public void openPage(){
        webDriver.get(PAGE_URL);
        PageFactory.initElements(webDriver, this);
    }



    public void clickSignInButton() {signInButton.click();}

    public void CreateAnAccountButton(){CreateAnAccountButton.click();}

    public void SearchButton(){searchButton.click();}


    public void CartButton(){cartButton.click();}

    public void ForgetPassword(){ForgetPassword.click();}

    public void RetrievePasswordButton(){RetrievePasswordButton.click();}


    public void  Clickenter(){Clickenter.click();}


    public void clickProceedToCheckOutButton(){
        proceedToCheckOutButton.click();
    }

    public void clickShortSleeveShirtImage(){
        shortSleeveShirtImage.click();
    }

    public void clickAddToCartButton() throws InterruptedException {
        addToCartButton.click();
        Thread.sleep(10000);
    }


    public void pressEnterButton(){
        Actions action = new Actions(webDriver);
        action.sendKeys(Keys.ENTER).build().perform();
    }



    public void fillFieldById(String fieldName , String msg){
        getField(By.id(fieldName)).sendKeys(msg);
    }


    public Boolean searchItem(String name){
        List<WebElement> list = webDriver.findElements(By.xpath("//*[@id=\"center_column\"]/ul"));
        for (int i = 0; i < list.size(); i++) {
            String listItem = list.get(i).getText();
            if (listItem.contains(name)){
                return true;
            }
        }

        return false;
    }

    public Boolean searchUniItem(String name){
        List<WebElement> list = webDriver.findElements(By.xpath("//*[@id=\"center_column\"]/ul"));
        for (int i = 0; i < list.size(); i++) {
            String listItem = list.get(i).getText();
            if (listItem.contains(name) && list.size() == 1){
                return true;
            }
        }

        return false;
    }

    public Boolean checkCartItems(String name){
        List<WebElement> list = webDriver.findElements(By.xpath("//*[@id=\"cart_summary\"]"));
        for (int i = 0; i < list.size(); i++) {
            String listItem = list.get(i).getText();
            if (listItem.contains(name)){
                return true;
            }
        }

        return false;
    }



    public WebElement getField(By locator){
        return webDriver.findElement(locator);
    }

    public Optional<String> getRegisterError(){return getWebErrorMsg(REGISTER_ERROR);}

    public Optional<String> getLetterError(){return getWebErrorMsg(LETTER_ERROR);}

    public Optional<String> getSearchWarning(){return getWebErrorMsg(SEARCH_WARING);}

    public Optional<String> getPasswordError(){return getWebErrorMsg(PASSWORD_WARING);}

    public Optional<String> getCartWarning(){return getWebErrorMsg(Cart_WARING);}

    public Optional<String> getPasswordRight(){return getWebErrorMsg(PASSWORD_RIGHT);}


    public Optional<String> getWebErrorMsg(By errorLocator){
        Optional<WebElement> webError = getWebError(errorLocator);
        if(webError.isPresent()){
            WebElement errorElement = webError.get();
            return Optional.of(errorElement.getText());
        }else return Optional.empty();
    }

    public Optional<WebElement> getWebError(By errorLocator){
        List<WebElement> webErrorsElements = webDriver.findElements(errorLocator);
        if (webErrorsElements.size() > 0){
            return Optional.of(webErrorsElements.get(0));
        }else return Optional.empty();
    }


}