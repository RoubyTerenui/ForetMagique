package Agent;

import Environment.Box;
import Environment.Environment;
import InferenceEngine.Facts;
import InferenceEngine.InferenceManager;

public class Agent {

    
    private BDI bdi;
    private int positionY;
    private int positionX;
    private Sensors sensor;
    private Effectors effectors;
	private InferenceManager inferenceEngine;

    
    public Agent(int positionY, int positionX) {
        this.bdi = new BDI(3);
        this.positionY = positionY;
        this.positionX = positionX;
        this.sensor = new Sensors();
        this.effectors = new Effectors();
        this.inferenceEngine=new InferenceManager(this);
    }

    public void updateInternState(Environment environment) {
        Box observedBox = this.sensor.obserActualBox(this, environment);
        this.getBdi().getBelief().set(this.getPositionY()*environment.getTaille()+this.getPositionX(),observedBox);
        this.getInferenceEngine().getListOfFacts().add(new Facts(false, true, false, observedBox.getSmell(), observedBox.getWind(),observedBox.getLight(),observedBox.getMonster(),observedBox.getRift(),false));
    }

 // --- GETTERS AND SETTERS ---
    public Effectors getEffectors() {
		return effectors;
	}

	public InferenceManager getInferenceEngine() {
		return inferenceEngine;
	}

    public BDI getBdi(){
        return bdi;
    }
      
    public void setBdi(BDI bdi) {
		this.bdi = bdi;
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

	public Sensors getSensor() {
		return sensor;
	}

    public void mourir(Environment environment) {
        this.setPositionX(0);
        this.setPositionY(0);
        environment.setPerfMeasure(environment.getPerfMeasure() - 10 * environment.getTaille());
    }
}
