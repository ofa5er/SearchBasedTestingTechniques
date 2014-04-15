package tp6305.fakher_oueslati;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;



import tp6305.fakher_oueslati.Condition.Operator;

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
		int asciiMax=127;
		int asciiMin=32;
		testData[0]="";
		int randomAscii;
		for (int i=0;i<4;i++)
		{
			Random r = new Random();
			randomAscii=r.nextInt(asciiMax-asciiMin) + asciiMin;
			testData[0]+=Character.toString ((char) randomAscii);
		}

		int num = 0;
		char newChar;
		while (num != exePath.conditions.size()) {
			for (Condition condition : exePath.conditions) {
				String a = "";
				String b = "";
				if (condition.inputStr.equals("inputstring")) {
					a = testData[0];
				}
				b=condition.resultStr;

				int fit = FitnessFunction.compute(a, b, condition.operator,
						condition.result);
				
				if (fit== 0) {
					num++;
				} else {
					if (condition.getOperator()==Operator.LESS)
					{
							if (fit!=0)
							{
							if (condition.result==false)
							{
								newChar= (char) (testData[0].charAt(0) + fit);
								testData[0]=testData[0].substring(0,0)+newChar+testData[0].substring(1);
							}else
							{
								newChar= (char) (testData[0].charAt(0) - fit);
								testData[0]=testData[0].substring(0,0)+newChar+testData[0].substring(1);
							}
						}
					}
					num=0;
					this.iterationNum++;
					break;
				}
			}

		}
		builder.append(testData[0]).append(", ");
		cursor++;
	}

	@Override
	protected double computeBranchCoverage(List<String> outputs, String testData) {
		// TODO Auto-generated method stub
		return 0;
	}
	private void initBranches() {
		ExePath b1=new ExePath();
		b1.addCondition("inputstring",Operator.LESS,"R2d!",true);
		this.exePaths.add(b1);
	}
}
