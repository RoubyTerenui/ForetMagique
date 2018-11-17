package Environment;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import Agent.Agent;

public class UI extends JFrame{
    // Fields
    private Border Line = BorderFactory.createLineBorder(Color.black, 3);
    private Agent Test_Agent;
    private JFrame Terrain;
    private Environment environment;
    private JPanel GrillePan;
    int h = 0;

    // Constructor
    public UI(Agent Test_Agent, Environment environment) {
        Terrain = new JFrame();
        GrillePan = new JPanel(new GridLayout(environment.getTaille(), environment.getTaille()));
        for (int i = 0; i < environment.getTaille()*environment.getTaille(); i++) {
            JPanel Content = new JPanel();
            Content.setBorder(Line);
            GrillePan.add(Content);
        }
        this.environment = environment;
        this.Test_Agent = Test_Agent;
        GrillePan.setBorder(Line);
        Terrain.add(GrillePan);
        Terrain.setVisible(true);
        Terrain.setExtendedState(Terrain.getExtendedState() | JFrame.MAXIMIZED_BOTH);
    }

    // Other Methods
    public void updateUI() {
        for(int i = 0; i < environment.getTaille(); i++) {
            for(int j = 0; j < environment.getTaille(); j++) {
                GrillePan.getComponent(i * environment.getTaille() + j).setBackground(Color.white);
                if(Test_Agent.getPositionX() * environment.getTaille() + (Test_Agent.getPositionY()) == i * environment.getTaille() + j
                        && Test_Agent.getPositionX() < environment.getTaille() && Test_Agent.getPositionY() < environment.getTaille()) {
                    GrillePan.getComponent(i * environment.getTaille() + j).setBackground(Color.black);
                }
            }
        }
        this.Terrain.setContentPane(GrillePan);
    }

    // Getter and setter
    public Environment getEnvironment(){
        return environment;
    }

    public void setEnvironment(Environment environment){
        this.environment = environment;
    }

    public Agent getTest_Agent(){
        return Test_Agent;
    }

    public void setTest_Agent(Agent test_Agent){
        Test_Agent = test_Agent;
    }

}
