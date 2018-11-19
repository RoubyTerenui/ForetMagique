package Agent;

import Environment.Box;
import Environment.Environment;

public class Effectors {

        public Effectors(){}

        public void act(int positionCible , String act,Agent agent,Environment environment) {
        int posX=positionCible%agent.getBdi().getTaille();
        int posY=positionCible/agent.getBdi().getTaille();
		if (act == "Move") {
			move(agent, environment, posY, posX);
		} else {
			if (act == "Enter") {
				this.sortir(agent, environment);
			} else {
				if (act == "Shoot") {
					this.tirer(agent, environment, agent.getPositionX(), agent.getPositionY());
					this.move(agent, environment, posY, posX);
				}
			}
		}
        	
        	
        }
        
        public void move(Agent agent, Environment environment ,int posCibleY, int posCibleX)
        {
            if ( posCibleY >= 0 && posCibleY < environment.getTaille())
            {            	
            	 if ( posCibleX >= 0 && posCibleX < environment.getTaille()) {
            		 int numberDeplac=Math.abs(agent.getPositionX()-posCibleX)+Math.abs(agent.getPositionX()-posCibleY);
            		 environment.setPerfMeasure(environment.getPerfMeasure()-numberDeplac);
            		 agent.setPositionY(posCibleY);
            		 agent.setPositionX(posCibleX);
            	 }            	
            }
            
        }
        public void moveUP(Agent agent, Environment environment)
        {
            int positionY = agent.getPositionY();
            if ( positionY > 0)
            {
                positionY--;
            }
            environment.setPerfMeasure(environment.getPerfMeasure()-1);
            agent.setPositionY(positionY);
        }
        public void moveDown( Agent agent, Environment environment )
        {
            int positionY = agent.getPositionY();
            if (positionY < environment.getTaille()-1)
            {
                positionY++;
            }
            environment.setPerfMeasure(environment.getPerfMeasure()-1);
            agent.setPositionY(positionY);
        }
        public void moveRight( Agent agent, Environment environment)
        {
            int positionX = agent.getPositionX();
            if (positionX < environment.getTaille()-1)
            {
                positionX++;
            }
            environment.setPerfMeasure(environment.getPerfMeasure()-1);
            agent.setPositionX(positionX);
        }
        public void moveLeft( Agent agent, Environment environment)
        {
            int positionX = agent.getPositionX();
            if (positionX > 0)
            {
                positionX -= 1;
            }
            environment.setPerfMeasure(environment.getPerfMeasure()-1);
            agent.setPositionX(positionX);
        }

        public void tirer(Agent agent, Environment environment,int posX,int posY)//(-1 pour a gauche/1pour a droite/-1 pour haut /1 pour bas)
        {
        	environment.setPerfMeasure(environment.getPerfMeasure()-10);
        	int numberDeplac=Math.abs(agent.getPositionX()-posX)+Math.abs(agent.getPositionX()-posY);
   		 	environment.setPerfMeasure(environment.getPerfMeasure()-numberDeplac);
        	 if ( posY >= 0 && posY < environment.getTaille())
             {            	
             	if ( posX >= 0 && posX < environment.getTaille()) {
             	System.out.println("posX"+":"+posX);
             	System.out.println("posY"+":"+posY);
	        	Box temp=environment.getGrid().get((posY)*environment.getTaille()+posX).clone();
	        	System.out.println(temp.getMonster());
			        if (temp.getMonster()) {
		            	temp.setMonster(false);
		            	environment.getGrid().set(posY*environment.getTaille()+posX, temp);
		            }
             	}
             }
        }

        public void sortir(Agent agent, Environment environment)
        {
        	//Change l'environment
            environment.setTaille(environment.getTaille()+1);
            environment.resetEnvironmentGrid();
            agent.setPositionX(0);
            agent.setPositionY(0);
            BDI resetBdi=new BDI(agent.getBdi().getTaille()+1);
            agent.setBdi(resetBdi);
            agent.getInferenceEngine().getListOfFacts().clear();
            agent.getInferenceEngine().resetListofFacts(agent);
            agent.updateInternState(environment);

            
            environment.setPerfMeasure(environment.getPerfMeasure()+10 * environment.getTaille());
        }
}
