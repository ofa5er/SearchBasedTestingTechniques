package tp6305.fakher_oueslati;

import java.util.List;
import java.util.Random;

import tp6305.CoverageTest;

public class RandomCoverageTest extends CoverageTest {

	protected void generateTestData(StringBuilder builder, int[] testData) {
		randmonData(builder, testData);
	}
	


	protected void randmonData(StringBuilder builder, int[] testData) {
		
		Random r = new Random();
		testData[0]=r.nextInt(50-0) + 0;
		testData[1]=r.nextInt(30-0) + 0;
		testData[2]=r.nextInt(3000-2000) + 2000;
		
		
		for (int i=0;i<3;i++)
		{
			
			builder.append(testData[i]).append(", ");
		}
		
		//Generate random numbers to each elements in testData, 
		//then put them in the StringBuilder as:		
		//builder.append(testData[i]).append(", ");
			
	}
	
}
