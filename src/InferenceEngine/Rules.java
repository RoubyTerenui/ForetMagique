package InferenceEngine;

import java.util.ArrayList;
import java.util.List;

import Agent.Agent;

public class Rules {
	
	// --- FIELDS ---
	
	private int priority ;
	private Boolean applied;
	private List<Object[]> conditions;
	private List<int[]> positionsBoxtoTest;
	private List<Object[]> conclusions;
	
	// --- CONSTRUCTORS ---
	
	public Rules(int priority, List<Object[]> conditions, List<Object[]> conclusions) {
		super();
		this.positionsBoxtoTest=new ArrayList<int[]>();
		this.applied=false;
		this.priority = priority;
		this.conditions = conditions;
		this.conclusions = conclusions;
	}
	
	// --- GETTERS ---
	
	public List<int[]> getPositionsBoxtoTest() {
		return positionsBoxtoTest;
	}
	public Boolean getApplied() {
		return applied;
	}
	public int getPriority() {
		return priority;
	}
	public List<Object[]> getConclusions() {
		return conclusions;
	}
	public List<Object[]> getConditions() {
		return conditions;
	}
	
	// --- SETTERS ---
	
	public void setConditions(List<Object[]> conditions) {
		this.conditions = conditions;
	}
	public void setConclusions(List<Object[]> conclusions) {
		this.conclusions = conclusions;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public void setApplied(Boolean applied) {
		this.applied = applied;
	}
	public void setPositionsBoxtoTest(List<int[]> positionsBoxtoTest) {
		this.positionsBoxtoTest = positionsBoxtoTest;
	}

}

