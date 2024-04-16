package fr.polytech.sim.cycling;

import fr.polytech.sim.transport.Vehicle;
import fr.polytech.sim.transport.PushProvider;

/**
 * Abstract bike.
 */
public abstract class Bike extends Vehicle implements PushProvider {

    @Override
    public double getPush() {
        return 25.0;
    }
}
