package Model;
public class RepositoryException extends Exception {
    public RepositoryException(String message) {
        super("Repository Error - " + message);
    }
}
