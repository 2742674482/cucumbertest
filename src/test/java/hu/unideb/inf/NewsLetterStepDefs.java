package hu.unideb.inf;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Optional;

import static org.junit.Assert.fail;

public class NewsLetterStepDefs extends AbstractStepDefs{

    @Given("the {string} is filled with {string} in newsletter")
    public void theFieldIsFilledWithParameterInNewsletter(String fieldName, String msg) {
        homePage.fillFieldById(fieldName, msg);
    }

    @When("submitNewsletter button clicked")
    public void submitnewsletterButtonClicked() {homePage.Clickenter();
    }

    @Then("the {string} error message comes")
    public void theMsgErrorMessageComes(String msg) {
        Optional<String> errorMessage = homePage.getLetterError();
        if (errorMessage.isPresent()) {
            Assert.assertEquals(msg,errorMessage.get());

        } else fail();
    }










}
