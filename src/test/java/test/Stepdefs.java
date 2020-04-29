package test;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static junit.framework.Assert.assertEquals;


class StopCoronavirus {
    public static String CoronavirusIsCommon(int number) {
        return 10 == number ? "Quarantine is over!" : "Quarantine is going on!";
    }
}

public class Stepdefs {

    private int number;
    private String actualAnswer;
    private String stopCarantin;

    @Given("number of ill people is {int}")
    public void number_of_ill_people_is(int number) {
        this.number = number;
    }

    @When("I ask whether it's quarantine is over")
    public void i_ask_whether_it_s_quarantine_is_over() {
        actualAnswer = StopCoronavirus.CoronavirusIsCommon(number);
    }

    @Then("I should be told \"(.+)\"")
    public void i_should_be_told(String expectedAnswer) {
        assertEquals(expectedAnswer, actualAnswer);
    }

    @Given("quarantine is over")
    public void quarantine_is_over() {
        stopCarantin = "Yes, you can!";
    }

    @When("I ask whether i can go to cinema")
    public void i_ask_whether_i_can_go_to_cinema() {
        actualAnswer = stopCarantin;
    }
}
