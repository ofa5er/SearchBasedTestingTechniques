package tp6305.fakher_oueslati;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import tp6305.CoverageTest;
import tp6305.fakher_oueslati.Condition.Operator;
import tp6305.fakher_oueslati.Condition.Side;
import triangle.triangle;

public class SearchBasedTestData extends CoverageTest {

	List<ExecutionPath> executionPaths = new ArrayList<ExecutionPath>();
	/*The value of the side are between -1 and 100*/
	int min=-1;
	int max=100;
	
	private int  cursor;
	
	public void reset() {
		cursor=0;
		this.iterationNum=0;
	}


	public SearchBasedTestData(){
		cursor=0;
		this.iterationNum=0;
		this.initBranches();
	}


	@Override
	protected void generateTestData(StringBuilder builder, float[] testData) {
		FitnessFunction ff=new FitnessFunction();
		Operator operator;
		Side left;
		Side right;
		Random r = new Random();
		for (int i=0;i<3;i++)
		{
			testData[i]=r.nextInt(max-min) + min;
		}
		ExecutionPath executionPath=this.executionPaths.get(cursor);
		int num=0;

		while (num != executionPath.conditions.size()){

			for (Condition condition: executionPath.getConditions()){
				float a=0;
				float b=0;
				int aIndex=-1;
				int bIndex=-1;
				/*This condition is used to avoid wasting time in finding values that are
				 * not included in the interval [min,max]. 
				 */
				if ((testData[1]>max) || (testData[1]<min)  ||
						(testData[2]>max) || (testData[2]<min)  ||
						(testData[0]>max) || (testData[0]<min))
						{
							num=0;
							this.iterationNum++;
							for (int i=0;i<3;i++)
							{
								testData[i]=r.nextInt(max-min) + min;
							}
							break;
			
						}
				if (condition.getLeft()==Side.side1){
					a=testData[0]; aIndex=0;}
				else if (condition.getLeft()==Side.side2){
					a=testData[1];aIndex=1;}
				else if (condition.getLeft()==Side.side3){
					a=testData[2];aIndex=2;}

				if (condition.getLeft()==Side.side12){
					a=testData[0]+testData[1]; aIndex=2;}
				else if (condition.getLeft()==Side.side13){
					a=testData[0]+testData[2];aIndex=1;}
				else if (condition.getLeft()==Side.side23){
					a=testData[1]+testData[2];aIndex=0;}
				else if (condition.getLeft()==Side.sidezero){
					a=0;aIndex=0;}	

				if (condition.getRight()==Side.side1){
					b=testData[0];bIndex=0;}
				else if (condition.getRight()==Side.side2){
					b=testData[1];bIndex=1;}
				else if (condition.getRight()==Side.side3){
					b=testData[2];bIndex=2;}

				float fit = FitnessFunction.compute(a, b, condition.getOperator(), condition.result);
				if (fit==0){
					num++;

				} else {
					if (condition.getOperator()==Operator.GREATER)
						if (condition.result==false)
							testData[bIndex]+=fit;
						else
							testData[bIndex]-=fit;
					else if (condition.getOperator()==Operator.LESS)
						if (condition.result==false)
							testData[bIndex]-=fit;
						else
							testData[bIndex]+=fit;
					else if (condition.getOperator()==Operator.EQUAL)
						if (condition.result==false)
							if (fit >0)
								testData[bIndex]-=fit;
							else
								testData[bIndex]+=fit;
						else
							if (fit >0)
								testData[bIndex]+=fit;
							else
								testData[bIndex]-=fit;

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
		cursor++;
	}

	@Override
	protected double computeBranchCoverage(List<String> instrumentingOutputs, String testData) {

		//TODO: 
		// Compute it accumulatively.
		// Only system.out.println(testData) when they contribute to increase the coverage.
		boolean added=false;
		int size;
		for (int i=0;i<instrumentingOutputs.size();i++)
		{
			if (instrumentingOutputs.get(i).startsWith("<trace>"))
			{
				size=branchesTested.size();
				branchesTested.add(instrumentingOutputs.get(i));
				if (branchesTested.size()>size)
				{
					added=true;
				}
			}
		}
		if (added)
		{
			System.out.println("TestData= " + testData);
		}

		return branchesTested.size()/19.0;
	}

	@Override
	protected double computeRACC(List<String> outputs, String testData) {
		// TODO Auto-generated method stub
		return 0;
	}

	private void initBranches() {
		// TODO Auto-generated method stub
		ExecutionPath b1=new ExecutionPath();
		/*This execution path is used to test negative values. We don't need to perform 
		 * this for every side */
		b1.addCondition(Side.sidezero,Operator.GREATER,Side.side1,true);
		this.executionPaths.add(b1);
		b1=new ExecutionPath();
		b1.addCondition(Side.sidezero,Operator.GREATER,Side.side1,false);
		b1.addCondition(Side.sidezero,Operator.GREATER,Side.side2,false);
		b1.addCondition(Side.sidezero,Operator.GREATER,Side.side3,false);
		b1.addCondition(Side.side1,Operator.EQUAL,Side.side2,false);
		b1.addCondition(Side.side2,Operator.EQUAL,Side.side3,false);
		b1.addCondition(Side.side1,Operator.EQUAL,Side.side3,false);
		b1.addCondition(Side.side12, Operator.LESS, Side.side3, false);
		b1.addCondition(Side.side23, Operator.LESS, Side.side1, false);
		b1.addCondition(Side.side13, Operator.LESS, Side.side2, false);
		this.executionPaths.add(b1);
		b1=new ExecutionPath();
		b1.addCondition(Side.sidezero,Operator.GREATER,Side.side1,false);
		b1.addCondition(Side.sidezero,Operator.GREATER,Side.side2,false);
		b1.addCondition(Side.sidezero,Operator.GREATER,Side.side3,false);
		b1.addCondition(Side.side1,Operator.EQUAL,Side.side2,false);
		b1.addCondition(Side.side2,Operator.EQUAL,Side.side3,false);
		b1.addCondition(Side.side1,Operator.EQUAL,Side.side3,false);
		b1.addCondition(Side.side12, Operator.LESS, Side.side3, true);
		this.executionPaths.add(b1);
		
	/*	I think that the following 2 executionPath that I have included in the last
	 * version are not really needed. Thus, I commented them here. They represent the
	 *  same branch as the previous one since the condition is 
	 *  side1 + side2 < side3 || side2 + side3 < side1 || side1 + side3 < side2
	 *  
	 * b1=new ExecutionPath();
		b1.addCondition(Side.sidezero,Operator.GREATER,Side.side1,false);
		b1.addCondition(Side.sidezero,Operator.GREATER,Side.side2,false);
		b1.addCondition(Side.sidezero,Operator.GREATER,Side.side3,false);
		b1.addCondition(Side.side1,Operator.EQUAL,Side.side2,false);
		b1.addCondition(Side.side2,Operator.EQUAL,Side.side3,false);
		b1.addCondition(Side.side1,Operator.EQUAL,Side.side3,false);
		b1.addCondition(Side.side23, Operator.LESS, Side.side1, true);
		this.executionPaths.add(b1);
		b1=new ExecutionPath();
		b1.addCondition(Side.sidezero,Operator.GREATER,Side.side1,false);
		b1.addCondition(Side.sidezero,Operator.GREATER,Side.side2,false);
		b1.addCondition(Side.sidezero,Operator.GREATER,Side.side3,false);
		b1.addCondition(Side.side1,Operator.EQUAL,Side.side2,false);
		b1.addCondition(Side.side2,Operator.EQUAL,Side.side3,false);
		b1.addCondition(Side.side1,Operator.EQUAL,Side.side3,false);
		b1.addCondition(Side.side13, Operator.LESS, Side.side2, true);
		this.executionPaths.add(b1);*/
		b1=new ExecutionPath();
		b1.addCondition(Side.sidezero,Operator.GREATER,Side.side1,false);
		b1.addCondition(Side.sidezero,Operator.GREATER,Side.side2,false);
		b1.addCondition(Side.sidezero,Operator.GREATER,Side.side3,false);
		b1.addCondition(Side.side1,Operator.EQUAL,Side.side2,true);
		b1.addCondition(Side.side2,Operator.EQUAL,Side.side3,true);
		b1.addCondition(Side.side1,Operator.EQUAL,Side.side3,true);
		this.executionPaths.add(b1);
		b1=new ExecutionPath();
		b1.addCondition(Side.sidezero,Operator.GREATER,Side.side1,false);
		b1.addCondition(Side.sidezero,Operator.GREATER,Side.side2,false);
		b1.addCondition(Side.sidezero,Operator.GREATER,Side.side3,false);
		b1.addCondition(Side.side1,Operator.EQUAL,Side.side2,true);
		b1.addCondition(Side.side2,Operator.EQUAL,Side.side3,false);
		b1.addCondition(Side.side1,Operator.EQUAL,Side.side3,false);
		b1.addCondition(Side.side12, Operator.GREATER, Side.side3, true);
		this.executionPaths.add(b1);
		b1=new ExecutionPath();
		b1.addCondition(Side.sidezero,Operator.GREATER,Side.side1,false);
		b1.addCondition(Side.sidezero,Operator.GREATER,Side.side2,false);
		b1.addCondition(Side.sidezero,Operator.GREATER,Side.side3,false);
		b1.addCondition(Side.side1,Operator.EQUAL,Side.side2,false);
		b1.addCondition(Side.side2,Operator.EQUAL,Side.side3,true);
		b1.addCondition(Side.side1,Operator.EQUAL,Side.side3,false);
		b1.addCondition(Side.side23, Operator.GREATER, Side.side1, true);	
		this.executionPaths.add(b1);
		b1=new ExecutionPath();
		b1.addCondition(Side.sidezero,Operator.GREATER,Side.side1,false);
		b1.addCondition(Side.sidezero,Operator.GREATER,Side.side2,false);
		b1.addCondition(Side.sidezero,Operator.GREATER,Side.side3,false);
		b1.addCondition(Side.side1,Operator.EQUAL,Side.side2,false);
		b1.addCondition(Side.side2,Operator.EQUAL,Side.side3,false);
		b1.addCondition(Side.side1,Operator.EQUAL,Side.side3,true);
		b1.addCondition(Side.side13, Operator.GREATER, Side.side2, true);	
		this.executionPaths.add(b1);
		b1=new ExecutionPath();
		b1.addCondition(Side.sidezero,Operator.GREATER,Side.side1,false);
		b1.addCondition(Side.sidezero,Operator.GREATER,Side.side2,false);
		b1.addCondition(Side.sidezero,Operator.GREATER,Side.side3,false);
		b1.addCondition(Side.side1,Operator.EQUAL,Side.side2,false);
		b1.addCondition(Side.side2,Operator.EQUAL,Side.side3,false);
		b1.addCondition(Side.side1,Operator.EQUAL,Side.side3,true);
		b1.addCondition(Side.side13, Operator.GREATER, Side.side2, false);
		this.executionPaths.add(b1);
	}
}
