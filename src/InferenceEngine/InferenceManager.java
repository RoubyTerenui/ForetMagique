package InferenceEngine;

import java.util.ArrayList;
import java.util.List;

import Agent.Agent;

public class InferenceManager{

	private List<Facts> listOfFacts;
	
	public InferenceManager(Agent agent){

		int taille = agent.getBdi().getTaille();
		this.listOfFacts = new ArrayList<Facts>();

		for (int i = 0; i < taille; i++) {
			for (int j = 0; j < taille; j++) {
				this.listOfFacts.set(i*taille+j, new Facts(false,false,false,false,false,false,false,false,false));
			}
		}
	}

	
	// --- GETTERS ---
	public List<Facts> getListOfFacts(){
		return listOfFacts;
	}

	// --- SETTERS ---
	public void setListOfFacts(List<Facts> listOfFacts){
		this.listOfFacts = listOfFacts;
	}
}
