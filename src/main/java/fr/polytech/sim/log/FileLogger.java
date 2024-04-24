package fr.polytech.sim.log;

import java.io.FileWriter;
import java.io.IOException;

/**
 * File logger.
 */
public class FileLogger extends NamedLogger {
    private static final String FILE_NAME = "logs.txt";

    /**
     * Constructor.
     *
     * @param name  logger name.
     */
    public FileLogger(String name) {
        super(name);
    }

    @Override
    synchronized public void log(String format, Object... args) {
        String message = logMessage(format,args);// Construction du message en utilisant la méthode de la classe de base
        try (FileWriter fileWriter = new FileWriter(FILE_NAME, true)) {
            fileWriter.write(message); // ecrire le message dans le fichier de logs
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
