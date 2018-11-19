import Environment.*;
import InferenceEngine.*;
import Agent.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Bloc de test de l'ui
        Agent test_Agent = new Agent(0, 0);
        Environment environment = new Environment();
        UI Test_UI = new UI(test_Agent, environment);
       while(true) {
    	   Thread.sleep(1000);
    	   Test_UI.updateUI();
    	   test_Agent.executeIntent(environment);
    	   if (environment.getGrid()
					.get(test_Agent.getPositionX() + test_Agent.getPositionY() * environment.getTaille()).getMonster()
					|| environment.getGrid()
							.get(test_Agent.getPositionX() + test_Agent.getPositionY() * environment.getTaille())
							.getRift()) {
					test_Agent.mourir(environment);
			}
       }  
    }
}
