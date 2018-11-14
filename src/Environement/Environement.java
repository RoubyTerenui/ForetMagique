package Environement;

import java.util.ArrayList;

public class Environement {

    private int taille;
    private ArrayList<Box> grid;
    private int perfMeasure;

    public Environement(){
        this.taille = 3;
        this.grid = new ArrayList<Box>();
        this.perfMeasure = 0;
    }

    public int getTaille(){
        return taille;
    }

    public void setTaille(int t){
        this.taille = t;
    }

    public ArrayList<Box> getGrid(){
        return grid;
    }

    public void setGrid(ArrayList<Box> g){
        this.grid = g;
    }

    public int getPerfMeasure(){
        return perfMeasure;
    }

    public void setPerfMeasure(int p){
        this.perfMeasure = p;
    }

}
