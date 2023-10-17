package com.herokuapp.restful_booker.tasks;

import com.herokuapp.restful_booker.models.AuthModel;
import com.herokuapp.restful_booker.questions.BuildTokenData;
import com.herokuapp.restful_booker.questions.ResponseCreateToken;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static com.herokuapp.restful_booker.utils.GlobalVariable.token;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CreateTokenAuthTask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        AuthModel authModel = actor.asksFor(BuildTokenData.was());

        actor.attemptsTo(
                Post.to("auth").with(
                        requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)
                                .body(authModel)
                                .log().all()
                )
        );

        token = ResponseCreateToken.was().answeredBy(actor).getToken();
        System.out.println("token: " + token);
    }

    public static CreateTokenAuthTask on(){
        return instrumented(CreateTokenAuthTask.class);
    }
}
