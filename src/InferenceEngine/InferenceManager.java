package InferenceEngine;

import java.util.ArrayList;
import java.util.List;

import Agent.Agent;
import Environment.Environment;

public class InferenceManager{

	// --- FIELDS ---
	
	private List<Facts> listOfFacts;
	private ListOfRules listOfRules;
	public List<Integer> goal;
	
	// --- CONSTRUCTOR ---
	
	public InferenceManager(Agent agent){

		int taille = agent.getBdi().getTaille();
		this.setListOfRules(new ListOfRules());
		this.listOfFacts = new ArrayList<Facts>();
		this.goal=new ArrayList<Integer>();
		for (int i = 0; i < taille; i++) {
			for (int j = 0; j < taille; j++) {
				this.listOfFacts.add( new Facts(false,false,false,false,false,false,false,false,false,j,i));
			}
		}
	}
	public void resetListofFacts(Agent agent) {
		int taille = agent.getBdi().getTaille();
		for (int i = 0; i < taille; i++) {
			for (int j = 0; j < taille; j++) {
				this.listOfFacts.add( new Facts(false,false,false,false,false,false,false,false,false,j,i));
			}
		}
	}

	// --- GETTERS ---
	
	public List<Facts> getListOfFacts(){
		return listOfFacts;
	}
	public ListOfRules getListOfRules() {
		return listOfRules;
	}


	// --- SETTERS ---
	
	public void setListOfFacts(List<Facts> listOfFacts){
		this.listOfFacts = listOfFacts;
	}
	public void setListOfRules(ListOfRules listOfRules) {
		this.listOfRules = listOfRules;
	}
	
	// ---METHODS ---
	
	// --- FILTER RULES TO GET THE RULES THAT CAN BE APPLIED ---
	
	public List<Rules> filterRules(){
		List <Rules> appliableRules=new ArrayList<Rules>();
		for (Rules rules : this.listOfRules.getListOfRules()) {
			// if rules is not marked 
			if (!rules.getApplied())
			{
				Boolean unrequired=true;
				for (int count=0; count<this.listOfFacts.size() ; count++) {
					Boolean allRespected=true;					
					for (Object[] condition : rules.getConditions()) {
						if(listOfFacts.get(count).getListOfBoolean().get((int) condition[0])!=(Boolean)condition[1]){
							allRespected=false;
						}
					}
					if (allRespected) {
						unrequired=false;
						// Add the position that will be tested by the rule
						int[] positions={listOfFacts.get(count).getPositionX(),listOfFacts.get(count).getPositionY()};
						rules.getPositionsBoxtoTest().add(positions);
					}
					
				}
				if (!unrequired) {
					appliableRules.add(rules);
				}
			}
		}
		return appliableRules;		
	}
	
	// --- QUICK-SORT OF A LIST<RULES> ORDERED BY PRIORITY
	// 	http://www.vogella.com/tutorials/JavaAlgorithmsQuicksort/article.html
	
    public void sort(List<Rules> rules) {
        // check for empty or null array
        if (rules ==null || rules.size()==0){
            return;
        }
        quicksort(rules,0, rules.size() - 1);
    }

    private void quicksort(List<Rules> rules,int low, int high) {
        int i = low, j = high;
        // Get the pivot element from the middle of the list
        Rules pivot =rules.get(low + (high-low)/2 );

        // Divide into two lists
        while (i <= j) {
            // If the current value from the left list is smaller than the pivot
            // element then get the next element from the left list
            while (rules.get(i).getPriority() < pivot.getPriority()) {
                i++;
            }
            // If the current value from the right list is larger than the pivot
            // element then get the next element from the right list
            while (rules.get(j).getPriority() > pivot.getPriority()) {
                j--;
            }

            // If we have found a value in the left list which is larger than
            // the pivot element and if we have found a value in the right list
            // which is smaller than the pivot element then we exchange the
            // values.
            // As we are done we can increase i and j
            if (i <= j) {
                exchange(rules,i, j);
                i++;
                j--;
            }
        }
        // Recursion
        if (low < j)
            quicksort(rules,low, j);
        if (i < high)
            quicksort(rules,i, high);
    }

    private void exchange(List<Rules> rules,int i, int j) {
        Rules temp = rules.get(i);
        rules.set(i,rules.get(j));
        rules.set(j,temp);
    }
    
    // --- FORWARD CHAINING ---
    
