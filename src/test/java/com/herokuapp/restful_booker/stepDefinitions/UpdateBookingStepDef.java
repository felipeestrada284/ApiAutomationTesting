package com.herokuapp.restful_booker.stepDefinitions;

import com.herokuapp.restful_booker.questions.ServerCodeResponse;
import com.herokuapp.restful_booker.tasks.CreateTokenAuthTask;
import com.herokuapp.restful_booker.tasks.GetBookingTask;
import com.herokuapp.restful_booker.tasks.UpdateBookingTask;
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

public class UpdateBookingStepDef {

    private EnvironmentVariables environmentVariables;
    Actor user = Actor.named("user");

    @Before
    public void setUpBaseUrl(){
        String theRestApiBaseUrl = environmentVariables.optionalProperty("restapi.baseurl")
                .orElse("https://restful-booker.herokuapp.com/");

        user.whoCan(CallAnApi.at(theRestApiBaseUrl));

    }

    @When("I consume the service and send the booking information and the id")
    public void iConsumeTheServiceAndSendTheBookingInformationAndTheId() {
        user.attemptsTo(UpdateBookingTask.on());

    }

    @Then("I can validate the service response put")
    public void iCanValidateTheServiceResponsePut() {
        Map<String, String> data = Data.extractTo().get(0);

        user.should(
                seeThat(
                        "The response code was: ",
                        ServerCodeResponse.was(),
                        equalTo(Integer.parseInt(data.get("status")))
                )
        );
    }
}
