package InferenceEngine;

import java.util.ArrayList;
import java.util.List;

import Agent.Agent;

public class ListOfRules {
	
	private List<Rules> listOfRules;
	
	public ListOfRules(){
		
		this.listOfRules = new ArrayList<Rules>();
		
		// If light then enter
		// Si il y a de la lumière sur la case au départ, alors on sort de la forêt
		
		List<Object[]> conditionRule1 = new ArrayList<Object[]>();
		Object[] cd1_1 = {5, true, false}; //{6ème fact, doit être true, appliqué sur la case}
		conditionRule1.add(cd1_1);
		
		List<Object[]> conclusionRule1 = new ArrayList<Object[]>();
		Object[] cc1_1 = {"Enter"}; //{action entrer}
		conclusionRule1.add(cc1_1);
		
		this.listOfRules.add(new Rules (1, conditionRule1, conclusionRule1));
		
		
		// If poo then around monster
		// Si il y a une crotte dans une case alors les cases autour (risquent d'avoir) ont des monstres
		
		List<Object[]> conditionRule8 = new ArrayList<Object[]>();
		Object[] cd8_1 = {3, true, false}; //{4ème fact, doit être true, appliqué sur la case}
		conditionRule8.add(cd8_1);
						
		List<Object[]> conclusionRule8 = new ArrayList<Object[]>();
		Object[] cc8_1 = {"", 6, true, true}; //{pas d'action, 7ème fact, passe true, appliqué sur les cases ajd}
		conclusionRule8.add(cc8_1);
						
		this.listOfRules.add(new Rules (2, conditionRule8, conclusionRule8));
		
		
		// If monster and visited then no monster
		// Si une case avec un monstre a déjà été visitée, c'est qu'il n'y a pas de monstre
		
		List<Object[]> conditionRule9 = new ArrayList<Object[]>();
		Object[] cd9_1 = {1, true, false}; //{2ème fact, doit être true, appliqué sur la case}
		Object[] cd9_2 = {6, true, false}; //{7ème fact, doit être true, appliqué sur la case}
		conditionRule9.add(cd9_1);
		conditionRule9.add(cd9_2);
						
		List<Object[]> conclusionRule9 = new ArrayList<Object[]>();
		Object[] cc9_1 = {"", 6, false, false}; //{pas d'action, 7ème fact, passe false, appliqué sur la case}
		conclusionRule9.add(cc9_1);
						
		this.listOfRules.add(new Rules (3, conditionRule9, conclusionRule9));
				
		
		// If wind then around rift
		// Si il y a du vent dans une case alors les cases autour (risquent d'avoir) ont des gouffres
		
		List<Object[]> conditionRule10 = new ArrayList<Object[]>();
		Object[] cd10_1 = {4, true, false}; //{5ème fact, doit être true, appliqué sur la case}
		conditionRule10.add(cd10_1);
						
		List<Object[]> conclusionRule10 = new ArrayList<Object[]>();
		Object[] cc10_1 = {"", 7, true, true}; //{pas d'action, 8ème fact, passe true, appliqué sur les cases ajd}
		conclusionRule10.add(cc10_1);
						
		this.listOfRules.add(new Rules (4, conditionRule10, conclusionRule10));
		
		
		// If Rift and visited and not deadly then no rift
		// Si il y a un gouffre dans une case non mortelle déjà visitée, c'est qu'il n'y a pas de gouffre
		
		List<Object[]> conditionRule11 = new ArrayList<Object[]>();
		Object[] cd11_1 = {1, true, false }; // {2ème fact, doit être true, appliqué sur la case}
		Object[] cd11_2 = {7, true, false }; // {8ème fact, doit être true, appliqué sur la case}
		Object[] cd11_3 = {9, false, false }; // {10ème fact, doit être false, appliqué sur la case}
		conditionRule11.add(cd11_1);
		conditionRule11.add(cd11_2);
		conditionRule11.add(cd11_3);

		List<Object[]> conclusionRule11 = new ArrayList<Object[]>();
		Object[] cc11_1 = { "", 6, false, false }; // {pas d'action, 7ème fact, passe false, appliqué sur la case}
		conclusionRule11.add(cc11_1);

		this.listOfRules.add(new Rules(5, conditionRule11, conclusionRule11));
		
		
		// If no poo then around no monster
		// Si il n'y a pas de caca dans une case alors les cases adjacentes sont sans monstre
				
		List<Object[]> conditionRule12 = new ArrayList<Object[]>();
		Object[] cd12_1 = {3, false, false}; //{4ème fact, doit être false, appliqué sur la case}
		conditionRule12.add(cd12_1);
				
		List<Object[]> conclusionRule12 = new ArrayList<Object[]>();
		Object[] cc12_1 = {"", 6, false, true}; //{pas d'action, 7ème fact, passe false, appliqué sur les cases ajd}
		conclusionRule12.add(cc12_1);
				
		this.listOfRules.add(new Rules (6, conditionRule12, conclusionRule12));
				
				
		// If no wind then around no rift
		// Si il n'y a pas de vent dans une case alors les cases adjacentes sont sans gouffre
				
		List<Object[]> conditionRule13 = new ArrayList<Object[]>();
		Object[] cd13_1 = {4, false, false}; //{5ème fact, doit être false, appliqué sur la case}
		conditionRule13.add(cd13_1);
				
		List<Object[]> conclusionRule13 = new ArrayList<Object[]>();
		Object[] cc13_1 = {"", 7, false, true}; //{pas d'action, 8ème fact, passe false, appliqué sur les cases ajd}
		conclusionRule13.add(cc13_1);
				
		this.listOfRules.add(new Rules (7, conditionRule13, conclusionRule13));
		
		
		// If no monster and no rift then no risk
		// Si il n'y a ni monstre ni gouffre dans une case, on la considère sans risque
		
		List<Object[]> conditionRule2 = new ArrayList<Object[]>();
		Object[] cd2_1 = {6, false, false}; //{7ème fact, doit être false, appliqué sur la case}
		Object[] cd2_2 = {7, false, false}; //{8ème fact, doit être false, appliqué sur la case}
		conditionRule2.add(cd2_1);
		conditionRule2.add(cd2_2);
		
		List<Object[]> conclusionRule2 = new ArrayList<Object[]>();
		Object[] cc2_1 = {"", 0, true, false}; //{pas d'action, 1er fact, passe true, appliqué sur la case}
		conclusionRule2.add(cc2_1);
		
		this.listOfRules.add(new Rules (8, conditionRule2, conclusionRule2));
		
		
		// If no poo and no wind then around no risk
		// Si il n'y a ni caca ni vent dans une case, alors les cases autour sont considérées sans risque
		
		List<Object[]> conditionRule7 = new ArrayList<Object[]>();
		Object[] cd7_1 = {3, false, false}; //{4ème fact, doit être false, appliqué sur la case}
		Object[] cd7_2 = {4, false, false}; //{5ème fact, doit être false, appliqué sur la case}
		conditionRule7.add(cd7_1);
		conditionRule7.add(cd7_2);
						
		List<Object[]> conclusionRule7 = new ArrayList<Object[]>();
		Object[] cc7_1 = {"", 0, true, true}; //{pas d'action, 1er fact, passe true, appliqué sur les cases ajd}
		conclusionRule7.add(cc7_1);
						
		this.listOfRules.add(new Rules (9, conditionRule7, conclusionRule7));
		
		
		// If visited and rift then deadly
		// Si une case a déjà été visitée et qu'on y a trouvé un gouffre, alors elle est mortelle
		
		List<Object[]> conditionRule3 = new ArrayList<Object[]>();
		Object[] cd3_1 = {1, true, false}; //{2ème fact, doit être true, appliqué sur la case}
		Object[] cd3_2 = {7, true, false}; //{8ème fact, doit être true, appliqué sur la case}
		conditionRule3.add(cd3_1);
		conditionRule3.add(cd3_2);
						
		List<Object[]> conclusionRule3 = new ArrayList<Object[]>();
		Object[] cc3_1 = {"", 9, true, false}; //{pas d'action, 10ème fact, passe true, appliqué sur la case }
		conclusionRule3.add(cc3_1);
						
		this.listOfRules.add(new Rules (10, conditionRule3, conclusionRule3));
		
		
		// If rift then around not visitable
		// Si il y a un gouffre dans une case, les cases alentours deviennent non visitables (temporairement pour certaines)
		
		List<Object[]> conditionRule4 = new ArrayList<Object[]>();
		Object[] cd4_1 = {7, true, true}; //{8ème fact, doit être true, appliqué sur les cases adj}
		conditionRule4.add(cd4_1);
				
		List<Object[]> conclusionRule4 = new ArrayList<Object[]>();
		Object[] cc4_1 = {"", 2, false, true}; //{pas d'action, 3ème fact, passe false, appliqué sur les cases ajd}
		conclusionRule4.add(cc4_1);
				
		this.listOfRules.add(new Rules (11, conditionRule4, conclusionRule4));
		
		
		// If visited and not deadly then around visitable
		// Si une case a déjà été visitée et n'est pas mortelle alors les cases autour sont visitables
		
		List<Object[]> conditionRule5 = new ArrayList<Object[]>();
		Object[] cd5_1 = {1, true, false}; //{2ème fact, doit être true, appliqué sur la case}
		Object[] cd5_2 = {9, false, false}; //{10ème fact, doit être false, appliqué sur la case}
		conditionRule5.add(cd5_1);
		conditionRule5.add(cd5_2);
				
		List<Object[]> conclusionRule5 = new ArrayList<Object[]>();
		Object[] cc5_1 = {"", 2, true, true}; //{pas d'action, 3ème fact, passe true, appliqué sur les cases ajd}
		conclusionRule5.add(cc5_1);
				
		this.listOfRules.add(new Rules (12, conditionRule5, conclusionRule5));
		
		
		// If visited and visitable then not visitable
		// Si une case est visitable mais qu'elle a déjà été visitée, elle n'est plus visitable
		
		List<Object[]> conditionRule6 = new ArrayList<Object[]>();
		Object[] cd6_1 = {1, true, false}; //{2ème fact, doit être true, appliqué sur la case}
		Object[] cd6_2 = {2, true, false}; //{3ème fact, doit être true, appliqué sur la case}
		conditionRule6.add(cd6_1);
		conditionRule6.add(cd6_2);
						
		List<Object[]> conclusionRule6 = new ArrayList<Object[]>();
		Object[] cc6_1 = {"", 2, false, false}; //{pas d'action, 3ème fact, passe false, appliqué sur la case}
		conclusionRule6.add(cc6_1);
						
		this.listOfRules.add(new Rules (13, conditionRule6, conclusionRule6));
		

	}

	

	public List<Rules> getListOfRules() {
		return listOfRules;
	}

	public void setListOfRules(List<Rules> listOfRules) {
		this.listOfRules = listOfRules;
	}
	
}
