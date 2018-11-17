package InferenceEngine;

import java.util.ArrayList;

public class Facts {

    private Boolean F_riskless;
    private Boolean F_visited;
    private Boolean F_visitable;
    private Boolean F_smell;
    private Boolean F_wind;
    private Boolean F_light;
    private Boolean F_monster;
    private Boolean F_rift;
    private Boolean F_shooted;
    private Boolean F_deadly;

    public Facts(Boolean F_riskless, Boolean F_visited, Boolean F_visitable, Boolean F_smell, Boolean F_wind, Boolean F_light, Boolean F_monster, Boolean F_rift, Boolean F_deadly)
    {
        this.F_riskless = F_riskless;
        this.F_visited = F_visited;
        this.F_visitable = F_visitable;
        this.F_smell = F_smell;
        this.F_wind = F_wind;
        this.F_light = F_light;
        this.F_monster = F_monster;
        this.F_rift = F_rift;
        this.F_deadly = F_deadly;
    }

    public Boolean getF_riskless(){ return F_riskless; }
    public void setF_riskless(Boolean B_riskless){
        this.F_riskless = B_riskless;
    }

    public Boolean getF_visited(){ return F_visited; }
    public void setF_visited(Boolean B_visited){
        this.F_visited = B_visited;
    }

    public Boolean getF_visitable(){ return F_visitable; }
    public void setF_visitable(Boolean B_visitable){
        this.F_visitable = B_visitable;
    }

    public Boolean getF_smell(){ return F_smell; }
    public void setF_smell(Boolean B_smell){
        this.F_smell = B_smell;
    }

    public Boolean getF_wind(){ return F_wind; }
    public void setF_wind(Boolean B_wind){
        this.F_wind = B_wind;
    }

    public Boolean getF_light(){ return F_light; }
    public void setF_light(Boolean B_light){ this.F_light= B_light; }

    public Boolean getF_monster(){ return F_monster; }
    public void setF_monster(Boolean B_monster){
        this.F_monster = B_monster;
    }

    public Boolean getF_rift(){ return F_rift; }
    public void setF_rift(Boolean B_rift){
        this.F_rift = B_rift;
    }

    public Boolean getF_deadly(){ return F_deadly; }
    public void setF_deadly(Boolean B_deadly){
        this.F_deadly = B_deadly;
    }
}
