package TestNG_Pratice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderEx1 {

	// Invocation Count:- Executing same method multiple times with same
	// set of data

	// DataProvider:- Executing same method multiple times with different
	// set of data

	@Test(dataProvider="getData")
	public void bookTickets(String src, String dest,int NoOfppl) {
		System.out.println("Book Tickets from " + src + " to " + dest +"---->"+NoOfppl+ "");
	}

	@DataProvider
	public Object[][] getData() {

		Object[][] objArr = new Object[3][3];

		objArr[0][0] = "Bangalore";
		objArr[0][1] = "goa";
		objArr[0][2]=3;

		objArr[1][0] = "bangalore";
		objArr[1][1] = "mysore";
		objArr[1][2]=3;
		
		objArr[2][0] = "Bangalore";
		objArr[2][1] = "pune";
		objArr[2][2]=3;

		return objArr;

	}
}
