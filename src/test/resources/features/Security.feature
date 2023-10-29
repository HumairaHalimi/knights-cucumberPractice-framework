@Smoke @Regression

Feature: Application security functions

  @US_3
  Scenario: validate login section title US_3
    Then Validate application title should be "Tek Insurance Service"
    Then Validate login section title "Customer Service Portal"

  @US_4
  Scenario: Validate login button disable and enabled US_4


    Then Validate login button is "disabled"

    When Enter username as "supervisor"

    When Enter password as "tek_supervisor"

    Then Validate login button is "enabled"

  @US_5
  Scenario: validate login with valid username and password US_5

 # Given Open browser and navigate  (@Before in Hook)

    When Enter username as "supervisor"

    When Enter password as "tek_supervisor"

    When Click on login button

    Then Validate the header title is "Tek Insurance App"

    Then Validate logged in username is "Supervisor"

  #Then Close Browser (@After in Hook)


#@US_6
   # Scenario: Validate negative data login
    #When Enter username as "wrong username"
    #When Enter password as "tek_supervisor"
    #When Click on login button
    #hen Validate error message "User wrong username not found"

#@US_7
#Scenario: Validate negative password  data login
 # When Enter username as "supervisor"
  #When Enter password as "wrong password"
  #When Click on login button
  #Then Validate error message "Password not matched"

  # NOTE: two scenarios with same parameters
  # we can use scenario outline +Examples.

  @US_6
  Scenario Outline: Validate negative data login
    When Enter username as "<username>"
    When Enter password as "<password>"
    When Click on login button
    Then Validate error message "<errorMessage>"

    Examples:
      | username      | password       | errorMessage                 |
      | wrongusername | tek_supervisor | User wrongusername not found |
      | supervisor    | wrongPassword  | Password not matched         |
      | Mohammadi      | tek_supervisor | User Mohammadi not found      |
      | Ali           | tek_supervisor | User Ali not found           |









