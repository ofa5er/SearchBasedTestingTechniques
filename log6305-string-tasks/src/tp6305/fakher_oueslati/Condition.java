package tp6305.fakher_oueslati;

public class Condition {
	
	public enum Operator {EQUAL, LESS, GREATER}


	Operator operator;
	String inputStr;
	String resultStr;
	boolean result;
	public Operator getOperator() {
		return operator;
	}
	public void setOperator(Operator operator) {
		this.operator = operator;
	}

	public boolean isResult() {
		return result;
	}
	public void setResult(boolean result) {
		this.result = result;
	}
	public Condition(String inputStr,Operator equal, String resultStr, boolean result) {
		super();
		this.operator = equal;
		this.inputStr = inputStr;
		this.resultStr = resultStr;
		this.result = result;
	}
	/*public String toString(){
		return this.left.name()+this.operator.name()+this.right +this.result;
	}*/



	
	

}
