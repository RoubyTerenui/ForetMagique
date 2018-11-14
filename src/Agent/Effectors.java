package Agent;

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

        public void Tirer(Agent agent, Environement environment)
        {
            int nbr = agent.getNbrRockUsed();
            nbr += 1;
            agent.setNbrRockUsed(nbr);
            //if (environment.getBox(i,j)==monster){ TODO
        }

        public void Sortir(Agent agent, Environement environment)
        {
            agent.setPositionX(0);
            agent.setPositionY(0);
            //Change la taille de la croyance réinitialiser l'état interne
            //Change l'environment
        }
}
