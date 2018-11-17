package InferenceEngine;

import java.util.ArrayList;

public class Facts {
	
    private Boolean f_riskless;
    private Boolean f_visited;
    private Boolean f_visitable;
    private Boolean f_smell;
    private Boolean f_wind;
    private Boolean f_light;
    private Boolean f_monster;
    private Boolean f_rift;
    private Boolean f_shooted;
	private Boolean f_deadly;

    public Facts(Boolean F_riskless, Boolean F_visited, Boolean F_visitable, Boolean F_smell, Boolean F_wind, Boolean F_light, Boolean F_monster, Boolean F_rift, Boolean F_deadly)
    {
        this.f_riskless = F_riskless;
        this.f_visited = F_visited;
        this.f_visitable = F_visitable;
        this.f_smell = F_smell;
        this.f_wind = F_wind;
        this.f_light = F_light;
        this.f_monster = F_monster;
        this.f_rift = F_rift;
        this.f_shooted=false;
        this.f_deadly = F_deadly;
    }

    public Boolean getF_riskless(){ return f_riskless; }
    public void setF_riskless(Boolean B_riskless){
        this.f_riskless = B_riskless;
    }

    public Boolean getF_visited(){ return f_visited; }
    public void setF_visited(Boolean B_visited){
        this.f_visited = B_visited;
    }

    public Boolean getF_visitable(){ return f_visitable; }
    public void setF_visitable(Boolean B_visitable){
        this.f_visitable = B_visitable;
    }

    public Boolean getF_smell(){ return f_smell; }
    public void setF_smell(Boolean B_smell){
        this.f_smell = B_smell;
    }

    public Boolean getF_wind(){ return f_wind; }
    public void setF_wind(Boolean B_wind){
        this.f_wind = B_wind;
    }

    public Boolean getF_light(){ return f_light; }
    public void setF_light(Boolean B_light){ this.f_light= B_light; }

    public Boolean getF_monster(){ return f_monster; }
    public void setF_monster(Boolean B_monster){
        this.f_monster = B_monster;
    }

    public Boolean getF_rift(){ return f_rift; }
    public void setF_rift(Boolean B_rift){
        this.f_rift = B_rift;
    }

    public Boolean getF_deadly(){ return f_deadly; }
    public void setF_deadly(Boolean B_deadly){
        this.f_deadly = B_deadly;
    }
    
    public Boolean getF_shooted() {
		return f_shooted;
	}

	public void setF_shooted(Boolean f_shooted) {
		this.f_shooted = f_shooted;
	}
}
