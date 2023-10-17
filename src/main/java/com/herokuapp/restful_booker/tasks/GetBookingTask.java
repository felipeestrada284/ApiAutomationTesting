package com.herokuapp.restful_booker.tasks;

import com.herokuapp.restful_booker.utils.Data;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import java.util.Map;

import static com.herokuapp.restful_booker.utils.GlobalVariable.bookingId;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetBookingTask implements Task {
    Map<String, String> data = Data.extractTo().get(0);

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(data.get("endPoint")+"/"+bookingId).with(
                        requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)
                )
        );
    }

    public static GetBookingTask on(){
        return instrumented(GetBookingTask.class);
    }
}
