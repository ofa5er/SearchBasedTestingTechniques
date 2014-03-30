package tp6305.your_name;

import java.util.ArrayList;
import java.util.List;

public class SearchBasedCoverageTest extends RandomCoverageTest {

	List<ExePath> exePaths = new ArrayList<ExePath>();	
	int cursor;
	
	public SearchBasedCoverageTest() {
		this.initBranches();
	}

	@Override
	protected void generateTestData(StringBuilder builder, String[] testData) {

		// TODO generate the initial test data randomly.
		ExePath exePath = this.exePaths.get(cursor);

		int num = 0;
		
		while (num != exePath.conditions.size()) {
			for (Condition condition : exePath.conditions) {
				String a = "";
				String b = "";
				
//				if (condition.left == 0) {
//					a = (int) testData[0];
//				}
				// Similar operation for b
				
				int fit = FitnessFunction.compute(a, b, condition.operator,
						condition.result);
				if (fit == 0) {
					num++;
				} else {
					// Change a or b according to fit
					// update the correspond elements of testData
					this.iterationNum++;
					num =0;
					break;
				}
			}
		}		
		cursor++;

	}

	@Override
	protected double computeBranchCoverage(List<String> outputs, String testData) {
		// TODO Auto-generated method stub
		return 0;
	}


	private void initBranches() {
		// TODO
	}
}
