package tp6305.fakher_oueslati;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import tp6305.fakher_oueslati.Condition.Left;
import tp6305.fakher_oueslati.Condition.Operator;


public class SearchBasedCoverageTest extends RandomCoverageTest {

	List<ExePath> exePaths = new ArrayList<ExePath>();	
	int cursor;

	public SearchBasedCoverageTest() {
		this.initBranches();
	}
	public void reset() {
		cursor=0;
	}
	
	@Override
	protected void generateTestData(StringBuilder builder, int[] testData) {

		// TODO generate the initial test data randomly.
		ExePath exePath = this.exePaths.get(cursor);

		Random r = new Random();
		testData[0]=r.nextInt(50-0) + 0;
		testData[1]=r.nextInt(30-0) + 0;
		testData[2]=r.nextInt(3000-2000) + 2000;

		int num = 0;

		while (num != exePath.conditions.size()) {
			for (Condition condition : exePath.conditions) {
				int a = 0;
				int b = 0;
				int aIndex=2;
				if (condition.left == Left.year) {
					a = testData[2];
				}else if (condition.left == Left.month) {
					a = testData[1];
					aIndex=1;
				}else if (condition.left == Left.yearmod100) {
					a = testData[2]%100;
				}else if (condition.left == Left.yearmod4) {
					a = testData[2]%4;
				}else if (condition.left == Left.yearmod400) {
					a = testData[2]%400;
				}else if (condition.left == Left.day) {
					a = testData[0];
					aIndex=0;
				}
				
				b=condition.right;

				int fit = FitnessFunction.compute(a, b, condition.operator,
						condition.result);
				if (fit == 0) {
					num++;
				} else {
					if (condition.getOperator()==Operator.GREATER)
						if (condition.result==false)
							testData[aIndex]-=fit;
						else
							testData[aIndex]+=fit;
					else if (condition.getOperator()==Operator.LESS)
						if (condition.result==false)
							testData[aIndex]-=fit;
						else
							testData[aIndex]+=fit;
					else if (condition.getOperator()==Operator.EQUAL)
						if (condition.result==false)
							if (fit >0)
								testData[aIndex]-=fit;
							else
								testData[aIndex]+=fit;
						else
							if (fit >0)
								testData[aIndex]-=fit;
							else
								testData[aIndex]+=fit;
					num=0;
					this.iterationNum++;
					break;
				}
			}
		}
		for (int j=0;j<3;j++)
		{
			builder.append(testData[j]).append(", ");
		}
		System.out.println(exePath.toString());
		cursor++;

	}

	private void initBranches() {
		ExePath b1=new ExePath();

		b1.addCondition(Left.year,Operator.GREATER,2999,false);
		b1.addCondition(Left.year,Operator.LESS,2000,false);
		b1.addCondition(Left.month,Operator.EQUAL,2,true);
		b1.addCondition(Left.yearmod100,Operator.EQUAL,0,false);
		b1.addCondition(Left.yearmod4,Operator.EQUAL,0,true);
		b1.addCondition(Left.day,Operator.LESS,1,false);
		b1.addCondition(Left.day,Operator.GREATER,29,false);
		this.exePaths.add(b1);


		b1=new ExePath();
		b1.addCondition(Left.year,Operator.GREATER,2999,false);
		b1.addCondition(Left.year,Operator.LESS,2000,false);
		b1.addCondition(Left.month,Operator.EQUAL,2,true);
		b1.addCondition(Left.yearmod100,Operator.EQUAL,0,true);
		b1.addCondition(Left.yearmod400,Operator.EQUAL,0,false);
		b1.addCondition(Left.day,Operator.LESS,1,false);
		b1.addCondition(Left.day,Operator.GREATER,28,false);
		this.exePaths.add(b1);
	}
}
