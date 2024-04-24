package fr.polytech.sim;

import java.util.Random;

/**
 * A clock used to synchronize simulations.
 */
public class Clock {

    private static final Clock  instance = new Clock();

    private final  int time;

    // Constructeur privé
    private Clock(){
        this.time = new Random().nextInt(25);
    }

    /**
     * Acces à l'instance unique de l'horloge
     * @return l'instance singleton de clock
     */

    public static Clock getInstance(){
        return  instance;
    }
    /**
     * Random integer between 0 and 24 inclusive.
     */
    public int getTime() {
        return this.time;
    }
}
