public class MyCustomExceptionUnchecked extends RuntimeException {
    public MyCustomExceptionUnchecked() {
        super();
    }

    public MyCustomExceptionUnchecked(String message) {
        super(message);
    }

    public MyCustomExceptionUnchecked(Throwable cause) {
        super(cause);
    }

    public MyCustomExceptionUnchecked(String message, Throwable cause) {
        super(message, cause);
    }
}
