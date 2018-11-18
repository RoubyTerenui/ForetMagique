package Agent;

import Environment.Box;
import Environment.Environment;

public class Effectors {

        public Effectors(){}

        public void act(int positionCible , String act,Agent agent,Environment environment) {
        	int posY=positionCible/agent.getBdi().getTaille();
        	int posX=positionCible%agent.getBdi().getTaille();
        	if (act=="move") {
        		move(agent,environment,posY,posX);
        	}
        	else {
        		if(act=="sortir") {
        			this.sortir(agent,environment);
        		}
        		else {
        			if(act=="tirer") {
        				this.tirer(agent, environment, agent.getPositionX()-posX, agent.getPositionX()-posY);
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

        public void tirer(Agent agent, Environment environment, int dirX, int dirY)//(-1 pour a gauche/1pour a droite/-1 pour haut /1 pour bas)
        {
        	if((dirX==0 && (dirY==1 || dirY==-1))||(dirY==0 && (dirX==1 || dirX==-1))) {
	            environment.setPerfMeasure(environment.getPerfMeasure()-10);
	            if((agent.getPositionX()+dirX)>0 && (agent.getPositionX()+dirX)<environment.getTaille()) {
	            	if((agent.getPositionX()+dirX)>0 && (agent.getPositionX()+dirX)<environment.getTaille()) {
		            	Box temp=environment.getGrid().get((agent.getPositionY()+dirY)*environment.getTaille()+(agent.getPositionX()+dirX)).clone();
		            	agent.getInferenceEngine().getListOfFacts().get((agent.getPositionY()+dirY)*environment.getTaille()+(agent.getPositionX()+dirX)).setF_shooted(true);
			            if (temp.getMonster()) {
			            	temp.setMonster(false);
			            	environment.getGrid().set((agent.getPositionY()+dirY)*environment.getTaille()+(agent.getPositionX()+dirX), temp);
			            }
	            	}
	            }
        	}
        }

        public void sortir(Agent agent, Environment environment)
        {
            agent.setPositionX(0);
            agent.setPositionY(0);
            BDI resetBdi=new BDI(agent.getBdi().getTaille()+1);
            agent.setBdi(resetBdi);
            //Change l'environment
            environment.setTaille(environment.getTaille()+1);
            environment.resetEnvironmentGrid();
            
            environment.setPerfMeasure(environment.getPerfMeasure()+10 * environment.getTaille());
        }
}
