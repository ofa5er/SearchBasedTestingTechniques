package tp6305.fakher_oueslati;

import java.util.ArrayList;
import java.util.List;

import tp6305.fakher_oueslati.Condition.Operator;
import tp6305.fakher_oueslati.Condition.Left;

public class ExePath {
	
	List<Condition> conditions=new ArrayList<Condition>();

	public ExePath(List<Condition> conditions) {
		super();
		this.conditions = conditions;
	}
	public ExePath() {
	
	}

	public List<Condition> getConditions() {
		return conditions;
	}

	public void setConditions(List<Condition> conditions) {
		this.conditions = conditions;
	} 
	
	public void addCondition(Left left,Operator equal, int right, boolean result){
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
