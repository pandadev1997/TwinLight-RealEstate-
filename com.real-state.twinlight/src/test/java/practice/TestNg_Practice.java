package practice;

import org.testng.annotations.Test;

public class TestNg_Practice {
	
	@Test(priority = 2,invocationCount = 3)
	public void create() {
		System.out.println("---created---");
	}
	@Test(enabled = true)
	public void  update() {
		System.out.println("---data updated---");
	}
	@Test(dependsOnMethods = "update")
	public void delete() {
		System.out.println("--deleted---");
	}
	
	

}
