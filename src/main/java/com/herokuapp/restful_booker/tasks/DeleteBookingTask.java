package com.herokuapp.restful_booker.tasks;

import com.herokuapp.restful_booker.models.BookingModel;
import com.herokuapp.restful_booker.questions.BuildBookingData;
import com.herokuapp.restful_booker.utils.Data;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Delete;
import net.serenitybdd.screenplay.rest.interactions.Put;

import java.util.Map;

import static com.herokuapp.restful_booker.utils.GlobalVariable.bookingId;
import static com.herokuapp.restful_booker.utils.GlobalVariable.token;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DeleteBookingTask implements Task {
    Map<String, String> data = Data.extractTo().get(0);

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Delete.from(data.get("endPoint")+"/"+bookingId).with(
                        requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)
                                .header("Cookie", "token="+token)
                )
        );
    }

    public static DeleteBookingTask on(){
        return instrumented(DeleteBookingTask.class);
    }
}
