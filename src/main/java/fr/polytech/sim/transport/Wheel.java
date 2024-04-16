package fr.polytech.sim.transport;

import fr.polytech.sim.Clock;
import fr.polytech.sim.cycling.Bike;
import fr.polytech.sim.log.ConsoleLogger;
import fr.polytech.sim.log.Logger;
import fr.polytech.sim.log.LoggerFactory;

import java.util.Objects;

/**
 * A wheel that can be used with different vehicle types.
 */
public class Wheel implements MobileObject {
    private static final double DEFAULT_MASSE = 10;

    private final Clock clock = Clock.getInstance();// permet de récuperer l'instance lors de la creation du singleton
    private final PushProvider drive;
    private final Logger logger = LoggerFactory.getLogger("NomDuLogger");



    /**
     * Constructor.
     *
     * @param drive  the object providing push power.
     */
    public Wheel(PushProvider drive) {
        Objects.requireNonNull(drive, "Bike must not be null.");
        this.drive = drive;
    }

    @Override
    public double getVelocity() {
        final double acceleration = this.drive.getPush() / this.getMass();
        final int time = this.clock.getTime();
        double velocity = time * acceleration;
        this.logger.log("Velocity %.2f Km/h at T %d s.", velocity, time);
        return velocity;
    }

    @Override
    public double getMass() {
        return DEFAULT_MASSE;
    }
}
