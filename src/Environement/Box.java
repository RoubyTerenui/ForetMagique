package Environement;

public class Box {

    private Boolean wind;
    private Boolean smell;
    private Boolean light;
    private Boolean monster;
    private Boolean rift;

    public Box(Boolean wind, Boolean smell, Boolean light, Boolean monster, Boolean rift)
    {
        this.wind = wind;
        this.smell = smell;
        this.light = light;
        this.monster = monster;
        this.rift = rift;
    }

    public Boolean getWind(){ return wind; }

    public void setWind(Boolean w){
        this.wind = w;
    }

    public Boolean getSmell(){
        return smell;
    }

    public void setSmell(Boolean s){
        this.smell = s;
    }

    public Boolean getLight(){
        return light;
    }

    public void setLight(Boolean l){
        this.light = l;
    }

    public Boolean getMonster(){
        return monster;
    }

    public void setMonster(Boolean m){
        this.monster = m;
    }

    public Boolean getRift(){
        return rift;
    }

    public void setRift(Boolean r){
        this.rift = r;
    }
}
