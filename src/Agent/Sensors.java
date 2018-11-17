package Agent;

import Environment.Box;
import Environment.Environment;

public class Sensors {

    public Sensors()
    {
    }

    public Box obserActualBox(Agent agent, Environment environment) {
		Box box = environment.getGrid().get(agent.getPositionY()*environment.getTaille()+agent.getPositionX()).clone();
		return box ;
    
    }
}
