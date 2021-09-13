Feature: NHS Individual Benefit Eligibility Check
  As a person from Wales
  I need to know what help I can get with my NHS costs
  So that I can get the treatment I need

  Scenario: Under 16 from England should be eligible for NHS Benefit
    Given I am on NHS Home Page
    And I am a person from "England"
    And My GP practice is in Scotland or Wales
    And I am under 16
    Then I should get a result "You get help with NHS costs"

  Scenario: Under 16 from Scotland and living in Highlands should be eligible for NHS Benefit
    Given I am on NHS Home Page
    And I am a person from "Scotland"
    And I "live" in Highlands
    And I am under 16
    Then I should get a result "You get help with NHS costs"

  Scenario: Under 16 from Scotland and not living in Highlands should be eligible for NHS Benefit
    Given I am on NHS Home Page
    And I am a person from "Scotland"
    And I "do not live" in Highlands
    And I am under 16
    Then I should get a result "You get help with NHS costs"

  Scenario: Under 16 from Wales should be eligible for NHS Benefit
    Given I am on NHS Home Page
    And I am a person from "Wales"
    And I am under 16
    Then I should get a result "You get help with NHS costs"

  Scenario: Under 16 from Northern Ireland should be eligible for NHS Benefit
    Given I am on NHS Home Page
    And I am a person from "Northern_Ireland"
    Then I should get a result "You cannot use this service because you live in Northern Ireland"

  Scenario: Senior Citizen from England living with partner claiming no tax benefit
  with no injuries and have a home to live with more savings
    Given I am on NHS Home Page
    And I am a person from "England"
    And My GP practice is in Scotland or Wales
    And I am senior citizen
    And I "live" with partner
    And I "do not claim" Benefits or tax credits
    And I "have no" injuries while serving armed forces
    And I or my partner permanently "do not live" in a care home
    And I or my partner have "more" savings
    Then I should get a result "You get help with NHS costs"

  Scenario: Senior Citizen from Wales living with partner claiming no tax benefit with no injuries and have a home to live with more savings
    Given I am on NHS Home Page
    And I am a person from "Wales"
    And I am senior citizen
    And I "live" with partner
    And I "do not claim" Benefits or tax credits
    And I "have no" injuries while serving armed forces
    And I or my partner permanently "do not live" in a care home
    And I or my partner have "more" savings
    Then I should get a result "You get help with NHS costs"

  Scenario: Senior Citizen from Scotland living with partner claiming no tax benefit with no injuries and have a home to live with more savings
    Given I am on NHS Home Page
    And I am a person from "Scotland"
    And I "do not live" in Highlands
    And I am senior citizen
    And I "live" with partner
    And I "do not claim" Benefits or tax credits
    And I "have no" injuries while serving armed forces
    And I or my partner permanently "do not live" in a care home
    And I or my partner have "more" savings
    Then I should get a result "You get help with NHS costs"

  Scenario: Over 16 years age from England living with partner claiming no tax benefit with no injuries and have a home to live with more savings
    Given I am on NHS Home Page
    And I am a person from "England"
    And My GP practice is in Scotland or Wales
    And I am over 16
    And I "live" with partner
    And I "do not claim" Benefits or tax credits
    And I am "not a" pregnant or given a birth in the last 12 months
    And I "have no" injuries while serving armed forces
    And I do "not have" diabetes
    Then I should get a result "To check what help you can get with NHS charges, we need to know if you're affected by any of these conditions"

  Scenario: Over 16 years age from Wales living with partner claiming no tax benefit with no injuries and have a home to live with more savings with no diseases
    Given I am on NHS Home Page
    And I am a person from "Wales"
    And I am over 16
    And I "live" with partner
    And I "do not claim" Benefits or tax credits
    And I am "not a" pregnant or given a birth in the last 12 months
    And I "have no" injuries while serving armed forces
    And I do "not have" diabetes
    And I do "not have" glucoma
    And I or my partner permanently "do not live" in a care home
    And I or my partner have "more" savings
    Then I should get a result "You get help with NHS costs"

  Scenario: Over 16 years age from Wales living with partner claiming no tax benefit with no injuries and have a home to live with more savings with diabetes
    Given I am on NHS Home Page
    And I am a person from "Wales"
    And I am over 16
    And I "live" with partner
    And I "do not claim" Benefits or tax credits
    And I am "not a" pregnant or given a birth in the last 12 months
    And I "have no" injuries while serving armed forces
    And I do "have" diabetes
    And I do "not have" glucoma
    And I or my partner permanently "do not live" in a care home
    And I or my partner have "more" savings
    Then I should get a result "You get help with NHS costs"

  Scenario: Over 16 years age from Wales living with partner claiming no tax benefit with no injuries and have a home to live with more savings with diabetes and glucoma
    Given I am on NHS Home Page
    And I am a person from "Wales"
    And I am over 16
    And I "live" with partner
    And I "do not claim" Benefits or tax credits
    And I am "not a" pregnant or given a birth in the last 12 months
    And I "have no" injuries while serving armed forces
    And I do "have" diabetes
    And I do "have" glucoma
    And I or my partner permanently "do not live" in a care home
    And I or my partner have "more" savings
    Then I should get a result "You get help with NHS costs"

  Scenario: Over 16 years age from Wales living with partner claiming no tax benefit with injuries and have a home to live with more savings with diabetes and glucoma
    Given I am on NHS Home Page
    And I am a person from "Wales"
    And I am over 16
    And I "live" with partner
    And I "do not claim" Benefits or tax credits
    And I am "not a" pregnant or given a birth in the last 12 months
    And I "have" injuries while serving armed forces
    And I do "have" diabetes
    And I do "have" glucoma
    And I or my partner permanently "do not live" in a care home
    And I or my partner have "more" savings
    Then I should get a result "You get help with NHS costs"

  Scenario: Over 16 years age from Wales not living with partner and no tax benefit with injuries and dieses and living in Care Home with Help
    Given I am on NHS Home Page
    And I am a person from "Wales"
    And I am over 16
    And I "do not live" with partner
    And I "do not claim" Benefits or tax credits
    And I am "not a" pregnant or given a birth in the last 12 months
    And I "have" injuries while serving armed forces
    And I do "have" diabetes
    And I do "have" glucoma
    And I or my partner permanently "live" in a care home
    And I "get" help to pay for care home
    Then I should get a result "You get help with NHS costs"

  Scenario: Over 16 years age from Wales not living with partner and no tax benefit with injuries and dieses and living in Care Home with No Help and no savings
    Given I am on NHS Home Page
    And I am a person from "Wales"
    And I am over 16
    And I "do not live" with partner
    And I "do not claim" Benefits or tax credits
    And I am "not a" pregnant or given a birth in the last 12 months
    And I "have" injuries while serving armed forces
    And I do "have" diabetes
    And I do "have" glucoma
    And I or my partner permanently "live" in a care home
    And I "do not get" help to pay for care home
    And I or my partner have "no" savings
    Then I should get a result "You get help with NHS costs"

  Scenario: Over 16 years age from Wales not living with partner and no tax benefit with injuries and dieses and living in Care Home with No Help with savings
    Given I am on NHS Home Page
    And I am a person from "Wales"
    And I am over 16
    And I "do not live" with partner
    And I "do not claim" Benefits or tax credits
    And I am "not a" pregnant or given a birth in the last 12 months
    And I "have" injuries while serving armed forces
    And I do "have" diabetes
    And I do "have" glucoma
    And I or my partner permanently "live" in a care home
    And I "do not get" help to pay for care home
    And I or my partner have "more" savings
    Then I should get a result "You get help with NHS costs"