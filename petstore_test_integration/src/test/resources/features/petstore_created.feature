Feature: created user sucess

  Background: end point petstore
    * url 'https://petstore.swagger.io/v2/user/createWithList'

  Scenario: create user successful
    * def dataAuth = read ('../data/created.json')
    Given request dataAuth
    When method POST
    Then status 200
    And match response.message == "ok"
    And assert responseTime < 1000

  Scenario: create user with get method
    * def dataAuth = read ('../data/created.json')
    When method GET
    Then status 405

  Scenario: created user with the wrong message body
    * def dobyRequest = [{"id": adssda,"username": "sergio","firstName": "Andres","lastName": "Builes","email": "sbuiles@hotmail.com","password": "abcd123","phone": "3005216465","userStatus": 1}]
    Given request dobyRequest
    When method POST
    Then status 500
    And print response.message == "something bad happened"