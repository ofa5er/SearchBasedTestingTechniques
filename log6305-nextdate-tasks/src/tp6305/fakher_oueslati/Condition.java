package tp6305.fakher_oueslati;

public class Condition {
	public enum Operator {EQUAL, LESS, GREATER}
	public enum Left {year,month,day,yearmod4,yearmod100,yearmod400}

	Operator operator;
	Left left;
	int right;
	boolean result;
	public Operator getOperator() {
		return operator;
	}
	public void setOperator(Operator operator) {
		this.operator = operator;
	}
	public Left getLeft() {
		return left;
	}
	public void setLeft(Left left) {
		this.left = left;
	}
	public int getRight() {
		return right;
	}
	public void setRight(int right) {
		this.right = right;
	}
	public boolean isResult() {
		return result;
	}
	public void setResult(boolean result) {
		this.result = result;
	}
	public Condition(Left left,Operator equal, int right, boolean result) {
		super();
		this.operator = equal;
		this.left = left;
		this.right = right;
		this.result = result;
	}
	public String toString(){
		return this.left.name()+this.operator.name()+this.right +this.result;
	}



}
