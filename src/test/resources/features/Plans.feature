Feature: CSR Plans Page Feature

  Background:
    Given Login with username as "supervisor" and password as "tek_supervisor"

    When Wait 2 Second

    When Click on "Plans" Link

  @US_8
  Scenario: Validating plans are exist in table

    Then Validate Section title is "Plans"

    Then Validate Table row is 4

    And Validate All Plans are Valid

  @US_11
  Scenario:Validate plan code header using List of list

    Then Validate Section title is "Plans"

    #And Validate plan table header as list of maps because it has header
      #| 0         | 1          | 2           | 3          | 4            | 5           |
     # | Plan Type | Base Price | Date Expire | Created By | Date Created | Plan Expired |
    And Validate plan table header

      | Plan Type | Base Price | Date Expire | Created By | Date Created | Plan Expired |

  @US_15
  Scenario: validate plan Table headers with  single list
    Then Validate Section title is "Plans"
    Then validate table header with single list

      | Plan Type    |
      | Base Price   |
      | Date Expire  |
      | Created By   |
      | Date Created |
      | Plan Expired |


  @US_13
  Scenario:validate plan Data using list of list
    Then Validate Section title is "Plans"
    Then Validate plan table data
      | Motorcycle | System | Valid |
      | Boat       | System | Valid |
      | Renters    | System | Valid |
      | Auto       | System | Valid |
      #List of lists
  #[[Motorcycle, System, Valid],
  # [Boat, System, Valid],
  # [Renters, System, Valid],
  # [Auto, System, Valid]]

  @US_14
  Scenario: Validate plan data using map data table.
    Then Validate Section title is "Plans"
    Then Validate plan table data with maps
      | planType   | createdBy | isExpired |
      | Motorcycle | System    | Valid     |
      | Boat       | System    | Valid     |
      | Renters    | System    | Valid     |
      | Auto       | System    | Valid     |
  # data has headers
    # [
    # {
    # "planType": "Motorcycle",
    # "createdBy": "System",
    # "isExpired": "Valid"
    # },
    # {
    # "planType": "Boat",
    # "createdBy": "System",
    # "isExpired": "Valid"
    # }
    # ......
    # ]
  @US_16
  Scenario: validate plan Table headers with  single map
    Then Validate Section title is "Plans"
    Then validate Plan Data first row only with single map

      | planType  | Motorcycle |
      | createdBy | System     |
      | isExpired | Valid      |
