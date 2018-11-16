package Environement;

import java.util.ArrayList;

import Environement.Box;

public class Environement {

    private int taille;
    private ArrayList<Box> grid;
    private int perfMeasure;

    public Environement(){
        this.taille = 3;
        this.grid = new ArrayList<Box>();
        for (int i = 0; i <this.taille; i++) {
			for (int j = 0; j < this.taille; j++) {
				grid.set(i*this.taille+j,new Box(false,false,false,false,false));
			}
		}
      //TODO rajouter la génération aléatoire
        this.perfMeasure = 0;
    }

    public void resetEnvironementGrid() {
    	for (int i = 0; i <this.taille; i++) {
			for (int j = 0; j < this.taille; j++) {
				grid.set(i*this.taille+j,new Box(false,false,false,false,false));
			}
		}
    	//TODO rajouter la génération aléatoire
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
