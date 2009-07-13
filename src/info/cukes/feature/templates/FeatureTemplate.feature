# template file

Feature: Template
    In order to cuke faster
    As a cucumber user
    I want to have a template file

    Background:
    Given the new version of this module

    @new
    Scenario: Template Scenario
    Given NetBeans as IDE
    And the following things
    |thing|
    | ... |
    When I go to File, New File
    And I select the folder named "Cucumber"
    Then I should see 'FeatureTemplate.feature'

    Scenario Outline: Outline Template
    Given more test samples
    When I want to test all of them
    Then I can use a <variable> to specify some test data
    And I see the <result>

    Examples:
    | variable  | result |
    | true      | true   |
    | false     | false  |
    | "dummy"   | 'no'   |
