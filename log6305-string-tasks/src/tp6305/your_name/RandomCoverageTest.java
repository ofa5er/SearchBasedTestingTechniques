package tp6305.your_name;

import java.util.List;

import tp6305.CoverageTest;

public class RandomCoverageTest extends CoverageTest {


	@Override
	protected void generateTestData(StringBuilder builder, String[] testData) {
		randmonData(builder, testData);
		
	}
	protected void randmonData(StringBuilder builder, String[] testData) {		
		
		//Generate random numbers to each elements in testData, 
		//then put them in the StringBuilder as:		
		//builder.append(testData[i]).append(", ");
		testData[0]="R2d!";
			
	}
	
	protected double computeBranchCoverage(List<String> instrumentingOutputs, String testData) {


		// Compute it accumulatively.
		// Only system.out.println(testData) when they contribute to increase the coverage.
			
		return 0.0;
	}

	
}
