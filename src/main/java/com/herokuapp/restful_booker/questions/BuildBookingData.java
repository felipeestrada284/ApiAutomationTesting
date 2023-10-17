package com.herokuapp.restful_booker.questions;

import com.herokuapp.restful_booker.models.BookingDates;
import com.herokuapp.restful_booker.models.BookingModel;
import com.herokuapp.restful_booker.utils.Data;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.Map;

public class BuildBookingData implements Question<BookingModel> {

    Map<String, String> data = Data.extractTo().get(0);
    @Override
    public BookingModel answeredBy(Actor actor) {

        BookingDates bookingDates = BookingDates.builder()
                .checkin(data.get("checkin"))
                .checkout(data.get("checkout"))
                .build();

        return BookingModel.builder()
                .firstname(data.get("firstname"))
                .lastname(data.get("lastname"))
                .totalprice(Integer.valueOf(data.get("totalprice")))
                .depositpaid(Boolean.valueOf(data.get("depositpaid")))
                .bookingdates(bookingDates)
                .additionalneeds(data.get("additionalneeds"))
                .build();
    }

    public static BuildBookingData was(){
        return new BuildBookingData();
    }
}
