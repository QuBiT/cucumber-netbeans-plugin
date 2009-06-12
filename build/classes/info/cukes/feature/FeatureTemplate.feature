# template file

Feature: Template
    In order to cuke faster
    As a cuker
    I want to have a template file

    Background:
    Given the new version of this module

    @new
    Scenario: Template Scenario
    Given NetBeans as IDE
    When I go to File, New File
    And I select the folder named "Cucumber"
    Then I should see 'FeatureTemplate.feature'

    Scenario Outline: Outline Template
    Given more test samples
    When I want to test all of them
    Then I can use a Examples as a Table
    And I see <action>

    Examples:
    | test  | result |
    | true  | true   |
    | false | false  |
    