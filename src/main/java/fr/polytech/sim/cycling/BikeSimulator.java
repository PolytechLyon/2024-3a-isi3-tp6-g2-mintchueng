package fr.polytech.sim.cycling;

import fr.polytech.sim.Simulation;
import fr.polytech.sim.log.FileLogger;
import fr.polytech.sim.log.Logger;
import fr.polytech.sim.log.LoggerFactory;
import fr.polytech.sim.utils.Context;

import java.util.Iterator;

/**
 * Bike simulation.
 */
    public class BikeSimulator implements Simulation {
    private final Logger logger = LoggerFactory.getLogger("NomDuLogger");

    public void run() {
        // On utilise Context.injectAll pour obtenir toutes les instances de Bike
        Iterator<Bike> bikes = Context.injectAll(Bike.class);
        while (bikes.hasNext()) {
            Bike bike = bikes.next();
            // Log les information pour chaque Bike
            logger.log("Simulating bike: %s ", bike.getClass().getSimpleName());
            logger.log("Bike's speed : %.2f km/h.", bike.getVelocity());
            logger.log("Bike's mass : %.2f kg.", bike.getMass());
        }

    }
}