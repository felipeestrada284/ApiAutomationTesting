package com.herokuapp.restful_booker.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ServerCodeResponse implements Question<Object> {
    @Override
    public Object answeredBy(Actor actor) {
        return SerenityRest.lastResponse().statusCode();
    }

    public static Question<Object> was(){
        return new ServerCodeResponse();
    }
}
