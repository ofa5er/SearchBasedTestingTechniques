package tp6305.fakher_oueslati;

import tp6305.fakher_oueslati.Condition.Operator;

public class FitnessFunction {
	private static int K=1;
	public static int compute(String a, String b, Operator operator, boolean flow) {
		int result=0;

			if (flow)
			{
				if (operator==Operator.LESS){
					if ((int)a.charAt(0)<(int)b.charAt(0))
						result=0;
					else
						result= (int)a.charAt(0)-(int)b.charAt(0)+K;
				}
			} else {
				if (operator==Operator.LESS){
					if ((int)a.charAt(0)>=(int)b.charAt(0))
						result= 0;
					else
						result= (int)b.charAt(0)-(int)a.charAt(0)+K;
				} 
			}


		return result;
	}

}

