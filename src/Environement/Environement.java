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
        this.randomGeneration();
        this.perfMeasure = 0;
    }

    public void resetEnvironementGrid() {
    	for (int i = 0; i <this.taille; i++) {
			for (int j = 0; j < this.taille; j++) {
				grid.set(i*this.taille+j, new Box(false,false,false,false,false));
			}
		}
    	this.randomGeneration();
    }
    public void generatePortal() {
    	int posX=(int) Math.floor(Math.random()*this.taille);
    	int posY=(int)Math.floor(Math.random()*this.taille);
    	while(grid.get(posX*this.taille+posY).getRift()) {
    		posX=(int) Math.floor(Math.random()*this.taille);
    		posY=(int)Math.floor(Math.random()*this.taille);
    	}
    	grid.get(posX*this.taille+posY).setLight(true);
    	
    }
    public void randomGeneration() {
    	double proba1 = Math.random() * 9;
    	double proba2 = Math.random() * 9;
    	for (int i = 0; i <this.taille; i++) {
			for (int j = 0; j < this.taille; j++) {
				if(i!=0 || j!=0) {
					if(proba1 < 1) {
						grid.get(i*this.taille+j).setMonster(true);
						if(i == 0) {
							grid.get((i+1)*this.taille+j).setSmell(true);
						}
						else {
							if(i==this.taille-1) {
								grid.get((i-1)*this.taille+j).setSmell(true);
							}
							else {
								grid.get((i-1)*this.taille+j).setSmell(true);
								grid.get((i+1)*this.taille+j).setSmell(true);
							}
						}
						if(j==0) {
							grid.get(i*this.taille+j+1).setSmell(true);
						}
						else {
							if(j==this.taille-1) {
								grid.get(i*this.taille+j-1).setSmell(true);
							}
							else {
								grid.get(i*this.taille+j+1).setSmell(true);
								grid.get(i*this.taille+j-1).setSmell(true);
							}
						}
					}
					else {
						if(proba2<1) {
							grid.get(i*this.taille+j).setRift(true);
							if(i==0) {
								grid.get((i+1)*this.taille+j).setWind(true);
							}
							else {
								if(i==this.taille-1) {
									grid.get((i-1)*this.taille+j).setWind(true);
								}
								else {
									grid.get((i-1)*this.taille+j).setWind(true);
									grid.get((i+1)*this.taille+j).setWind(true);
								}
							}
							if(j==0) {
								grid.get(i*this.taille+j+1).setWind(true);
							}
							else {
								if(j==this.taille-1) {
									grid.get(i*this.taille+j-1).setWind(true);
								}
								else {
									grid.get(i*this.taille+j+1).setWind(true);
									grid.get(i*this.taille+j-1).setWind(true);
								}
							}
						}
					}
				}
			}
    	}
    	this.generatePortal();
    	
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
