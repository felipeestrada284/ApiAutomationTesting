package com.herokuapp.restful_booker.models.responseCreateBooking;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookingResponse {

    @JsonProperty("firstname")
    public String firstname;

    @JsonProperty("lastname")
    public String lastname;

    @JsonProperty("totalprice")
    public Integer totalprice;

    @JsonProperty("depositpaid")
    public Boolean depositpaid;

    @JsonProperty("bookingdates")
    public BookingDatesResponse bookingdates;

    @JsonProperty("additionalneeds")
    public String additionalneeds;
}
