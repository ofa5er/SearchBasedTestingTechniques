package tp6305.your_name;

public class FitnessFunction {
	
	public static int compute(String a, String b, int operator, boolean flow){
		
		// TODO 
		if(operator == 0){
			if(flow){
				if(a.equals(b)){
					return 0;
				}else{
					return 9;
				}
			} 
		}
		return 0;
	}

}
