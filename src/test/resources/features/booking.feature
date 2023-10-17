Feature: Booking

  @Auth
  Scenario: Creates a new auth token to use for access to the PUT and DELETE
    When I consume the service auth
    Then I can validate the generated token

  @CreateBooking
  Scenario: Creates a new booking in the API
    When I consume the service and I send booking information
    Then I can validate the booking id

  @GetBooking
  Scenario: Returns a specific booking based upon the booking id provided
    When I consume the service and booking id
    Then I can validate the service response get

  @UpdateBooking
  Scenario: Updates a current booking
    When I consume the service and send the booking information and the id
    Then I can validate the service response put

  @DeleteBooking
  Scenario: Returns the ids of all the bookings that exist within the API
    When I consume the service delete and send booking id
    Then I can validate the service response delete

