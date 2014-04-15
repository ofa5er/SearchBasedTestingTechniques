package tp6305.fakher_oueslati;

import java.util.List;
import java.util.Random;

import tp6305.CoverageTest;

public class RandomCoverageTest extends CoverageTest {

	int asciiMax=127;
	int asciiMin=32;
	@Override
	protected void generateTestData(StringBuilder builder, String[] testData) {
		randmonData(builder, testData);
		
	}
	protected void randmonData(StringBuilder builder, String[] testData) {		
		
		//Generate random numbers to each elements in testData, 
		//then put them in the StringBuilder as:		
		//builder.append(testData[i]).append(", ");
	//	testData[0]="R2d!";
		testData[0]="";
		for (int i=0;i<4;i++)
		{
			Random r = new Random();
			int randomAscii=r.nextInt(asciiMax-asciiMin) + asciiMin;
			testData[0]+=Character.toString ((char) randomAscii);
		}
		
	}
	
	protected double computeBranchCoverage(List<String> instrumentingOutputs, String testData) {


		// Compute it accumulatively.
		// Only system.out.println(testData) when they contribute to increase the coverage.
			
		return 0.0;
	}

	
}
