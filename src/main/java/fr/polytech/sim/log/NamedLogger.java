package fr.polytech.sim.log;

/**
 * Name logger that is supposed to log its name along with each log entry, to
 * facilitate tracing.
 */
public abstract class NamedLogger implements Logger {
    final protected String name;

    /**
     * Constructor.
     *
     * @param name  logger name.
     */
    protected NamedLogger(String name) {
        this.name = name;
    }

    protected String logMessage(String format, Object...args){
        //Méthode modèle pour construire le message de log
        String entry = String.format(format, args);
        return String.format("%s\t%s\n" , this.name, entry);
    }

}
