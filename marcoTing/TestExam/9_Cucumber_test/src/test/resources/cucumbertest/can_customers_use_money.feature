Feature: Can Customers User Money
  Customers use money

  Scenario Outline:
    Given I have <Vallet> in my vallet
    When I spent <Budget>
    Then The outcome should be <Outcome>
    And I should have <Remaining> in my vallet

    Examples:
      |Vallet|Budget|Remaining|Outcome                      |
      |$1337  |$337   |$1000     |I spent $337              |
      |$100   |$100   |$0        |I spent $100              |
      |$100   |$200   |$100      |I don't have enough money |