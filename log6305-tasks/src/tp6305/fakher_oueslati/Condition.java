package tp6305.fakher_oueslati;


public class Condition {
	public enum Operator {EQUAL, LESS, GREATER}
	public enum Side {side1,side2,side3,side12,side13,side23,sidezero} 
	/*sidezero represent that the side has the value of 0. It is used to test if the value is
	 * positive */
	Operator operator;
	Side left;
	Side right;
	boolean result;
	public Operator getOperator() {
		return operator;
	}
	public void setOperator(Operator operator) {
		this.operator = operator;
	}
	public Side getLeft() {
		return left;
	}
	public void setLeft(Side left) {
		this.left = left;
	}
	public Side getRight() {
		return right;
	}
	public void setRight(Side right) {
		this.right = right;
	}
	public boolean isResult() {
		return result;
	}
	public void setResult(boolean result) {
		this.result = result;
	}
	public Condition(Side left,Operator equal, Side right, boolean result) {
		super();
		this.operator = equal;
		this.left = left;
		this.right = right;
		this.result = result;
	}
	public String toString(){
		return this.left.name()+this.operator.name()+this.right.name() +this.result;
	}
	
	
	
	
}
