package edu.asu.classsearch.testcases.def;

import cucumber.api.java.en.When;
import edu.asu.classsearch.pages.*;

public class classearch_crosspage_functionalities {
	private Loginpage page=new Loginpage();
	private classearch_add_a_class peoplesoft_1= new classearch_add_a_class();
	//TEST 19
	@When("^A User selects Session C and performs a searchq$")
	public void addcourse(){
		classearch_HomePage_Methods.getconn();
		classearch_HomePage_Methods.check_ifopenorall("open");
		classearch_HomePage_Methods.subjectandnumber("CSE","595");
		classearch_HomePage_Methods.performsearch();
		classearch_HomePage_Methods.addcourse();
		page.get_login();
		peoplesoft_1.select_an_instructor();
		peoplesoft_1.navigate_next();
	}
}
