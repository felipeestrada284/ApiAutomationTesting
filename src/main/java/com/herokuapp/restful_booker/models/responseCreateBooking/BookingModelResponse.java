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
public class BookingModelResponse {

    @JsonProperty("bookingid")
    public Integer bookingid;

    @JsonProperty("booking")
    public BookingResponse booking;
}
