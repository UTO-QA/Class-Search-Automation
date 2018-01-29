Feature: Generate Statistics

    Scenario: TC_59_CC-935 VIP classes do not return the drawer or details page experiences
        Given The user is on Class Search page
        When User enters correct Subject and Number
        Then Clicking on Class record must return the drawer or details page experiences