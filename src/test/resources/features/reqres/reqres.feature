Feature: Request services from ReqRes

  Scenario Outline: Get a specific user by id
    When I look up a user by <id>
    Then The email and first name should be <email> <first_name>
    Examples:
    |id|email|first_name|
    |2|janet.weaver@reqres.in|Janet|

  Scenario Outline: Post a new user
    When I save a new user with <name> and <job>
    Then The response return an id
    Examples:
    |name|job|
    |nameDummy|jobDummy|

  Scenario: Delete an user
    When I delete an user with id
    Then The response code should be 204