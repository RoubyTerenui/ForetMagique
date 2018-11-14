package Agent;

import Environement.Box;

public class Sensors {

    public Sensors()
    {
    }

    public Boolean Is_Light(Box box)
    {
        Boolean light = box.getLight();
        return light;
    }

    public Boolean Is_Wind(Box box)
    {
        Boolean wind = box.getWind();
        return wind;
    }

    public Boolean Is_Smelling(Box box)
    {
        Boolean smell = box.getSmell();
        return smell;
    }
}
