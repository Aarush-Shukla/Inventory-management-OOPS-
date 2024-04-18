package inventory;

public class CustomException extends Exception {

    public CustomException(String message, Throwable cause) {

        super(message, cause);
    }

    public static class FileIOException extends CustomException {
        public FileIOException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    public static class Duplicate extends CustomException {
        public Duplicate(String message, Throwable cause) {
            super(message, cause);
        }
    }

    public static class NotFound extends CustomException {
        public NotFound(String message, Throwable cause) {
            super(message, cause);
        }
    }

    public static class Invalid extends CustomException {
        public Invalid(String message, Throwable cause) {
            super(message, cause);
        }
    }

    public static class NotAType extends CustomException {
        public NotAType(String message, Throwable cause) {
            super(message, cause);
        }
    }
}