    public void forwardChaining(Agent agent ,Environment environment) {
    	if(goal.size()>0) {
        	goal.remove(0);
        	goal.remove(0);
    	}
    	while (goal.size()==0 && this.filterRules().size()!=0) {
    		List<Rules> appliableRules=this.filterRules() ;
    		this.sort(appliableRules);
    		System.out.println(appliableRules.get(0).getPriority());
    		appliableRules.get(0).setApplied(true);
    		this.execute(agent, appliableRules.get(0), environment);

    	}
    	
    }
    
    
	// --- METHOD TO EXECUTE RULES  ---

	public void execute(Agent agent, Rules rule, Environment environment) {
		Boolean actionExecuted = false;
		
		for (Object[] conclusion : rule.getConclusions()) {
			
			if (conclusion.length == 1) {
				actionExecuted = true;
				agent.getBdi().setIntentions((String)conclusion[0]);
				goal.add(rule.getPositionsBoxtoTest().get(0)[0]);
				goal.add(rule.getPositionsBoxtoTest().get(0)[1]);	
			} else {
				if (!actionExecuted) {
					for (int[] positions : rule.getPositionsBoxtoTest()) {
						
						// Boolean which indicate if the resulting Facts concerns the neighbouring Box
						// or the Box
						if ((Boolean) conclusion[3] == false) {
							int j = 0;
							while (j < listOfFacts.size() ) {
								if (listOfFacts.get(j).getPositionX() == positions[0]
										&& listOfFacts.get(j).getPositionY() == positions[1]) {
									listOfFacts.get(j).getListOfBoolean().set((int) conclusion[1],
											(Boolean) conclusion[2]);

								}
								j++;
							}
						}
						// Boolean which indicate if the resulting Facts concerns the neighbouring Box
						// or the Box
						if ((Boolean) conclusion[3] == true) {
							for (Facts facts : listOfFacts) {
								// No bound issue because the Facts are never assigned with out ouf bound values
								if (facts.getPositionX() == positions[0] - 1
										&& facts.getPositionY() == positions[1]) {
									facts.getListOfBoolean().set((int) conclusion[1],
											(Boolean) conclusion[2]);

								} else {
									if (facts.getPositionX() == positions[0] + 1
											&& facts.getPositionY() == positions[1]) {
										facts.getListOfBoolean().set((int) conclusion[1],
												(Boolean) conclusion[2]);

									} else {
										if (facts.getPositionX() == positions[0]
												&& facts.getPositionY() == positions[1] - 1) {
											facts.getListOfBoolean().set((int) conclusion[1],
													(Boolean) conclusion[2]);

										} else {
											if (facts.getPositionX() == positions[0] 
													&& facts.getPositionY() == positions[1] + 1) {
												facts.getListOfBoolean().set((int) conclusion[1],
														(Boolean) conclusion[2]);
											}
										}
									}
								}
							}

						}
					}
				} else {
					int j = 0;
					int[] firstBoxConcerned = rule.getPositionsBoxtoTest().get(0);
					// Boolean which indicate if the resulting Facts concerns the neighbouring Box
					// or the Box
					if ((Boolean) conclusion[3] == false) {
						while (j < listOfFacts.size() ) {
							if (listOfFacts.get(j).getPositionX() == firstBoxConcerned[0]
									&& listOfFacts.get(j).getPositionY() == firstBoxConcerned[1]) {
								listOfFacts.get(j).getListOfBoolean().set((int) conclusion[1], (Boolean) conclusion[2]);

							}
							j++;
						}
					}
					// Boolean which indicate if the resulting Facts concerns the neighbouring Box
					// or the Box
					if ((Boolean) conclusion[3] == true) {
						for (Facts facts : listOfFacts) {
							// No bound issue because the Facts are never assigned with out ouf bound values
							if (facts.getPositionX() == firstBoxConcerned[0] - 1
									&& facts.getPositionY() == firstBoxConcerned[1]) {
								facts.getListOfBoolean().set((int) conclusion[1],
										(Boolean) conclusion[2]);
							} else {
								if (facts.getPositionX() == firstBoxConcerned[0] + 1
										&& facts.getPositionY() == firstBoxConcerned[1]) {
									facts.getListOfBoolean().set((int) conclusion[1],
											(Boolean) conclusion[2]);
								} else {
									if (facts.getPositionX() == firstBoxConcerned[0]
											&& facts.getPositionY() == firstBoxConcerned[1] - 1) {
										facts.getListOfBoolean().set((int) conclusion[1],
												(Boolean) conclusion[2]);
									} else {
										if (facts.getPositionX() == firstBoxConcerned[0] 
												&& facts.getPositionY() == firstBoxConcerned[1] + 1) {
											facts.getListOfBoolean().set((int) conclusion[1],
													(Boolean) conclusion[2]);
										}
									}
								}
							}

						}

					}

				}
			}
		}

	}
}
