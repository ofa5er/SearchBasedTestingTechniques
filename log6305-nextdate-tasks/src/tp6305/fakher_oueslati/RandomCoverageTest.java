package tp6305.fakher_oueslati;

import java.util.List;
import java.util.Random;

import tp6305.CoverageTest;

public class RandomCoverageTest extends CoverageTest {

	protected void generateTestData(StringBuilder builder, int[] testData) {
		randmonData(builder, testData);
	}
	


	protected void randmonData(StringBuilder builder, int[] testData) {
		int maxDay=50;
		int minDay=-1;
		int maxMonth=50;
		int minMonth=-1;
		int maxYear=3000;
		int minYear=2000;
		Random r = new Random();
		testData[0]=r.nextInt(maxDay-minDay) + minDay;
		testData[1]=r.nextInt(maxMonth-minMonth) + minMonth;
		testData[2]=r.nextInt(maxYear-minYear) + minYear;
		
		
		for (int i=0;i<3;i++)
		{
			
			builder.append(testData[i]).append(", ");
		}
		
		//Generate random numbers to each elements in testData, 
		//then put them in the StringBuilder as:		
		//builder.append(testData[i]).append(", ");
			
	}
	
}
