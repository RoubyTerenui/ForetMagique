package InferenceEngine;

import java.util.ArrayList;
import java.util.List;

import Agent.Agent;

public class ListOfRules {
	
	private List<Rules> listOfRules;
	
	public ListOfRules(){
		
		this.listOfRules = new ArrayList<Rules>();
		
		// If light then enter
		
		List<Object[]> conditionRule1 = new ArrayList<Object[]>();
		Object[] cd1_1 = {5, true, false}; //{6ème fact, doit être true, appliqué sur la case}
		conditionRule1.add(cd1_1);
		
		List<Object[]> conclusionRule1 = new ArrayList<Object[]>();
		Object[] cc1_1 = {"Enter"}; //{action entrer}
		conclusionRule1.add(cc1_1);
		
		this.listOfRules.add(new Rules (1, conditionRule1, conclusionRule1));
		
		
		// If no monster and no rift then no risk
		
		List<Object[]> conditionRule2 = new ArrayList<Object[]>();
		Object[] cd2_1 = {6, false, false}; //{7ème fact, doit être false, appliqué sur la case}
		Object[] cd2_2 = {7, false, false}; //{8ème fact, doit être false, appliqué sur la case}
		conditionRule2.add(cd2_1);
		conditionRule2.add(cd2_2);
		
		List<Object[]> conclusionRule2 = new ArrayList<Object[]>();
		Object[] cc2_1 = {"", 0, true, false}; //{pas d'action, 1ère fact, passe true, appliqué sur la case}
		conclusionRule2.add(cc2_1);
		
		this.listOfRules.add(new Rules (2, conditionRule2, conclusionRule2));
		
		
		// If visited and rift then deadly
		
		List<Object[]> conditionRule3 = new ArrayList<Object[]>();
		Object[] cd3_1 = {1, true, false}; //{2ème fact, doit être true, appliqué sur la case}
		Object[] cd3_2 = {7, true, false}; //{8ème fact, doit être true, appliqué sur la case}
		conditionRule3.add(cd3_1);
		conditionRule3.add(cd3_2);
						
		List<Object[]> conclusionRule3 = new ArrayList<Object[]>();
		Object[] cc3_1 = {"", 9, true, false}; //{pas d'action, 10ème fact, passe true, appliqué sur la case }
		conclusionRule3.add(cc3_1);
						
		this.listOfRules.add(new Rules (3, conditionRule3, conclusionRule3));
		
		
		// If rift then around not visitable
		
		List<Object[]> conditionRule4 = new ArrayList<Object[]>();
		Object[] cd4_1 = {7, true, true}; //{8ème fact, doit être true, appliqué sur les cases adj}
		conditionRule4.add(cd4_1);
				
		List<Object[]> conclusionRule4 = new ArrayList<Object[]>();
		Object[] cc4_1 = {"", 2, false, true}; //{pas d'action, 3ème fact, passe false, appliqué sur les cases ajd}
		conclusionRule4.add(cc4_1);
				
		this.listOfRules.add(new Rules (4, conditionRule4, conclusionRule4));
		
		//
		
	}

	

	public List<Rules> getListOfRules() {
		return listOfRules;
	}

	public void setListOfRules(List<Rules> listOfRules) {
		this.listOfRules = listOfRules;
	}
	
}
