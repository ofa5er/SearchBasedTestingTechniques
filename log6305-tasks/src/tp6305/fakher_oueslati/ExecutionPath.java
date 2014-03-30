package tp6305.fakher_oueslati;

import java.util.ArrayList;
import java.util.List;

import tp6305.fakher_oueslati.Condition.Operator;
import tp6305.fakher_oueslati.Condition.Side;




public class ExecutionPath {
	List<Condition> conditions=new ArrayList<Condition>();

	public ExecutionPath(List<Condition> conditions) {
		super();
		this.conditions = conditions;
	}
	public ExecutionPath() {
	
	}

	public List<Condition> getConditions() {
		return conditions;
	}

	public void setConditions(List<Condition> conditions) {
		this.conditions = conditions;
	} 
	
	public void addCondition(Side left,Operator equal, Side right, boolean result){
		this.conditions.add(new Condition(left, equal, right, result));
	}
	public String toString(){
		String result="";
		for (int i=0;i<this.conditions.size();i++)
		{
			result+=conditions.get(i).toString()+ "\n";
		}
		return result;
	}
	
	
}
