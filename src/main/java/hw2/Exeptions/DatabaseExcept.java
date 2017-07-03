package hw2.Exeptions;

/**
 * Created by Користувач on 03.07.2017.
 */
public class DatabaseExcept extends RuntimeException {
    public DatabaseExcept(Exception cause) {
        super(cause);
    }

    public DatabaseExcept(String message, Exception cause) {
        super(message, cause);
    }
}

