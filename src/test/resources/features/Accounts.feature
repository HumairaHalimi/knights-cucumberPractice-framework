Feature: CSR Accounts Page Feature

  Background:
    Given Login with username as "supervisor" and password as "tek_supervisor"
    When Wait 2 Second

  @US_9
  Scenario: validate account table rows
   # Given Login with username as "supervisor" and password as "tek_supervisor"
    #When Wait 2 Second
    When Click on "Accounts" Link
    When Wait 20 Second
    Then Validate accounts table have 10 rows
@US_10
  Scenario: Validate Change Item per page
   # Given Login with username as "supervisor" and password as "tek_supervisor"
   # When Wait 2 Second
    When Click on "Accounts" Link
    When Wait 20 Second
    Then Validate accounts table have 10 rows
    When change item per page to "25"
    When Wait 2 Second
    Then Validate accounts table have 25 rows
    When change item per page to "100"
    When Wait 2 Second
    Then Validate accounts table have 100 rows