package com.herokuapp.restful_booker.stepDefinitions;


import com.herokuapp.restful_booker.questions.ResponseCreateBooking;
import com.herokuapp.restful_booker.questions.ServerCodeResponse;
import com.herokuapp.restful_booker.tasks.CreateBookingTask;
import com.herokuapp.restful_booker.utils.Data;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class CreateBookingStepDef {
    private EnvironmentVariables environmentVariables;
    Actor user = Actor.named("user");

    @Before
    public void setUpBaseUrl(){
        String theRestApiBaseUrl = environmentVariables.optionalProperty("restapi.baseurl")
                .orElse("https://restful-booker.herokuapp.com/");

        user.whoCan(CallAnApi.at(theRestApiBaseUrl));

    }

    @When("I consume the service and I send booking information")
    public void iConsumeTheServiceAndISendBookingInformation() {
        user.attemptsTo(CreateBookingTask.on());


    }

    @Then("I can validate the booking id")
    public void iCanValidateTheBookingId() {
        Map<String, String> data = Data.extractTo().get(0);

        user.should(
                seeThat(
                        "The response code was: ",
                        ServerCodeResponse.was(),
                        equalTo(Integer.parseInt(data.get("status")))
                ),
                seeThat(
                        "the first name of the booking was: ",
                        res -> ResponseCreateBooking.was().answeredBy(user).booking.getFirstname(),
                        equalTo(data.get("firstname"))
                )
        );
    }


}
