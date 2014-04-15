package tp6305.fakher_oueslati;

import java.util.ArrayList;
import java.util.List;

import tp6305.fakher_oueslati.Condition.Operator;

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
	
	public void addCondition(String inputStr,Operator equal, String resultStr, boolean result){
		this.conditions.add(new Condition(inputStr, equal, resultStr, result));
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
