package Agent;

import Environement.Box;
import Environement.Environement;

public class Sensors {

    public Sensors()
    {
    }

    public Box obserActualBox(Agent agent, Environement environment) {
		Box box = environment.getGrid().get(agent.getPositionY()*environment.getTaille()+agent.getPositionX()).clone();
		return box ;
    
    }
}
