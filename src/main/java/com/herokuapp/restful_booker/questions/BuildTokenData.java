package com.herokuapp.restful_booker.questions;

import com.herokuapp.restful_booker.models.AuthModel;
import com.herokuapp.restful_booker.utils.Data;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.Map;

public class BuildTokenData implements Question<AuthModel> {
    Map<String, String> data = Data.extractTo().get(0);

    @Override
    public AuthModel answeredBy(Actor actor) {
        return AuthModel.builder()
                .username(data.get("username"))
                .password(data.get("password"))
                .build();
    }

    public static BuildTokenData was(){
        return new BuildTokenData();
    }
}
