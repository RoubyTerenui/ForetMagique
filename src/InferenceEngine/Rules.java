package InferenceEngine;

import java.util.List;

public class Rules {
	
	// --- FIELDS ---
	
	private int priority ;
	private List<Object[]> conditions;
	private List<Object[]> conclusions;
	
	// --- CONSTRUCTORS ---
	
	public Rules(int priority, List<Object[]> conditions, List<Object[]> conclusions) {
		super();
		this.priority = priority;
		this.conditions = conditions;
		this.conclusions = conclusions;
	}
	
	// --- GETTERS ---
	
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
	
}

