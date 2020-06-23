package DataAccess;

import Business.LoggerSystem;

public final class DataMapperException extends RuntimeException {
    public DataMapperException(final String message) {
        super(message);
        new LoggerSystem().logAction(message);
    }
}
