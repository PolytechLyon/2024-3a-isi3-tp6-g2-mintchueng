package fr.polytech.sim.cycling;

import fr.polytech.sim.transport.Vehicle;
import fr.polytech.sim.transport.Wheel;

public class TagAlongBike extends Bike {

    private  Bike parentBike;
    private  Bike childBike;
    private Wheel frontWheel;
    private Wheel backWheel ;
    public TagAlongBike(Bike parentBike, Bike childBike) {
        super();
        this.parentBike = parentBike;
        this.childBike = childBike;

        this.frontWheel = new Wheel(this);
        this.backWheel = new Wheel(this);
        this.components.add(parentBike);
        this.components.add(childBike);
        this.components.add(frontWheel);
        this.components.add(backWheel);
    }
    @Override
    public  double getPush(){
        return parentBike.getPush();
    }
}
