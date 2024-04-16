package fr.polytech.sim.log;

/**
 * Console logger.
 */
public class ConsoleLogger extends NamedLogger {

    /**
     * Constructor.
     *
     * @param name  logger name.
     */
    public ConsoleLogger(String name) {
        super(name);
    }

    @Override
    public void log(String format, Object... args) {

        String message = logMessage(format, args);// construction du message ne utilisant la methode de la classe de base
        System.out.print(message);// affichage du message au niveau de la console
    }
}
