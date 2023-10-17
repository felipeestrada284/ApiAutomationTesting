package com.herokuapp.restful_booker.questions;

import com.herokuapp.restful_booker.models.responseCreateBooking.BookingModelResponse;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ResponseCreateBooking implements Question<BookingModelResponse> {
    @Override
    public BookingModelResponse answeredBy(Actor actor) {
        return SerenityRest.lastResponse().as(BookingModelResponse.class);
    }

    public static ResponseCreateBooking was(){
        return new ResponseCreateBooking();
    }
}
