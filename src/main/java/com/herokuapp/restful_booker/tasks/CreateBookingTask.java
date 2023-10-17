package com.herokuapp.restful_booker.tasks;

import com.herokuapp.restful_booker.models.BookingModel;
import com.herokuapp.restful_booker.questions.BuildBookingData;
import com.herokuapp.restful_booker.questions.ResponseCreateBooking;
import com.herokuapp.restful_booker.utils.Data;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import java.util.Map;

import static com.herokuapp.restful_booker.utils.GlobalVariable.bookingId;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CreateBookingTask implements Task {

    Map<String, String> data = Data.extractTo().get(0);

    @Override
    public <T extends Actor> void performAs(T actor) {

        BookingModel bookingModel = actor.asksFor(BuildBookingData.was());

        actor.attemptsTo(
                Post.to(data.get("endPoint")).with(
                        requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)
                                .body(bookingModel)
                                .log().all()
                )
        );

        bookingId = ResponseCreateBooking.was().answeredBy(actor).getBookingid();
        System.out.println("Booking id: " + bookingId);
    }

    public static CreateBookingTask on(){
        return instrumented(CreateBookingTask.class);
    }
}
