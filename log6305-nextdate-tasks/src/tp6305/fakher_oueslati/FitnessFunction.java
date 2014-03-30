package tp6305.fakher_oueslati;

import tp6305.fakher_oueslati.Condition.Operator;

public class FitnessFunction {
	private static int K=1;
	public static int compute(int a, int b, Operator operator, boolean flow) {

		//TODO
		if (flow)
		{
			if (operator==Operator.EQUAL){
				if (a==b)
					return 0;
				else
					return a-b;
			} else if (operator==Operator.GREATER){
				if (a>b)
					return 0;
				else
					return b-a+K;
			} else if (operator==Operator.LESS){
				if (a<b)
					return 0;
				else
					return a-b+K;
			}
		} else {
			if (operator==Operator.EQUAL){
				if (a!=b)
					return 0;
				else
					return K;
			} else if (operator==Operator.GREATER){
				if (a<=b)
					return 0;
				else
					return a-b+K;
			} else if (operator==Operator.LESS){
				if (a>=b)
					return 0;
				else
					return b-a+K;
			}
		}

		return 0;
	}

}
