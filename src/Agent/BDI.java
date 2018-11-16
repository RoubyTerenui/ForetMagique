package Agent;

import java.util.ArrayList;
import Environement.Box;
import InferenceEngine.Facts;

public class BDI {
    private int taille;
    private ArrayList<Box> belief;
    private ArrayList<Facts> facts;
    private String intentions;

    public BDI()
    {
        this.taille = 3;
        this.belief = new ArrayList<Box>();
        this.facts = new ArrayList<Facts>();
        this.intentions = "Ne rien faire" ;

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

    public void setBelief(String i){
        this.intentions = i;
    }
}
