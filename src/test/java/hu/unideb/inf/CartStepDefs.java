package hu.unideb.inf;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.Optional;

import static org.junit.Assert.fail;

public class CartStepDefs extends AbstractStepDefs {
    @Given("the Cart button is clicked")
    public void theCartButtonIsClicked() {
        homePage.clickCartButton();
    }

    @Then("the {string} error message is shown in cart")
    public void theErrorMessageIsShownInCart(String msg) {
        Optional<String> errorMessage = homePage.getCartWarningMsg();
        if (errorMessage.isPresent()){
            Assert.assertEquals(msg,errorMessage.get());

        }else fail();
    }

}
