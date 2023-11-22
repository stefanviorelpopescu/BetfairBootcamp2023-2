package org.digitalstack.streams;

import java.util.logging.Level;

@FunctionalInterface
public interface LoggerInterface {

    void log(String message, Level logLevel);


}
