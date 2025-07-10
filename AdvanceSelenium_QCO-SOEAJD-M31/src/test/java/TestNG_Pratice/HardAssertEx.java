package TestNG_Pratice;

import static org.testng.Assert.assertNotNull;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertEx {

	
	@Test
	public void m1()
	{
		System.out.println("Step1");
		System.out.println("Step2");
		Assert.assertEquals("B", "B");//---->Assertion Fail
		System.out.println("Step3");
		System.out.println("Step4");
	}
	
	@Test
	public void m2()
	{
		String expData="Qspiders";
		String actData="Qspiders";
		Assert.assertEquals(actData, expData);
		
	}
	
	@Test
	public void m3()
	{
		String expData="Qspiders";
		String actData="Qspiders";
		Assert.assertEquals(actData, expData, "Assert FAIL");
		System.out.println("Assert PASS");
	}
	
	@Test
	public void m4()
	{
		int ExpData=10;
		int actData=20;
		Assert.assertEquals(actData, ExpData, "Assert FAIL");
		System.out.println("Assert PASS");
	}
	
	@Test
	public void m5()
	{
		int expData=10;
		int actData=20;
		Assert.assertNotEquals(actData, expData,"ASSERT EQUAL");
		System.out.println("ASSERT NOT EQUAL");
	}
	
	@Test
	public void m6()
	{
		int expData=10;
		int actData=10;
		Assert.assertNotEquals(actData, expData,"ASSERT EQUAL");
		System.out.println("ASSERT NOT EQUAL");
	}
	
	@Test
	public void m7()
	{
		String expData = "Shobha";
		String actData = "Shobha";
		Assert.assertTrue(actData.equals(expData), "Assert FAIL");
		System.out.println("Assert PASS");
	}
	
	@Test
	public void m8()
	{
		String expData = "Shobha";
		String actData = "ShobhA";
		Assert.assertTrue(actData.equals(expData), "Assert FAIL");
		System.out.println("Assert PASS");
	}
	
	@Test
	public void m9()
	{
		String expData = "WelCome";
		String actData = "WelCome ";
		Assert.assertFalse(actData.equals(expData), "Assert FAIL");
		System.out.println("Assert PASS");
	}
	
	@Test
	public void m10()
	{
		String expData = "WelCome";
		String actData = "WelCome";
		Assert.assertFalse(actData.equals(expData), "Assert FAIL");
		System.out.println("Assert PASS");
	}
	
	@Test
	public void m11()
	{
		String s=null;
		Assert.assertNull(s, "Assert FAIL");
		System.out.println("Assert PASS");
	}
	
	@Test
	public void m12()
	{
		String s="Qspiders";
		Assert.assertNull(s, "Assert FAIL");
		System.out.println("Assert PASS");
	}
	
	@Test
	public void m13()
	{
		String a="TestYantra";
	   Assert.assertNotNull(a, "Assert FAIL");
	    System.out.println("Assert PASS");
	}
	
	@Test
	public void m14()
	{
		String a=null;
		Assert.assertNotNull(a, "Assert FAIL");
	    System.out.println("Assert PASS");
	}
	
	@Test
	public void m15()
	{
		int Exp=10;
		int act=10;
		Assert.assertSame(Exp, act, "Assert FAIL");
		System.out.println("Assert PASS");
	}
	
	@Test
	public void m16()
	{
		int Exp=10;
		int act=20;
		Assert.assertSame(Exp, act, "Assert FAIL");
		System.out.println("Assert PASS");
	}
	
	@Test
	public void m17()
	{
		int Exp=10;
		int act=20;
		Assert.assertNotSame(Exp, act, "Assert FAIL");
		System.out.println("Assert PASS");
	}
	
	@Test
	public void m18()
	{
		int Exp=10;
		int act=10;
		Assert.assertNotSame(Exp, act, "Assert FAIL");
		System.out.println("Assert PASS");
	}
	
	@Test
	public void m19()
	{
		Assert.fail("Im failing the script");
	}
	
	
	
}

