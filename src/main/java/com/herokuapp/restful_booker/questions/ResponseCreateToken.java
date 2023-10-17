package com.herokuapp.restful_booker.questions;

import com.herokuapp.restful_booker.models.responseCreateToken.AuthResponse;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ResponseCreateToken implements Question<AuthResponse> {
    @Override
    public AuthResponse answeredBy(Actor actor) {
        return SerenityRest.lastResponse().as(AuthResponse.class);
    }

    public static ResponseCreateToken was(){
        return new ResponseCreateToken();
    }
}
