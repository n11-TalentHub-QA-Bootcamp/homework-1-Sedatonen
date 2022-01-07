Feature: List favorites

  @votes
  Scenario Outline: creating votes and listing for all votes
    Given I check of votes for this "<sub_id>"
    When I will create one more vote with "<sub_id>" and "<image_id>"
    Then I will check of my vote
    Examples:
      | sub_id       | image_id |
      | my-user-1234 | c1idf1   |
      | my-user-1234 | c1id2    |
      | my-user-1234 | c1id3    |