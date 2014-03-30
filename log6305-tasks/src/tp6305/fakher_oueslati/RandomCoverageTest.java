package tp6305.fakher_oueslati;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import tp6305.CoverageTest;

public class RandomCoverageTest extends CoverageTest {
	
	protected void generateTestData(StringBuilder builder, float[] testData) {
		randmonData(builder, testData);
	}

	protected void randmonData(StringBuilder builder, float[] testData) {
		//TODO: 
		int min = -10;
		int max = 100;
		Random r = new Random();
		for (int i=0;i<3;i++)
		{
			testData[i]=r.nextInt(max-min) + min;
			builder.append(testData[i]).append(", ");
		}
		//Generate random numbers to each elements in testData, 
		//then put them in the StringBuilder as:		
		//builder.append(testData[i]).append(", ");	
	}
	
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
		return 0;
	}
	
}
