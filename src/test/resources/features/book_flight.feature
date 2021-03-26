Feature: Book a flight
  As a traveller
  I want to book a flight
  To able to travel

  Scenario: Book the cheaper flight in Vivaair from Medellin to Bogota
    Given Andres want to flight to Bogota tomorrow
    When Andres book the flight from Medellin to Bogota
    Then Andres should see the flight cheaper