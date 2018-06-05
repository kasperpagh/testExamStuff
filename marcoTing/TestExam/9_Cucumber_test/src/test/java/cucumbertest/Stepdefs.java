package cucumbertest;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import shop.Customer;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;


public class Stepdefs {
    private Customer customer;
    private double budget;
    private String errorMessage = "Not enough money";


    @Given("^I have \\$(\\d+) in my vallet$")
    public void I_have_$_in_my_vallet(double amount) throws Exception {
        customer = new Customer(amount);
    }

    @When("^I spent \\$(\\d+)$")
    public void I_spent_$(double amount) throws Exception {
        try {
            budget = customer.useMoney(amount);
        } catch (Exception ex) {
            errorMessage = ex.getMessage();
        }
    }

    @Then("^The outcome should be I spent \\$(\\d+)$")
    public void The_outcome_should_be_$(double amount) throws Exception {
        assertThat(amount, is(budget));
    }

    @Then("^I should have \\$(\\d+) in my vallet$")
    public void I_should_have$_in_my_wallet(double amount) throws Exception {
        double accountBalance = customer.getVallet();
    }

    @Then("^The outcome should be I don't have enough money$")
    public void error_msg() throws Exception {
        assertEquals(errorMessage, "Not enough money");
    }

}