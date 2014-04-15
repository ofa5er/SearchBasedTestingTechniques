package tp6305.fakher_oueslati;

import tp6305.fakher_oueslati.Condition.Operator;

public class FitnessFunction {
	private static int K=1;
	public static int[] compute(String a, String b, Operator operator, boolean flow) {
		/* compute returns an array of 4 integer, each integer represent the distance between 
		 * a character the string a and a character from the string b (the distance is measured 
		 * using ASCII codes.
		 * Example: if a="abcd" and b="abde" the function should return [0,0,1,1]  */
		int[] result={0,0,0,0};
		for (int i=0;i<4;i++)
		{
			if (flow)
			{
				if (operator==Operator.EQUAL){
					if ((int)a.charAt(i)==(int)b.charAt(i))
						result[i]=0;
					else
						result[i]= (int)a.charAt(i)-(int)b.charAt(i);
				}
			} else {
				if (operator==Operator.EQUAL){
					if ((int)a.charAt(i)!=(int)b.charAt(i))
						result[i]= 0;
					else
						result[i]= K;
				} 
			}
		}

		return result;
	}

}

