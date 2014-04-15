package tp6305.fakher_oueslati;

import tp6305.CoverageTest;

public class CoverageTestMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

				
	//	CoverageTest coverageTest = new RandomCoverageTest();
		
		CoverageTest coverageTest = new SearchBasedCoverageTest();

		testBranchCoverage(coverageTest, 0.70);
				
//		testBranchCoverage(coverageTest, 0.95);
		
//		testRACC(coverageTest, 0.70);
//		
//		testRACC(coverageTest, 0.99);
		

	}

	private static void testBranchCoverage(CoverageTest coverageTest,
			double coverageThreshold) {
		int total = 0;
		for (int i = 0; i < 1; i++) {
			
			coverageTest.testBranchCoverage(coverageThreshold);

			System.out.println("BranchCoverage is "
					+ coverageTest.getBranchCoverage());
			System.out.println("Number of iteration is "
					+ coverageTest.getIterationNum());
			total+=coverageTest.getIterationNum();
		}
		
		System.out.println("To reach " + coverageThreshold*100 + "% branch coverage, the average iteration number is " + total/3);
	}
	
	private static void testRACC(CoverageTest coverageTest,
			double coverageThreshold) {
		int total = 0;
		for (int i = 0; i < 3; i++) {
			
			coverageTest.testRACC(coverageThreshold);

			System.out.println("RACC is "
					+ coverageTest.getRACC());
			System.out.println("Number of iteration is "
					+ coverageTest.getIterationNum());
			total+=coverageTest.getIterationNum();
		}
		
		System.out.println("To reach " + coverageThreshold*100 + "% RACC, the average iteration number is " + total/3);
	}

}
