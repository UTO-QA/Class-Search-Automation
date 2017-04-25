# Class-Search-Automation
<p>
Introduction:<br>
This is a Behavioural Driven Development model for automation. The Testcases are provided in <b>Feature Files</b>.<br>
The feature files comprise of <br>
Scenario <br>
<t>Given <br>
  When <br>
  Then <br>
</p>

<p>
Usage:<br>
Import the Class-Search Automation project and Open using Eclipse.<br>
Navigate to /Class-Search Automation/src/edu/asu/classsearch/testrunner/ClassSearchTestsWithReport.java <br><br>
Set the features variable to the feature file you want to execute. Eg. features="src/edu/asu/classearch/features/test.feature".<br>
Run this using JUnit Configuration.
</p>
<p>
Once the tests have been executed. Run the same file using mvn verify.<br>
The results are located at /Class-Search Automation/target/cucumber-html-reports/cucumber-html-reports
</p>
