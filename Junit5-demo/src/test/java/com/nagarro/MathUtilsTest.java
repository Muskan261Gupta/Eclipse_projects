package com.nagarro;

//import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.api.TestInstance;
//import org.junit.jupiter.api.condition.EnabledOnOs;
//import org.junit.jupiter.api.condition.OS;
//import org.junit.jupiter.api.Disabled;

//@TestInstance(TestInstance.Lifecycle.PER_CLASS)// creates instance only once
//@TestInstance(TestInstance.Lifecycle.PER_METHOD)// creates instance before every method
@DisplayName("Running MathUtils")
class MathUtilsTest {

	MathUtils math;
	TestInfo testInfo;
	TestReporter testReporter;
	
	@BeforeAll
	static void beforeall() {
		System.out.println("This test needs to be run before all------------------");
	}
	
	@BeforeEach
	void init(TestInfo testInfo,TestReporter testReporter) {
		this.testInfo=testInfo;
		this.testReporter=testReporter;
		math=new MathUtils();
		System.out.println("New instance created...");
		testReporter.publishEntry("Running "+testInfo.getDisplayName()+" with tags"+testInfo.getTags());
	}
	
	@AfterEach
	void clean() {
		System.out.println("Cleaning up....");
	}
	
	@Test
	@DisplayName("Testing add function")
//	@EnabledOnOs(OS.LINUX) // Enabled only in Linux machine
//	@Tag("Math")  used when we want to run only particular tagged test cases rest will not be run.
	void test() {
//		fail("Not yet implemented");
//		System.out.println("This test ran");
			
		int expected=3;
		int actual=math.add(-2, 5);
		assertEquals(expected,actual);
		
	}
	
//	@Test
//	void test1() {
//		System.out.println("done");
//	}
	
	@Test
	void testDivide() {
//		MathUtils math=new MathUtils();
//		try {
//			math.divide(2, 0);
//		}
//		catch(Exception e) {
//			System.out.println("Divide by zero");
//		}  OR
		
		// assume true 
		boolean isServerUp=true;
//		boolean isServerUp=false;
		assumeTrue(isServerUp);
		
//		assertThrows(ArithmeticException.class, ()-> math.divide(2, 0));
	}
	
	
//	@Test
	@RepeatedTest(3)
	void testComputeCircleRadius(RepetitionInfo repetitionInfo ) {
//		MathUtils math=new MathUtils();
//		System.out.println(repetitionInfo.getTotalRepetitions());
		assertEquals(314.1592653589793, math.computeCircleArea(10),"Should return the area of a circle");
	}
	
//	@Test
////	@Disabled
//	@DisplayName("TDD method for checking")
//	void disabledFunction() {
//		fail("Not yet implemented");
//	}
	
	
	@Test
	@Tag("Math")
	@DisplayName("Multiply method")
	void testMultiply() {
//		assertEquals(4,math.multiply(2, 2)); 
//		System.out.println("Running "+testInfo.getDisplayName()+" with tags"+testInfo.getTags());
//		testReporter.publishEntry("Running "+testInfo.getDisplayName()+" with tags"+testInfo.getTags());
		assertAll(
				()-> assertEquals(4,math.multiply(2, 2)),
				()-> assertEquals(0,math.multiply(2, 0)),
				()-> assertEquals(-2,math.multiply(2, -1))
				);	
	}
	
	@Nested
	@DisplayName("adding test")
	class AddTest {
		
		@Test
		@DisplayName("Testing add function for +")
		void testPositive() {
			assertEquals(2,math.add(1, 1));
			
		}
		
		@Test
		@DisplayName("Testing add function for -")
		void testNegative() {
//			assertEquals(-2,math.add(-1, -1),"should return sum of negative number");
			
//          use lambda because it will only create string if the test fails so it is a kind of optimization and 
			// if the test is sucessfull then string is not created so saves space and time.
			assertEquals(-2,math.add(-1, -1),()->"should return sum of negative number");
			
		}
	}

}
