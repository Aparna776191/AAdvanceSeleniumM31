package TestNG_Pratice;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

@Test
public class SampleTest {

	
	public void createProduct() {
		System.out.println("product is Created");
	}

	
    public void modifyProduct() {
		System.out.println("product is modified");
	}


    public void deleteProduct() {
		System.out.println("product is deleted");
	}
}
