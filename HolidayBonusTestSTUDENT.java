import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HolidayBonusTestSTUDENT {
	
	private double[][] dataSet1 = {{1,2,3},{4,5},{6,7,8}};
	private double[][] dataSet2 = {{7,2,9,4},{5},{8,1,3},{11,6,7,2}};
	private double[][] dataSet3 = {{7.2,2.5,9.3,4.8},{5.9},{8.1,1.7,3.3},{11.6,6.9,7.3,2.7}};
	private double[][] dataSet4 = {{-2.5,-5.3,6.1},{-4.4,8.2},{2.3,-7.5},{-4.2,7.3,-5.9,2.6}};

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

		@Test
		public void testCalculateHolidayBonus() {
			try{
			double[] result = HolidayBonus.calculateHolidayBonus(dataSet1);
			assertEquals(3000.0,result[0],.001);
			assertEquals(4000.0,result[1],.001);
			assertEquals(15000.0,result[2],.001);
			
			result = HolidayBonus.calculateHolidayBonus(dataSet2);
			assertEquals(8000.0,result[0],.001);
			assertEquals(2000.0,result[1],.001);
			assertEquals(3000.0,result[2],.001);
			assertEquals(4000.0,result[3],.001);
			
			result = HolidayBonus.calculateHolidayBonus(dataSet3);
			assertEquals(8000.0,result[0],.001);
			assertEquals(2000.0,result[1],.001);
			assertEquals(3000.0,result[2],.001);
			assertEquals(4000.0,result[3],.001);
			
			result = HolidayBonus.calculateHolidayBonus(dataSet4);
			assertEquals(6000.0,result[0],.001);
			assertEquals(10000.0,result[1],.001);
			assertEquals(4000.0,result[2],.001);
			assertEquals(20000.0,result[3],.001);
			}
			catch (Exception e) {
				fail("This should not have caused an Exception");
			} 
			
		}

	@Test
	public void testCalculateTotalHolidayBonus() {
		assertEquals(22000.0,HolidayBonus.calculateTotalHolidayBonus(dataSet1),.001);
		assertEquals(17000.0,HolidayBonus.calculateTotalHolidayBonus(dataSet2),.001);
		assertEquals(17000.0,HolidayBonus.calculateTotalHolidayBonus(dataSet3),.001);
		assertEquals(40000.0,HolidayBonus.calculateTotalHolidayBonus(dataSet4),.001);

	}

}
