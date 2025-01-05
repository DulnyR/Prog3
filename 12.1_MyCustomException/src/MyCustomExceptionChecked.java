public class MyCustomExceptionChecked extends Exception {
    public MyCustomExceptionChecked() {
        super();
    }

    public MyCustomExceptionChecked(String message) {
        super(message);
    }

    public MyCustomExceptionChecked(Throwable cause) {
        super(cause);
    }

    public MyCustomExceptionChecked(String message, Throwable cause) {
        super(message, cause);
    }
}
