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
public class BookingDatesResponse {

    @JsonProperty("checkin")
    public String checkin;

    @JsonProperty("checkout")
    public String checkout;
}
