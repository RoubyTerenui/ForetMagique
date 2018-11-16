package Environement;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import Agent.Agent;

public class UI extends JFrame implements Runnable {

    // Fields
    private Border Line = BorderFactory.createLineBorder(Color.black, 3);
    private Agent Test_Agent;
    private JFrame Terrain;
    private Environement environment;
    private JPanel GrillePan;
    int h = 0;

    // Process
    public void run(){
        while(true){
            try{
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            h++;
        }
    }

    // Constructor
    public UI(Agent Test_Agent, Environement environment) {
        Terrain = new JFrame();
        GrillePan = new JPanel(new GridLayout(3, 3));
        for (int i = 0; i < 100; i++) {
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

    // Getter and setter
    public Environement getEnvironment() {
        return environment;
    }

    public void setEnvironment(Environement environment) {
        this.environment = environment;
    }

    public Agent getTest_Agent() {
        return Test_Agent;
    }

    public void setTest_Agent(Agent test_Agent) {
        Test_Agent = test_Agent;
    }

}
