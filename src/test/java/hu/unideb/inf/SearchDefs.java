package hu.unideb.inf;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Optional;

import static org.junit.Assert.fail;

public class SearchDefs extends AbstractStepDefs {



    @When("the search button is clicked")
    public void theSearchButtonIsClicked() {homePage.clickSearchButton();
    }

    @Then("the {string} error message is shown in search")
    public void theMsgErrorMessageIsShownInSearch(String msg) {
        Optional<String> errorMessage = homePage.getSearchWarningMsg();
        if (errorMessage.isPresent()){
            Assert.assertEquals(msg,errorMessage.get());

        }else fail();
    }

    @Given("the {string} is filled with {string} in search field")
    public void theSearchFieldIsFilledWithParameterInSearchField(String fieldName, String msg)
    {homePage.fillFieldById(fieldName, msg);}

    @When("the Enter button is pressed")
    public void theEnterButtonIsPressed() {
        homePage.pressEnterButton();
    }


    @Then("the {string}Gundam{string} error message is shown in search")
    public void theAbcdErrorMessageIsShownInSearch(String fieldName, String msg) {homePage.fillFieldById(fieldName, msg);}

    @Then("the related item {string} is listed in search")
    public void theRelatedItemIsListedInSearch(String name) {
        Assert.assertEquals(true,homePage.searchItem(name));
    }

    @Then("the related unique item {string} is listed in search")
    public void theRelatedUniqueItemIsListedInSearch(String name) {
        Assert.assertEquals(true,homePage.searchUniItem(name));
    }
}
