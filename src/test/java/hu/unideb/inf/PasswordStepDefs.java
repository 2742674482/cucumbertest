package hu.unideb.inf;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Optional;

import static org.junit.Assert.fail;

public class PasswordStepDefs extends AbstractStepDefs {


    @And("the Sign In link is clicked for password test")
    public void theSignInLinkIsClicked() {
        homePage.clickSignInButton();
    }

    @And("the forget your password button is clicked")
    public void theForgetYourPasswordButtonIsClicked() {
        homePage.clickForgetPassword();
    }


    @Given("the {string} is filled with {string} in email")
    public void theFieldIsFilledWithParameterInEmail(String fieldName, String msg) {
        homePage.fillFieldById(fieldName, msg);
    }


    @When("the Retrieve Password button is clicked")
    public void theRetrievePasswordButtonIsClicked() {
        homePage.clickRetrievePasswordButton();
    }

    @Then("the {string} error message is shown above")
    public void theMsgErrorMessageIsShownAbove(String msg) {
        Optional<String> errorMessage = homePage.getPasswordError();
        if (errorMessage.isPresent()) {
            Assert.assertEquals(msg, errorMessage.get());

        } else fail();
    }

    @Then("the {string}  message is shown")
    public void theMessageIsShown(String msg) {
        Optional<String> errorMessage = homePage.getPasswordRightMsg();
        if (errorMessage.isPresent()) {
            Assert.assertEquals(msg, errorMessage.get());

        } else fail();
    }

    }

