package Agent;

import Environement.Box;
import Environement.Environement;

public class Effectors {

        public Effectors(){}

        public void MoveUP(Agent agent, Environement environment)
        {
            int positionY = agent.getPositionY();
            if ( positionY > 0)
            {
                positionY--;
            }
            agent.setPositionY(positionY);
        }
        public void MoveDown( Agent agent, Environement environment )
        {
            int positionY = agent.getPositionY();
            if (positionY < environment.getTaille())
            {
                positionY++;
            }
            agent.setPositionY(positionY);
        }
        public void MoveRight( Agent agent, Environement environment)
        {
            int positionX = agent.getPositionX();
            if (positionX < environment.getTaille())
            {
                positionX++;
            }
            agent.setPositionX(positionX);
        }
        public void MoveLeft( Agent agent, Environement environment)
        {
            int positionX = agent.getPositionX();
            if (positionX > 0)
            {
                positionX -= 1;
            }
            agent.setPositionX(positionX);
        }

        public void Tirer(Agent agent, Environement environment,int dirX,int dirY)//(-1 pour a gauche/1pour a droite/-1 pour haut /1 pour bas)
        {
        	if((dirX==0 && (dirY==1 || dirY==-1))||(dirY==0 && (dirX==1 || dirX==-1))) {
	            int nbr = agent.getNbrRockUsed();
	            nbr += 1;
	            agent.setNbrRockUsed(nbr);
	            if((agent.getPositionX()+dirX)>0 && (agent.getPositionX()+dirX)<environment.getTaille()) {
	            	if((agent.getPositionX()+dirX)>0 && (agent.getPositionX()+dirX)<environment.getTaille()) {
		            	Box temp=environment.getGrid().get((agent.getPositionY()+dirY)*environment.getTaille()+(agent.getPositionX()+dirX)).clone();
			            if (temp.getMonster()==true) {
			            	temp.setMonster(false);
			            	environment.getGrid().set((agent.getPositionY()+dirY)*environment.getTaille()+(agent.getPositionX()+dirX), temp);
			            }
	            	}
	            }
        	}
        }

        public void Sortir(Agent agent, Environement environment)
        {
            agent.setPositionX(0);
            agent.setPositionY(0);
            BDI resetBdi=new BDI(agent.getBdi().getTaille()+1);
            agent.setBdi(resetBdi);
            //Change l'environment
            environment.setTaille(agent.getBdi().getTaille()+1);
            environment.resetEnvironementGrid();
        }
}
