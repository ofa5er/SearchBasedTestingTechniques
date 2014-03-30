package string;

// This is mutant program.
// Author : ysma

import java.util.*;

public class InstrumentedStrigMatch {

	
	private List<String> outputs = new ArrayList<String>();

	public List<String> getOutputs() {
		return outputs;
	}
	
	private void addToOutputs(String Str) {
		outputs.add(Str);		
	}

	public static void main(java.lang.String[] args) {
		
		StringMatch stringMatch = new StringMatch();        
        stringMatch.method( args[0] );
	}
	
	public void method(String str) {
		if ("R2d!".equals(str)) {
			addToOutputs("<trace>1</trace>");
			System.out.println("Got it!");
		}else{
			System.out.println("It's something else.");
		}
	}
}
