package hu.unideb.inf;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import java.util.Optional;
import static org.junit.Assert.fail;

public class CreateAccountStepdefs extends AbstractStepDefs{


    @And("the Sign In link is clicked in CreatAccount")
    public void theSignInLinkIsClicked() {homePage.clickSignInButton();}

    @Given("the {string} is filled with {string} in email address")
    public void theFieldIsFilledWithParameterInEmailAddress(String fieldName, String msg) {
        homePage.fillFieldById(fieldName, msg);}

    @When("the Create an account button is clicked")
    public void theCreateAnAccountButtonIsClicked() {homePage.CreateAnAccountButton();}

    @Then("the {string} error message is shown out")
    public void theMsgErrorMessageIsShownOut(String msg) {
        Optional<String> errorMessage = homePage.getRegisterError();
        if (errorMessage.isPresent()) {
            Assert.assertEquals(msg,errorMessage.get());

        } else fail();
    }






}
