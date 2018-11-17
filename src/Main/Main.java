package Main;

import Environment.*;
import InferenceEngine.*;
import Agent.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Bloc de test de l'ui
        Agent test_Agent = new Agent(2, 2);
        Environment environment = new Environment();
        UI Test_UI = new UI(test_Agent, environment);
        Test_UI.updateUI();
        test_Agent.mourir(environment);
        test_Agent.getEffectors().sortir(test_Agent, environment);
        test_Agent.getEffectors().sortir(test_Agent, environment);
        test_Agent.getEffectors().sortir(test_Agent, environment);
        test_Agent.getEffectors().sortir(test_Agent, environment);
        Test_UI.updateUI();

    }
}
