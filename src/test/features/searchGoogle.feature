Feature: Google search
    As a user
    I want to be able to search for information on Google

    @smoke
    Scenario: Search temperature in Google
        Given the user open the web browser
        When the user search "Peru temperature"
        Then the temperature should be "24"

    @smoke
    Scenario: Search temperature with endpoint
        When the user search the latitude "12", longitude "12"
        Then the temperature should be "302"

    @smoke
    Scenario Outline: Search more than one temperatures in Google
        Given the user open the web browser
        When the user search country "<country>"
        Then the country temperature should be "<value>"
        Examples:
        |country               |value|
        |Chile temperature     | 16  |
        |Colombia temperature  | 16  |
        |Venezuela temperature | 27  |