package Agent;

public class Agent {

    public Agent(BDI bdi, int positionY, int positionX, int nbrRockUsed, Sensors s) {
        this.bdi = bdi;
        this.positionY = positionY;
        this.positionX = positionX;
        this.nbrRockUsed = nbrRockUsed;
        this.s = s;
    }

    private BDI bdi;
    private int positionY;
    private int positionX;
    private int nbrRockUsed;
    private Sensors sensor;

    public void observe() {
        this.sensor.
    }

    public BDI getBdi(){
        return bdi;
    }

    public void setBelief(BDI b){
        this.bdi = b;
    }

    public int getPositionY(){
        return positionY;
    }

    public void setPositionY(int pY){
        this.positionY = pY;
    }

    public int getPositionX(){
        return positionX;
    }

    public void setPositionX(int pX){
        this.positionX = pX;
    }

    public int getNbrRockUsed(){
        return nbrRockUsed;
    }

    public void setNbrRockUsed(int n){
        this.nbrRockUsed = n;
    }
}
