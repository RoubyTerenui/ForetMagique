package InferenceEngine;

import java.util.ArrayList;
import java.util.List;

public class Facts {
	
	private int positionX;
	private int positionY;
	private List<Boolean> listOFBoolean;


	public Facts(Boolean F_riskless, Boolean F_visited, Boolean F_visitable, Boolean F_smell, Boolean F_wind, Boolean F_light, Boolean F_monster, Boolean F_riFt, Boolean F_deadly,int positionX,int positionY)
    {
    	this.listOFBoolean=new ArrayList<Boolean>();
        this.positionX=positionX;
    	this.positionY=positionY;
    	listOFBoolean.add(F_riskless);
    	listOFBoolean.add(F_visited);
    	listOFBoolean.add(F_visitable);
    	listOFBoolean.add(F_smell);
    	listOFBoolean.add(F_wind);
    	listOFBoolean.add(F_light);
    	listOFBoolean.add(F_monster);
    	listOFBoolean.add(F_riFt);
    	listOFBoolean.add(false);
    	listOFBoolean.add(F_deadly);
    }
	// ---- GETTERS ----

	public int getPositionX() {
		return positionX;
	}
	public int getPositionY() {
		return positionY;
	}
	public List<Boolean> getListOfBoolean() {
		return listOFBoolean;
	}
	
	// --- SETTERS ---

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}
	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}
	
	// UPDATE FACTS 
	
	public void updateFacts( Boolean F_smell, Boolean F_wind, Boolean F_light, Boolean F_monster, Boolean F_riFt) {
		listOFBoolean.set(7,F_smell);
		listOFBoolean.set(6,F_wind);
		listOFBoolean.set(5,F_light);
		listOFBoolean.set(4,F_monster);
		listOFBoolean.set(3,F_riFt);
	}
   
}
