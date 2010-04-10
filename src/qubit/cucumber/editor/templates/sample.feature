@foo34 @bar # some comment
Feature: proof of concept
In order to read Cucumber features faster and eaiser on Github
As a Cucumber user
I want to have syntax highlighting for Gherkin
This is part of the narrative, even if I have the # symbol, it is still the narrative- not a comment

    Background: this is multi-line description
    do you like it?
    Given cheese is good

  Scenario Outline: this is a test
    this the second line of the desctiption
    Given I have a <var1> and some "string"
    And the following table and some 'string'
      | header 1 | header 2 | # here is a comment after a table
      | cell 1-1 | cell 1-2 |
      | cell 2-1 | "cell 2-2"|

    When I do <var2>
    And here is a string with single and double quotes- "i'll be back"
    And here is a string with the opposite 'the quote is "Foo"'
    And what about a var in a quote like so: "<var2>"
    And what about a multiline string with a var in it like so:
    """
Hello!
I am a multiple line string, often called a pystring.
I can have regular "double quotes" without a problem...
I can also sub in vars as well like: <var1> and <var2>
"""

    Then I should see something...
    But not something else...

  Examples:
    | var1 | var2 | # i am a comment
    | foo | bar |
    | dog | food |

  Scenarios: some other examples with a description
and guess waht?!? I can have multilines as well! # look at me, I'm a comment
Who would have thunk?
    | var1 | var2 |
    | foo | bar |
    | dog | food |

  @some_tag @another_tag
  Scenario: more examples
will follow after this multi-line description
Given some context# this is an inline comment
    # This is a comment
# So is this with no space at front...
