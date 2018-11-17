package InferenceEngine;

import java.util.List;

public class Rules {
	
	// --- FIELDS ---
	
	private int priority ;
	private List<Facts> conditions;
	private List<Facts> conclusions;
	
	// --- CONSTRUCTORS ---
	
	public Rules(int priority, List<Facts> conditions, List<Facts> conclusions) {
		super();
		this.priority = priority;
		this.conditions = conditions;
		this.conclusions = conclusions;
	}
	
	// --- GETTERS ---
	
	public int getPriority() {
		return priority;
	}
	public List<Facts> getConclusions() {
		return conclusions;
	}	
	public List<Facts> getConditions() {
		return conditions;
	}
	
	// --- SETTERS ---
	
	public void setConditions(List<Facts> conditions) {
		this.conditions = conditions;
	}
	public void setConclusions(List<Facts> conclusions) {
		this.conclusions = conclusions;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
}

