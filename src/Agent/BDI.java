package Agent;

import com.sun.tools.doclint.Env;

public class BDI {
    private Environement belief;
    private String intentions;

    public BDI()
    {
        this.belief = null ;
        this.intentions = "Ne rien faire" ;

    }

    public Environement getBelief(){
        return belief;
    }

    public void setBelief(Environement b){
        this.belief = b;
    }

    public String getIntentions(){
        return intentions;
    }

    public void setBelief(String i){
        this.intentions = i;
    }
}
