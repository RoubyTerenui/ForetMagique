package Agent;

import java.util.ArrayList;
import java.util.List;

import Environment.Box;

public class BDI {
	
    private int taille;
    private ArrayList<Box> belief;
    private String intentions;//String action 

    
	public BDI(int taille)
    {
        this.taille = taille;
        this.belief = new ArrayList<Box>();
        for (int i = 0; i < taille; i++) {
			for (int j = 0; j < taille; j++) {
				belief.add(new Box(false,false,false,false,false));
			}
		}
        this.intentions ="ne rien faire" ;

    }

    public ArrayList<Box>  getBelief(){
        return belief;
    }
    

    public void setBelief(ArrayList<Box>  b){
        this.belief = b;
    }

    public String getIntentions(){
        return intentions;
    }
    
    public void setIntentions(String intentions) {
		this.intentions = intentions;
	}



	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}
}
