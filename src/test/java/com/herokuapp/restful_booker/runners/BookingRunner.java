package com.herokuapp.restful_booker.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        glue = "com.herokuapp.restful_booker.stepDefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        tags = "@Auth or @CreateBooking or @GetBooking or @UpdateBooking or @DeleteBooking"
)
public class BookingRunner {
}
