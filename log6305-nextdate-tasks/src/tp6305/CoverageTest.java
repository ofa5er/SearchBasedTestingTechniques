package tp6305;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import nextdate.InstrumentedNextDate;

public abstract class CoverageTest {

	private static final int BRANCH_NUM = 2;
	protected static final int SEED = 3000;
	
	private double branchCoverage;
	private double racc;

	protected Set<String> branchesTested = new HashSet<String>();

	private Set<String> activeClausesTested = new HashSet<String>();

	protected int iterationNum;

	private static int AC_BRANCH_NUM = 33 + 19;
	
	private InstrumentedNextDate instrumentedNextDate = new InstrumentedNextDate();
	

	public double getBranchCoverage() {
		return branchCoverage;
	}

	public double getRACC() {
		return racc;
	}

	public int getIterationNum() {
		return iterationNum;
	}

	public void testBranchCoverage(double coverageThreshold) {

		this.reset();

		fourInputsTestForBranchCoverage();

		StringBuilder builder = new StringBuilder();

		while (true) {
			runTest(builder);
			branchCoverage = this.computeBranchCoverage(
					instrumentedNextDate.getOutputs(), builder.toString());

			if (branchCoverage >= coverageThreshold) {
				outputCoveredCode(this.branchesTested);
				break;
			}
		}
	}

	protected void reset() {

		this.iterationNum = 0;
		this.branchesTested.clear();
		this.instrumentedNextDate.getOutputs().clear();

	}

	public void testRACC(double coverage) {

		this.reset();

		fourInputsTestForRACC();

		StringBuilder builder = new StringBuilder();

		while (true) {
			runTest(builder);
			this.racc = this.computeRACC(
					instrumentedNextDate.getOutputs(), builder.toString());

			if (this.racc >= coverage) {
				outputCoveredCode(this.activeClausesTested);
				break;
			}
		}
	}

	private void outputCoveredCode(Set<String> coveredCode) {
		List<String> branchList = new ArrayList<String>();
		branchList.addAll(coveredCode);
		Collections.sort(branchList);
		for (String branch : branchList) {
			System.out.println(branch);
		}
	}

	private void runTest(StringBuilder builder) {

		iterationNum++;

		int[] testData = new int[3];

		builder.setLength(0);

		generateTestData(builder, testData);

		instrumentedNextDate.nexDate(testData);
	}

	protected abstract void generateTestData(StringBuilder builder,
			int[] testData);

	private void fourInputsTestForBranchCoverage() {

		
	}

	private void fourInputsTestForRACC() {

		
	}

	private double computeBranchCoverage(List<String> instrumentingOutputs, String testData) {

		boolean isNewCoverage = false;
		for (String line : instrumentingOutputs) {
			if (line.contains("<trace>")) {
				if (!this.branchesTested.contains(line)) {
					this.branchesTested.add(line);
					isNewCoverage = true;
				}
			}
		}

		if (isNewCoverage) {
			System.out.println(testData);
		}

		return this.branchesTested.size() * 1.0 / BRANCH_NUM;
	}

	private double computeRACC(List<String> instrumentingOutputs,
			String testData) {

		boolean isNewCoverage = false;
		for (String line : instrumentingOutputs) {
			if (line.startsWith("<line id=")) {
				String header = line.substring(0, line.indexOf("#"));
				if (!this.activeClausesTested.contains(header)) {
					isNewCoverage = true;
					this.activeClausesTested.add(header);
				}
			} else if (line.startsWith("<trace>")) {

				if (!this.activeClausesTested.contains(line)) {
					isNewCoverage = true;
					this.activeClausesTested.add(line);
				}
			}
		}

		if (isNewCoverage) {
			System.out.println(testData);
		}

		return this.activeClausesTested.size() * 1.0 / CoverageTest.AC_BRANCH_NUM;
	}

	

}
